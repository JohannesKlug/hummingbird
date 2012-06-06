/**
 *
 */
package org.hbird.application.parameterarchive.repositories;

import org.hbird.core.commons.tmtc.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mark Doyle
 *
 */
public interface ParameterRepository extends MongoRepository<Parameter<?>, Long> {

	Page<Parameter<?>> findByReceivedTimeBetween(final long startDate, final long endDate, Pageable pageable);

}
