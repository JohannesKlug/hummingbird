///**
// *
// */
//package org.hbird.application.parameterarchive.repositories;
//
//import org.hbird.core.commons.tmtc.Parameter;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
///**
// * @author Mark Doyle
// *
// */
//public interface ParameterRepository extends MongoRepository<Parameter<?>, Long> {
//
//	/**
//	 * Uses the @link{MongoRepository} to return a list of parameters filtered by received time. The number of results is divided into
//	 * {@link Page}s given the number of results requested. The methd returns a list of parameters in the requested page.
//	 */
//	Page<Parameter<?>> findByReceivedTimeBetween(final long startDate, final long endDate, Pageable pageable);
//
// }
