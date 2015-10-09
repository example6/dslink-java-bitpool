package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.TypeRef;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.BitPoolInfrastructureDTOStreamData;
import java.util.*;
import io.swagger.client.model.BitPoolInfrastructureWebStreamLogsListModel;
import java.util.Date;
import io.swagger.client.model.BitPoolServerModelSlog;
import io.swagger.client.model.BitPoolServerDTOStreamLogDto;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class LogsApi {
  private ApiClient apiClient;

  public LogsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public LogsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Bulk upload logs into many streams
   * 
   * @param data 
   * @return String
   */
  public String logsUploadBitStreams (List<BitPoolInfrastructureDTOStreamData> data) throws ApiException {
    Object postBody = data;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'data' is set
     if (data == null) {
        throw new ApiException(400, "Missing the required parameter 'data' when calling logsUploadBitStreams");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/logs".replaceAll("\\{format\\}","json");

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
   * Return logs inside a stream
   * 
   * @param streamKey 
   * @param from 
   * @param to 
   * @param take 
   * @param skip 
   * @param minValue 
   * @param maxValue 
   * @param postProcessIfAvailable 
   * @return BitPoolInfrastructureWebStreamLogsListModel
   */
  public BitPoolInfrastructureWebStreamLogsListModel logsGetStreamValues (String streamKey, Date from, Date to, Integer take, Integer skip, Double minValue, Double maxValue, Boolean postProcessIfAvailable) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling logsGetStreamValues");
     }
     
     // verify the required parameter 'from' is set
     if (from == null) {
        throw new ApiException(400, "Missing the required parameter 'from' when calling logsGetStreamValues");
     }
     
     // verify the required parameter 'to' is set
     if (to == null) {
        throw new ApiException(400, "Missing the required parameter 'to' when calling logsGetStreamValues");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}/logs".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "streamKey" + "\\}", apiClient.escapeString(streamKey.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "from", from));
    
    queryParams.addAll(apiClient.parameterToPairs("", "to", to));
    
    queryParams.addAll(apiClient.parameterToPairs("", "take", take));
    
    queryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
    
    queryParams.addAll(apiClient.parameterToPairs("", "minValue", minValue));
    
    queryParams.addAll(apiClient.parameterToPairs("", "maxValue", maxValue));
    
    queryParams.addAll(apiClient.parameterToPairs("", "postProcessIfAvailable", postProcessIfAvailable));
    

    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    TypeRef returnType = new TypeRef<BitPoolInfrastructureWebStreamLogsListModel>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * Upload logs into a specific stream
   * 
   * @param streamKey 
   * @param data 
   * @return String
   */
  public String logsUploadBitStream (String streamKey, List<BitPoolServerModelSlog> data) throws ApiException {
    Object postBody = data;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling logsUploadBitStream");
     }
     
     // verify the required parameter 'data' is set
     if (data == null) {
        throw new ApiException(400, "Missing the required parameter 'data' when calling logsUploadBitStream");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}/logs".replaceAll("\\{format\\}","json")
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
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * return logs inside a stream, a variety of properties help to filter and aggregate the logs which are returned
   * 
   * @param streamKey 
   * @param dataTimeRange 
   * @param dataFrom 
   * @param dataTo 
   * @param dataAggregationType 
   * @param dataAggregationPeriod 
   * @param dataTimeZone 
   * @param dataAutoTimeZone 
   * @param dataNullWhenNoData 
   * @param dataMultiplier 
   * @param dataPostProcessIfAvailable 
   * @return List<BitPoolServerDTOStreamLogDto>
   */
  public List<BitPoolServerDTOStreamLogDto> logsGetStreamValuesWithAggregation (String streamKey, String dataTimeRange, Date dataFrom, Date dataTo, String dataAggregationType, String dataAggregationPeriod, String dataTimeZone, Boolean dataAutoTimeZone, Boolean dataNullWhenNoData, Double dataMultiplier, Boolean dataPostProcessIfAvailable) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'streamKey' is set
     if (streamKey == null) {
        throw new ApiException(400, "Missing the required parameter 'streamKey' when calling logsGetStreamValuesWithAggregation");
     }
     
    // create path and map variables
    String path = "/public/v2/streams/{streamKey}/logs/aggregated".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "streamKey" + "\\}", apiClient.escapeString(streamKey.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "data.timeRange", dataTimeRange));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.from", dataFrom));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.to", dataTo));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.aggregationType", dataAggregationType));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.aggregationPeriod", dataAggregationPeriod));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.timeZone", dataTimeZone));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.autoTimeZone", dataAutoTimeZone));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.nullWhenNoData", dataNullWhenNoData));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.multiplier", dataMultiplier));
    
    queryParams.addAll(apiClient.parameterToPairs("", "data.postProcessIfAvailable", dataPostProcessIfAvailable));
    

    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] { "api" };

    

    
    
    TypeRef returnType = new TypeRef<List<BitPoolServerDTOStreamLogDto>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
