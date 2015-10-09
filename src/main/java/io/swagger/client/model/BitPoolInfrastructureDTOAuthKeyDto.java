package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOAuthKeyDto   {
  
  private String organisation = null;
  private String value = null;
  private String place = null;
  private Date date = null;
  private String impersonatedBy = null;

public enum KeyTypeEnum {
  STANDARD("Standard"), APIREADWRITE("ApiReadWrite"), APIREAD("ApiRead"), APIREADLIMITED("ApiReadLimited");

  private String value;

  KeyTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private KeyTypeEnum keyType = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Organisation")
  public String getOrganisation() {
    return organisation;
  }
  public void setOrganisation(String organisation) {
    this.organisation = organisation;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Value")
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Place")
  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Date")
  public Date getDate() {
    return (date == null) ? null : (Date) date.clone();
  }
  public void setDate(Date date) {
    this.date = (date == null) ? null : (Date) date.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ImpersonatedBy")
  public String getImpersonatedBy() {
    return impersonatedBy;
  }
  public void setImpersonatedBy(String impersonatedBy) {
    this.impersonatedBy = impersonatedBy;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("KeyType")
  public KeyTypeEnum getKeyType() {
    return keyType;
  }
  public void setKeyType(KeyTypeEnum keyType) {
    this.keyType = keyType;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureDTOAuthKeyDto {\n");
    
    sb.append("    organisation: ").append(StringUtil.toIndentedString(organisation)).append("\n");
    sb.append("    value: ").append(StringUtil.toIndentedString(value)).append("\n");
    sb.append("    place: ").append(StringUtil.toIndentedString(place)).append("\n");
    sb.append("    date: ").append(StringUtil.toIndentedString(date)).append("\n");
    sb.append("    impersonatedBy: ").append(StringUtil.toIndentedString(impersonatedBy)).append("\n");
    sb.append("    keyType: ").append(StringUtil.toIndentedString(keyType)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
