package gr.bytecode.multibaserest.config;



/**
 * Provides Configuration for the RESTful APIs
 * 
 * @author Dimi Balaouras
 * @copyright Bytecode.gr 2015
 */
public class RestConfigPublic extends RestConfigBase {

    /*
     * (non-Javadoc)
     * 
     * @see gr.bytecode.multibaserest.config.AbstractRestConfig#getBaseURI()
     */
    @Override
    public String getModuleBaseURI() {

        return ApiModuleAutoConfigurationPublic.BASE_API_PATH + "/"
                + ApiModuleAutoConfigurationPublic.MODULE_PATH;
    }

}
