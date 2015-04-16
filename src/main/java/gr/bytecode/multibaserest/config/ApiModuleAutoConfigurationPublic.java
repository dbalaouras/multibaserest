package gr.bytecode.multibaserest.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Configuration for the Public API
 */
@Configuration
public class ApiModuleAutoConfigurationPublic extends
        ApiModuleAutoConfigurationBase<RestConfigPublic> {

    public static final String API_MODULE_PUBLIC_DISPATCHER_SERVLET_BEAN_NAME =
            "apiModulePublicDispatcherServlet";
    public static final String API_MODULE_PUBLIC_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME =
            "apiModulePublicDispatcherServletRegistration";

    // The path pf this specific API module
    public static final String MODULE_PATH = "/public";

    /**
     * Create the {@link DispatcherServlet}
     *
     * @return
     */
    @Bean(name = API_MODULE_PUBLIC_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet apiModuleADispatcherServlet() {
        return createApiModuleDispatcherServlet();
    }

    /**
     * Register a {@link ServletRegistrationBean}
     *
     * @return
     */
    @Bean(name = API_MODULE_PUBLIC_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
    public ServletRegistrationBean apiModuleADispatcherServletRegistration() {
        return createApiModuleDispatcherServletRegistration(apiModuleADispatcherServlet());
    }

    /*
     * (non-Javadoc)
     * 
     * @see gr.bytecode.multibaserest.config.AbstractApiModuleAutoConfiguration#
     * getApiModuleDispatcherServletBeanName()
     */
    @Override
    protected String getApiModuleDispatcherServletBeanName() {
        return API_MODULE_PUBLIC_DISPATCHER_SERVLET_BEAN_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see gr.bytecode.multibaserest.config.AbstractApiModuleAutoConfiguration#getApiModulePath()
     */
    @Override
    protected String getApiModulePath() {
        return MODULE_PATH;
    }

    /*
     * (non-Javadoc)
     * 
     * @see gr.bytecode.multibaserest.config.AbstractApiModuleAutoConfiguration#
     * getApiModuleConfigurationClass()
     */
    @Override
    protected Class<RestConfigPublic> getApiModuleConfigurationClass() {
        return RestConfigPublic.class;
    }

}
