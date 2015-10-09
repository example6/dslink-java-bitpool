package io.swagger.client.model;

import io.swagger.client.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOCreateAuthKeyDto   {
  

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
  private String place = null;

  
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureDTOCreateAuthKeyDto {\n");
    
    sb.append("    keyType: ").append(StringUtil.toIndentedString(keyType)).append("\n");
    sb.append("    place: ").append(StringUtil.toIndentedString(place)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
