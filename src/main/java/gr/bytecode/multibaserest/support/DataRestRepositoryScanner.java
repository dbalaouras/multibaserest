package gr.bytecode.multibaserest.support;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Scans for {@link RepositoryRestResource} Interfaces
 */
public class DataRestRepositoryScanner extends ClassPathScanningCandidateComponentProvider {

    /**
     * Constructor
     */
    public DataRestRepositoryScanner() {

        // Do not enable default scanners
        super(false);

        addIncludeFilter(new AnnotationTypeFilter(RepositoryRestResource.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#
     * isCandidateComponent(org.springframework.beans.factory.annotation.AnnotatedBeanDefinition)
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }
}
