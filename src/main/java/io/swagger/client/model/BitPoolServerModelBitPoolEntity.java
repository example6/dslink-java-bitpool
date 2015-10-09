package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolServerModelBitPoolEntity   {
  
  private String poolKey = null;
  private String name = null;
  private Date registrationDate = null;
  private Boolean virtual = null;
  private Boolean _public = null;
  private Boolean owner = null;

public enum AccessModeEnum {
  ADMINISTRATOR("Administrator"), OWNER("Owner"), COOWNER("CoOwner"), CONTRIBUTOR("Contributor"), READER("Reader"), NONE("None");

  private String value;

  AccessModeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private AccessModeEnum accessMode = null;
  private Float utcOffset = null;
  private String timeZone = null;

  
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

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
  @JsonProperty("Virtual")
  public Boolean getVirtual() {
    return virtual;
  }
  public void setVirtual(Boolean virtual) {
    this.virtual = virtual;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Public")
  public Boolean getPublic() {
    return _public;
  }
  public void setPublic(Boolean _public) {
    this._public = _public;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Owner")
  public Boolean getOwner() {
    return owner;
  }
  public void setOwner(Boolean owner) {
    this.owner = owner;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AccessMode")
  public AccessModeEnum getAccessMode() {
    return accessMode;
  }
  public void setAccessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UtcOffset")
  public Float getUtcOffset() {
    return utcOffset;
  }
  public void setUtcOffset(Float utcOffset) {
    this.utcOffset = utcOffset;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("TimeZone")
  public String getTimeZone() {
    return timeZone;
  }
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolServerModelBitPoolEntity {\n");
    
    sb.append("    poolKey: ").append(StringUtil.toIndentedString(poolKey)).append("\n");
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("    registrationDate: ").append(StringUtil.toIndentedString(registrationDate)).append("\n");
    sb.append("    virtual: ").append(StringUtil.toIndentedString(virtual)).append("\n");
    sb.append("    _public: ").append(StringUtil.toIndentedString(_public)).append("\n");
    sb.append("    owner: ").append(StringUtil.toIndentedString(owner)).append("\n");
    sb.append("    accessMode: ").append(StringUtil.toIndentedString(accessMode)).append("\n");
    sb.append("    utcOffset: ").append(StringUtil.toIndentedString(utcOffset)).append("\n");
    sb.append("    timeZone: ").append(StringUtil.toIndentedString(timeZone)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
