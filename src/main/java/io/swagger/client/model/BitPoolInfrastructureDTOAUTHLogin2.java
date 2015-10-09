package io.swagger.client.model;

import io.swagger.client.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOAUTHLogin2   {
  
  private String username = null;
  private String password = null;
  private String organisation = null;
  private String place = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
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
    sb.append("class BitPoolInfrastructureDTOAUTHLogin2 {\n");
    
    sb.append("    username: ").append(StringUtil.toIndentedString(username)).append("\n");
    sb.append("    password: ").append(StringUtil.toIndentedString(password)).append("\n");
    sb.append("    organisation: ").append(StringUtil.toIndentedString(organisation)).append("\n");
    sb.append("    place: ").append(StringUtil.toIndentedString(place)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
