package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolServerDTOStreamLogDto   {
  
  private String streamKey = null;
  private Date timestamp = null;
  private Double value = null;

  
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
  @JsonProperty("Timestamp")
  public Date getTimestamp() {
    return (timestamp == null) ? null : (Date) timestamp.clone();
  }
  public void setTimestamp(Date timestamp) {
    this.timestamp = (timestamp == null) ? null : (Date) timestamp.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Value")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolServerDTOStreamLogDto {\n");
    
    sb.append("    streamKey: ").append(StringUtil.toIndentedString(streamKey)).append("\n");
    sb.append("    timestamp: ").append(StringUtil.toIndentedString(timestamp)).append("\n");
    sb.append("    value: ").append(StringUtil.toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
