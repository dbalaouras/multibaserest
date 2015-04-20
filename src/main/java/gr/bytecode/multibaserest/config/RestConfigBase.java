package gr.bytecode.multibaserest.config;

import java.text.SimpleDateFormat;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Provides Configuration for the RESTful APIs
 */
@EnableJpaRepositories
public class RestConfigBase extends RepositoryRestMvcConfiguration {

    /**
     * The default date format to use when JSON-serializing the RESTful API Resources. (See
     * {@link http ://download.java.net/jdk7/archive/b123/docs/api/java/text/SimpleDateFormat.html})
     */
    static final SimpleDateFormat REST_API_DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX");


    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration#
     * configureRepositoryRestConfiguration
     * (org.springframework.data.rest.core.config.RepositoryRestConfiguration)
     */
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration#
     * configureJacksonObjectMapper(com.fasterxml.jackson.databind.ObjectMapper)
     */
    @Override
    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        super.configureJacksonObjectMapper(objectMapper);

        // Set the preferred date format globally; will be used when JSON encoding all REST
        // responses.
        objectMapper.setDateFormat(REST_API_DATE_FORMAT);
    }
}
