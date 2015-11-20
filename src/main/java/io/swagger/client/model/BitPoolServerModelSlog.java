package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolServerModelSlog   {
  
  private Date timestamp = null;
  private Double value = null;
  private Boolean calculated = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Ts")
  public Date getTimestamp() {
    return (timestamp == null) ? null : (Date) timestamp.clone();
  }
  public void setTimestamp(Date timestamp) {
    this.timestamp = (timestamp == null) ? null : (Date) timestamp.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Val")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Calculated")
  public Boolean getCalculated() {
    return calculated;
  }
  public void setCalculated(Boolean calculated) {
    this.calculated = calculated;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolServerModelSlog {\n");
    
    sb.append("    timestamp: ").append(StringUtil.toIndentedString(timestamp)).append("\n");
    sb.append("    value: ").append(StringUtil.toIndentedString(value)).append("\n");
    sb.append("    calculated: ").append(StringUtil.toIndentedString(calculated)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
