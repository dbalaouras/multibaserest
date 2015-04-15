package gr.bytecode.multibaserest.rest;

import gr.bytecode.multibaserest.support.DataRestRepositoryScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.Path;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.mapping.RepositoryResourceMappings;
import org.springframework.data.rest.core.mapping.ResourceMetadata;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * {@link ResourceProcessor} for the Root elements.
 * 
 * @author Dimi Balaouras
 * @copyright Bytecode.gr 2015
 */
@Component
public class FilteredResourcesProcessor implements ResourceProcessor<RepositoryLinksResource> {

    /**
     * A logger
     */
    protected Logger log = LoggerFactory.getLogger(getClass().getName());

    /**
     * The package where the Filter Controllers reside
     */
    public static String FILTER_CONTROLLERS_LOOKUP_PACKAGE = "gr.bytecode.multibaserest.rest";

    /**
     * Will hold the links to the private Resources
     */
    private List<Link> privateLinks = new ArrayList<Link>();

    /**
     * Will hold the links to the public Resources
     */
    private List<Link> publicLinks = new ArrayList<Link>();

    /**
     * Autowired {@link Repositories} bean
     */
    @Autowired
    Repositories repositories;

    /**
     * Autowired {@link RepositoryResourceMappings} bean
     */
    @Autowired
    private RepositoryResourceMappings repositoryRestConfiguration;

    /**
     * Dynamically discovers controllers annotated with {@link FilterController} and registers them
     * to a local {@link Map} for runtime use
     */
    @PostConstruct
    public void discoverResourceFilterControllers() {

        // Create a Repository component provider/scanner
        ClassPathScanningCandidateComponentProvider componentProvider =
                new DataRestRepositoryScanner();

        // Set the scanner to search for Repository beans
        componentProvider.addIncludeFilter(new AnnotationTypeFilter(RepositoryRestResource.class));

        // Iterate all detected classes
        Set<BeanDefinition> repositoryBeans =
                componentProvider.findCandidateComponents(FILTER_CONTROLLERS_LOOKUP_PACKAGE);

        // Iterate the repositories
        for (BeanDefinition bd : repositoryBeans) {

            // Retrieve the class name of the bean
            String loadedClassName = bd.getBeanClassName();

            try {
                // Create the class and load the annotation
                Class<?> cls = Class.forName(loadedClassName);

                // Get the mapping
                ResourceMetadata mapping = repositoryRestConfiguration.getMappingFor(cls);

                if (mapping != null) {

                    // Private resource
                    Path path = mapping.getPath();

                    // Create a link
                    Link resourceLink = new Link(path.toString(), mapping.getRel());

                    // Check if this is a private resource
                    PrivateResource privateAnnotation = cls.getAnnotation(PrivateResource.class);

                    if (privateAnnotation != null) {
                        privateLinks.add(resourceLink);
                    } else {
                        publicLinks.add(resourceLink);
                    }

                }


            } catch (ClassNotFoundException e) {

                // This should not happen
                log.debug("Failed to get the Class definition of " + loadedClassName, e);
            }

        }

    }

    @Autowired
    private ApplicationContext appContext;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.hateoas.ResourceProcessor#process(org.springframework.hateoas.ResourceSupport
     * )
     */
    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {


        boolean isRequestingPublic = true;

        if (isRequestingPublic) {
            
            // Remove all links from the Resource
            resource.removeLinks();

            // Add the public links
            resource.add(publicLinks);

        } else {
            // to nothing
        }


        return resource;
    }
}
