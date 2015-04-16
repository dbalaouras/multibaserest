package gr.bytecode.multibaserest.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Base class for Spring Data REST API module configurations
 * 
 * @param <T>
 */
public abstract class ApiModuleAutoConfigurationBase<T> {

    /**
     * Spring Application context (Autowired)
     */
    @Autowired
    protected ApplicationContext applicationContext;

    /**
     * HTTP SErver properties (Autowired)
     */
    @Autowired
    protected ServerProperties server;

    /**
     * 
     */
    @Autowired(required = false)
    protected MultipartConfigElement multipartConfig;

    /**
     * The base url of the APi
     */
    public static final String BASE_API_PATH = "api";

    /**
     *
     * @return
     */
    protected DispatcherServlet createApiModuleDispatcherServlet() {

        AnnotationConfigWebApplicationContext webContext =
                new AnnotationConfigWebApplicationContext();

        webContext.setParent(applicationContext);
        webContext.register(getApiModuleConfigurationClass());
        webContext.refresh();


        return new DispatcherServlet(webContext);
    }

    /**
     * Registers a given API module
     *
     * @param apiModuleDispatcherServlet
     * @return
     */
    protected ServletRegistrationBean createApiModuleDispatcherServletRegistration(
            DispatcherServlet apiModuleDispatcherServlet) {
        ServletRegistrationBean registration =
                new ServletRegistrationBean(
                        apiModuleDispatcherServlet,
                        this.server.getServletMapping() + BASE_API_PATH + getApiModulePath() + "/*",
                        this.server.getServletMapping() + BASE_API_PATH + getApiModulePath() + "*");

        registration.setName(getApiModuleDispatcherServletBeanName());
        if (this.multipartConfig != null) {
            registration.setMultipartConfig(this.multipartConfig);
        }
        return registration;
    }

    /**
     * Get the name of the module configuration bean
     *
     * @return
     */
    protected abstract String getApiModuleDispatcherServletBeanName();

    /**
     * Get the path to the REST API module
     *
     * @return
     */
    protected abstract String getApiModulePath();

    /**
     * Get the type of the REST module configuration class
     *
     * @return
     */
    protected abstract Class<T> getApiModuleConfigurationClass();

}
