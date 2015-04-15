package gr.bytecode.multibaserest.config;


/**
 * Provides Configuration for the RESTful APIs
 * 
 * @author Dimi Balaouras
 * @copyright Bytecode.gr 2015
 */
class RestConfigPrivate extends RestConfigBase {

    /*
     * (non-Javadoc)
     * 
     * @see gr.bytecode.multibaserest.config.AbstractRestConfig#getBaseURI()
     */
    @Override
    public String getModuleBaseURI() {

        return ApiModuleAutoConfigurationPrivate.BASE_API_PATH + "/"
                + ApiModuleAutoConfigurationPrivate.MODULE_PATH;
    }

}
