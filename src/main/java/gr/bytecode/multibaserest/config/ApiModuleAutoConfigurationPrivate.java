package gr.bytecode.multibaserest.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Configuration for the Private API
 */
@Configuration
public class ApiModuleAutoConfigurationPrivate extends
        ApiModuleAutoConfigurationBase<RestConfigPrivate> {

    public static final String API_MODULE_A_DISPATCHER_SERVLET_BEAN_NAME =
            "apiModulePrivateDispatcherServlet";

    public static final String API_MODULE_PRIVATE_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME =
            "apiModulePrivateDispatcherServletRegistration";

    // the path of this Specific module
    public static final String MODULE_PATH = "/private";

    /**
     * Create the {@link DispatcherServlet}
     *
     * @return
     */
    @Bean(name = API_MODULE_A_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet apiModuleADispatcherServlet() {
        return createApiModuleDispatcherServlet();
    }

    /**
     * Register a {@link ServletRegistrationBean}
     *
     * @return
     */
    @Bean(name = API_MODULE_PRIVATE_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
    public ServletRegistrationBean apiModuleADispatcherServletRegistration() {
        return createApiModuleDispatcherServletRegistration(apiModuleADispatcherServlet());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ca.apm.acc.configserver.config.AbstractApiModuleAutoConfiguration#
     * getApiModuleDispatcherServletBeanName()
     */
    @Override
    protected String getApiModuleDispatcherServletBeanName() {
        return API_MODULE_A_DISPATCHER_SERVLET_BEAN_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ca.apm.acc.configserver.config.AbstractApiModuleAutoConfiguration#getApiModulePath()
     */
    @Override
    protected String getApiModulePath() {
        return MODULE_PATH;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ca.apm.acc.configserver.config.AbstractApiModuleAutoConfiguration#
     * getApiModuleConfigurationClass()
     */
    @Override
    protected Class<RestConfigPrivate> getApiModuleConfigurationClass() {
        return RestConfigPrivate.class;
    }

}
