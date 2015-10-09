package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.TypeRef;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.BitPoolInfrastructureDTOAuthKeyDto;
import io.swagger.client.model.BitPoolInfrastructureDTOCreateAuthKeyDto;
import io.swagger.client.model.BitPoolInfrastructureDTOAUTHLogin2;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class AuthenticationApi {
  private ApiClient apiClient;

  public AuthenticationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AuthenticationApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Return list of authentication keys available for user
   * 
   * @return List<BitPoolInfrastructureDTOAuthKeyDto>
   */
  public List<BitPoolInfrastructureDTOAuthKeyDto> authenticationGetAuthKeys () throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
    // create path and map variables
    String path = "/public/v2/AuthKeys".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    
    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    TypeRef returnType = new TypeRef<List<BitPoolInfrastructureDTOAuthKeyDto>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Create a new authentication key with given parameters
   * 
   * @param data 
   * @return String
   */
  public String authenticationCreateAuthKey (BitPoolInfrastructureDTOCreateAuthKeyDto data) throws ApiException {
    Object postBody = data;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'data' is set
     if (data == null) {
        throw new ApiException(400, "Missing the required parameter 'data' when calling authenticationCreateAuthKey");
     }
     
    // create path and map variables
    String path = "/public/v2/AuthKeys".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    TypeRef returnType = new TypeRef<String>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Delete a specific authentication key
   * 
   * @param key 
   * @return void
   */
  public void authenticationCancelAuthKey (String key) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'key' is set
     if (key == null) {
        throw new ApiException(400, "Missing the required parameter 'key' when calling authenticationCancelAuthKey");
     }
     
    // create path and map variables
    String path = "/public/v2/AuthKeys/{key}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    apiClient.invokeAPI(path, "DELETE", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, null);
    
    


  }
  
  /**
   * Create login request which returns an authentication token
   * 
   * @param data 
   * @return String
   */
  public String authenticationLogin (BitPoolInfrastructureDTOAUTHLogin2 data) throws ApiException {
    Object postBody = data;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'data' is set
     if (data == null) {
        throw new ApiException(400, "Missing the required parameter 'data' when calling authenticationLogin");
     }
     
    // create path and map variables
    String path = "/public/v2/Login".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    TypeRef returnType = new TypeRef<String>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
