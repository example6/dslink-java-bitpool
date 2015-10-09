package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.TypeRef;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.BitPoolServerModelBitStreamEntity;
import io.swagger.client.model.BitPoolInfrastructureDTOBPRegisterStream;
import io.swagger.client.model.BitPoolInfrastructureDTOUpdateStreamDto;
import java.util.Date;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class StreamsApi {
  private ApiClient apiClient;

  public StreamsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public StreamsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Create a new stream in a specific pool and station
   * 
   * @param poolKey 
   * @param stationId 
   * @param stream 
   * @return BitPoolServerModelBitStreamEntity
   */
  public BitPoolServerModelBitStreamEntity streamsRegisterBitStream (String poolKey, Integer stationId, BitPoolInfrastructureDTOBPRegisterStream stream) throws ApiException {
    Object postBody = stream;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling streamsRegisterBitStream");
     }
     
     // verify the required parameter 'stationId' is set
     if (stationId == null) {
        throw new ApiException(400, "Missing the required parameter 'stationId' when calling streamsRegisterBitStream");
     }
     
     // verify the required parameter 'stream' is set
     if (stream == null) {
        throw new ApiException(400, "Missing the required parameter 'stream' when calling streamsRegisterBitStream");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/stations/{stationId}/streams".replaceAll("\\{format\\}","json")
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
      "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    TypeRef returnType = new TypeRef<BitPoolServerModelBitStreamEntity>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Return list of streams inside a specific pool
   * 
   * @param poolKey 
   * @return List<BitPoolServerModelBitStreamEntity>
   */
  public List<BitPoolServerModelBitStreamEntity> streamsGetRegisteredBitStreamsAll (String poolKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling streamsGetRegisteredBitStreamsAll");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/streams".replaceAll("\\{format\\}","json")
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

    

    
    
    TypeRef returnType = new TypeRef<List<BitPoolServerModelBitStreamEntity>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Return list of streams inside a specific station
   * 
   * @param poolKey 
   * @param stationId
   * @return List<BitPoolServerModelBitStreamEntity>
   */
  public List<BitPoolServerModelBitStreamEntity> streamsGetRegisteredBitStreamsAll (String poolKey, Integer stationId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'poolKey' is set
     if (poolKey == null) {
        throw new ApiException(400, "Missing the required parameter 'poolKey' when calling streamsGetRegisteredBitStreamsAll");
     }
     
     // verify the required parameter 'stationId' is set
     if (stationId == null) {
        throw new ApiException(400, "Missing the required parameter 'stationId' when calling streamsRegisterBitStream");
     }
     
    // create path and map variables
    String path = "/public/v2/pools/{poolKey}/stations/{stationId}/streams".replaceAll("\\{format\\}","json")
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

    

    
    
    TypeRef returnType = new TypeRef<List<BitPoolServerModelBitStreamEntity>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Return a specific stream
   * 
   * @param streamKey 
   * @return BitPoolServerModelBitStreamEntity
   */
  public BitPoolServerModelBitStreamEntity streamsGetRegisteredBitStream (String streamKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling streamsGetRegisteredBitStream");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "streamKey" + "\\}", apiClient.escapeString(streamKey.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<BitPoolServerModelBitStreamEntity>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Update a stream name or description
   * 
   * @param streamKey 
   * @param data 
   * @return String
   */
  public String streamsUpdateStream (String streamKey, BitPoolInfrastructureDTOUpdateStreamDto data) throws ApiException {
    Object postBody = data;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling streamsUpdateStream");
     }
     
     // verify the required parameter 'data' is set
     if (data == null) {
        throw new ApiException(400, "Missing the required parameter 'data' when calling streamsUpdateStream");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "streamKey" + "\\}", apiClient.escapeString(streamKey.toString()));

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
    return apiClient.invokeAPI(path, "PUT", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Delete a specific stream (including all logs)
   * 
   * @param streamKey 
   * @return String
   */
  public String streamsDeleteStream (String streamKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling streamsDeleteStream");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "streamKey" + "\\}", apiClient.escapeString(streamKey.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<String>() {};
    return apiClient.invokeAPI(path, "DELETE", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Return last timestamp of logs in specific stream
   * 
   * @param streamKey 
   * @return Date
   */
  public Date streamsGetLastTimestamp (String streamKey) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling streamsGetLastTimestamp");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}/lastTimestamp".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "streamKey" + "\\}", apiClient.escapeString(streamKey.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<Date>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
