package gr.bytecode.multibaserest.rest;

import gr.bytecode.multibaserest.domain.Agent;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * A {@link Repository} of {@link Agent} Resources
 */
@PrivateResource
@Repository
@RepositoryRestResource(collectionResourceRel = "agents", path = "agents")
interface AgentRepository extends PagingAndSortingRepository<Agent, Long> {

}
