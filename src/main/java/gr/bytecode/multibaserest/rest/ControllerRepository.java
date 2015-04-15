package gr.bytecode.multibaserest.rest;

import gr.bytecode.multibaserest.domain.Agent;
import gr.bytecode.multibaserest.domain.Controller;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * A {@link Repository} of {@link Agent} Resources
 * 
 * @author Dimi Balaouras
 * @copyright Bytecode.gr 2015
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "controllers", path = "controllers")
interface ControllerRepository extends PagingAndSortingRepository<Controller, Long> {

}
