/** The Hummingbird marshaller supports the encoding / decoding of data 
 * to / from structured data sets, i.e. a binary data stream with a 
 * predefined structure. The implementation is generic, i.e. can be used 
 * to encode / decode any simple java types into a binary stream, but has 
 * been created for mission control data following the CCSDS concepts of 
 * a space data link.
 * 
 * User Guide:
 * Create an instance of a model factory and parse this in the constructor
 * of the marshaller, thereafter parse the data to the marshaller, identifying
 * which container should process the data (this example use the XTCE model 
 * factory);
 *   IMarshaller marshaller = new ContainerProcessor(new XtceModelFactory());
 *   marshaller.unmarshall("TMFrame", data);
 *   
 * 
 * 
 * To encode (marshall) / decode (unmarshall) data to / from a data set
 * use the IMarshaller interface.
 * 
 * To support data structures defined in a separate format, implement a
 * component satisfying the IModelFactory interface.
 * 
 * Concepts:
 * A space link consists of a sequence of fixed length 'Frames' as defined in
 * the CCSDS Space Link standard. Each frame contains a header, a body containing
 * telemetry packets, and an optional tail containing control words / CRC.
 * 
 * The body of the frame contain zero or more CCSDS space packets. Each packet 
 * consists of a header, an optional secondary header and a data body holding
 * parameters.
 * 
 * Where as the structure of the frame and the packet headers are completely
 * standardized through CCSDS, the packet data body is specific to the mission.
 * 
 * The marshaller does not assume that the structure of the CCSDS is followed,
 * i.e. any data structure can be encoded / decoded. The data structures are 
 * defined by the user of the marshaller.
 * 
 * The marshaller uses the IModelFactory to obtain the container references to
 * use for encoding / decoding. The specific implementation of the model factory
 * depends on the underlying format used to define the data structures such as
 * the CCSDS XTCE format, the ESA MIB format, a Spring mapping file or an 
 * appropiatary format. The model factory is responsible for reading the specific 
 * format and creating the POJO hierarchy needed by the marshaller.
 * 
 * The hierarchy consists of an ordered tree structure of 'containers'. A container 
 * is a sequence of one or more other containers or a parameter container. A 
 * parameter container is the leaf in the tree structure. All branches in the tree
 * ends in a parameter. Another view of a frame is thus a sequence of parameters, 
 * logically ordered into a set of containers, which in turn are ordered into other
 * containers, etc.
 * 
 * In this hierarchy a frame is the top most container. A packet is a sub container
 * of the frame. The marshaller can encode / decode a full frame by accessing the top
 * most container, or a packet or a single parameter by accessing a lower level 
 * container.
 * 
 * A binary stream is injected into this hierarchy in the form of a java data set. 
 * The data is processed ordered, depth first, i.e. the data is parsed to the first 
 * subcontainer, which parses it to its first subcontainer, etc.
 * 
 * The order is that each container processes its subcontainers in the order they
 * have been added to its internal list. In the case of a CCSDS data stream, the
 * first entries will be CCSDS frame header and its parameters. Thereafter follows
 * the packets. 
 * 
 * A container can be a repeated container, in which case it will process multiple
 * times. The iteration is controlled by a parameter, i.e. the counter can itself
 * be a parameter extracted from the data stream. This can for example be used to
 * process the telemetry packet container of a frame in the case where multiple
 * packets are in on frame, or to extract a super commutated parameter multiple
 * times.
 * 
 * A container does not hold any information about its position in the a data stream. 
 * It receives a data stream and reads its size from the start of this stream. The
 * stream, reduced with the read part, is thereafter returned. A container can thus 
 * be included in different other containers, extracting data from a separate offset
 * in the data stream.
 * 
 * The containers only process if their defined restrictions are all meet. A
 * restriction is a parameter with a predefined constant value that must be 
 * satisfied. This is used to create 'switches' in the processing, i.e. defined that
 * certain subcontainers shall process the stream and others not. This can
 * for example be used to switch between which packet container is used to extract
 * the content of the frame body based on the APID parameter contained in the
 * packet header. The marshaller will process first the frame header, then the 
 * first packet, which process the packet header extracting among others the APID,
 * then process one of many registered packet data containers depending on what
 * value the APID has.
 * 
 * As an example consider the following structure;
 * [ Frame                                                                              ]
 * [ Frame Header][Frame Body                                               ][Frame Tail]
 * [a][b][c][d][e][Packet Header][Packet Body                               ][x][y      ]
 *                [f][g][h][APID][?APID=1 [j*10]] [?APID=2 [k]] [?APID=3 [n]]
 *                                       
 * The container 'Frame' has three subcontainer, 'Frame Header', 'Frame Body' and
 * 'Frame Tail'. Each of these are again broken into sub containers. The 'Frame Header'
 * consists of the parameter containers 'a' to 'e'. The frame body of the containers
 * 'packet header' and 'packet body'. The container 'frame tail' of the parameters
 * 'x' and 'y'. At the next level the packet header is defined as consisting of the
 * parameter containers 'f' to 'APID'. The 'packet body' container has three subcontainers
 * each with a condition '?APID=X' and a substructure of parameters.
 * 
 * To process a frame the data set should be injected to the 'Frame' container. it will
 * parse the tree structure in the defined order, i.e. first the Frame header will be 
 * processed, which will extract the parameters 'a' to 'e'. Then the frame body will be
 * processed, which will iterate through its subcontainers in order, so first the packet
 * header will be extracted and the parameters 'f' to APID'. In this example the APID=1.
 * When the packet body container is processed, all subcontainers evaluate their 
 * restrictions only the container with APID=2 meets these and is processed. The parameter
 * container is a repeated container and is extracted 10 times.
 * 
 * Notice that the marshaller does not hold any knowledge of whether a container 
 * represents a frame, packet, parameter or something else. This is part of the separation
 * of concerns behind the marshaller; All processing depending on interpretation a container 
 * in a specific way that depends on the actual data structure definition must be implemented
 * above this library, i.e. in a domain specific model.
 * 
 * Through the interface of the marshaller observers can register interest in a container.
 * The observer will be notified when the container value changes. Notice that the observer
 * is notified immediately when the value changes, i.e. the complete data stream may not
 * yet have been processed, only the part until the location of the relevant container. To 
 * notify of completed processing the marshaller provides an additional registration interface
 * for notification of completion of processing.
 * 
 * An observer can obtain a reference to the containers through the IMarshaller interface. The
 * lookup is based on the name given to the container. The container will hold the latest
 * value set, i.e. the last value processed.
 * 
 */
package com.logica.hummingbird.marshaller;
