package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolServerModelBitStationEntity   {
  
  private Integer stationID = null;
  private String stationName = null;
  private Date registrationDate = null;
  private String poolKey = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StationID")
  public Integer getStationID() {
    return stationID;
  }
  public void setStationID(Integer stationID) {
    this.stationID = stationID;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StationName")
  public String getStationName() {
    return stationName;
  }
  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("RegistrationDate")
  public Date getRegistrationDate() {
    return (registrationDate == null) ? null : (Date) registrationDate.clone();
  }
  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = (registrationDate == null) ? null : (Date) registrationDate.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("PoolKey")
  public String getPoolKey() {
    return poolKey;
  }
  public void setPoolKey(String poolKey) {
    this.poolKey = poolKey;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolServerModelBitStationEntity {\n");
    
    sb.append("    stationID: ").append(StringUtil.toIndentedString(stationID)).append("\n");
    sb.append("    stationName: ").append(StringUtil.toIndentedString(stationName)).append("\n");
    sb.append("    registrationDate: ").append(StringUtil.toIndentedString(registrationDate)).append("\n");
    sb.append("    poolKey: ").append(StringUtil.toIndentedString(poolKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
