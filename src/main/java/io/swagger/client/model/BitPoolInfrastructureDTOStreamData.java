package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.*;
import io.swagger.client.model.BitPoolServerModelSlog;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOStreamData   {
  
  private String streamKey = null;
  private List<BitPoolServerModelSlog> values = new ArrayList<BitPoolServerModelSlog>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StreamKey")
  public String getStreamKey() {
    return streamKey;
  }
  public void setStreamKey(String streamKey) {
    this.streamKey = streamKey;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Values")
  public List<BitPoolServerModelSlog> getValues() {
    return values;
  }
  public void setValues(List<BitPoolServerModelSlog> values) {
    this.values = values;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureDTOStreamData {\n");
    
    sb.append("    streamKey: ").append(StringUtil.toIndentedString(streamKey)).append("\n");
    sb.append("    values: ").append(StringUtil.toIndentedString(values)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
