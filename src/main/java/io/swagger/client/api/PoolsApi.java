package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.TypeRef;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.BitPoolServerModelBitPoolEntity;
import io.swagger.client.model.BitPoolInfrastructureDTOBPRegisterPool;
import io.swagger.client.model.BitPoolServerModelBitStationEntity;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class PoolsApi {
  private ApiClient apiClient;

  public PoolsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PoolsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Return list of pools available to user
   * 
   * @return List<BitPoolServerModelBitPoolEntity>
   */
  public List<BitPoolServerModelBitPoolEntity> poolsGetPools () throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
    // create path and map variables
    String path = "/public/v2/pools".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<List<BitPoolServerModelBitPoolEntity>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Create a new pool
   * 
   * @param pool 
   * @return BitPoolServerModelBitPoolEntity
   */
  public BitPoolServerModelBitPoolEntity poolsRegisterPool (BitPoolInfrastructureDTOBPRegisterPool pool) throws ApiException {
    Object postBody = pool;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'pool' is set
     if (pool == null) {
        throw new ApiException(400, "Missing the required parameter 'pool' when calling poolsRegisterPool");
     }
     
    // create path and map variables
    String path = "/public/v2/pools".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<BitPoolServerModelBitPoolEntity>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Return a specific pool
   * 
   * @param poolKey 
   * @return BitPoolServerModelBitPoolEntity
   */
  public BitPoolServerModelBitPoolEntity poolsGetPool (String poolKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsGetPool");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<BitPoolServerModelBitPoolEntity>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Delete a specific pool
   * 
   * @param poolKey 
   * @return void
   */
  public void poolsDeletePool (String poolKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsDeletePool");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()));

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
   * Return list of stations inside specific pool
   * 
   * @param poolKey 
   * @return List<BitPoolServerModelBitStationEntity>
   */
  public List<BitPoolServerModelBitStationEntity> poolsGetStations (String poolKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsGetStations");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/stations".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<List<BitPoolServerModelBitStationEntity>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Create new station inside a specific pool
   * 
   * @param poolKey 
   * @param stationName 
   * @return BitPoolServerModelBitStationEntity
   */
  public BitPoolServerModelBitStationEntity poolsRegisterStation (String poolKey, String stationName) throws ApiException {
    Object postBody = stationName;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsRegisterStation");
     }
     
     // verify the required parameter 'stationName' is set
     if (stationName == null) {
        throw new ApiException(400, "Missing the required parameter 'stationName' when calling poolsRegisterStation");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/stations".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<BitPoolServerModelBitStationEntity>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Return specific station inside a specific pool
   * 
   * @param poolKey 
   * @param stationId 
   * @return BitPoolServerModelBitStationEntity
   */
  public BitPoolServerModelBitStationEntity poolsGetStation (String poolKey, Integer stationId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsGetStation");
     }
     
     // verify the required parameter 'stationId' is set
     if (stationId == null) {
        throw new ApiException(400, "Missing the required parameter 'stationId' when calling poolsGetStation");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/stations/{stationId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()))
      .replaceAll("\\{" + "stationId" + "\\}", apiClient.escapeString(stationId.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<BitPoolServerModelBitStationEntity>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Delete a specific station inside a specific pool
   * 
   * @param poolKey 
   * @param stationId 
   * @return void
   */
  public void poolsDeleteStation (String poolKey, Integer stationId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsDeleteStation");
     }
     
     // verify the required parameter 'stationId' is set
     if (stationId == null) {
        throw new ApiException(400, "Missing the required parameter 'stationId' when calling poolsDeleteStation");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/stations/{stationId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()))
      .replaceAll("\\{" + "stationId" + "\\}", apiClient.escapeString(stationId.toString()));

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
   * Update specific pool with new timezone
   * 
   * @param poolKey 
   * @param timezone 
   * @return void
   */
  public void poolsSetPoolTimezone (String poolKey, String timezone) throws ApiException {
    Object postBody = timezone;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling poolsSetPoolTimezone");
     }
     
     // verify the required parameter 'timezone' is set
     if (timezone == null) {
        throw new ApiException(400, "Missing the required parameter 'timezone' when calling poolsSetPoolTimezone");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/timezone".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "poolKey" + "\\}", apiClient.escapeString(poolKey.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    apiClient.invokeAPI(path, "PUT", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, null);
    
    


  }
  
}
