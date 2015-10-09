package io.swagger.client.model;

import io.swagger.client.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOTimeZoneDto   {
  
  private String id = null;
  private Double utcOffset = null;
  private String displayName = null;
  private String displayNameUTC = null;
  private String displayNameTitle = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UtcOffset")
  public Double getUtcOffset() {
    return utcOffset;
  }
  public void setUtcOffset(Double utcOffset) {
    this.utcOffset = utcOffset;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("DisplayName")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("DisplayNameUTC")
  public String getDisplayNameUTC() {
    return displayNameUTC;
  }
  public void setDisplayNameUTC(String displayNameUTC) {
    this.displayNameUTC = displayNameUTC;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("DisplayNameTitle")
  public String getDisplayNameTitle() {
    return displayNameTitle;
  }
  public void setDisplayNameTitle(String displayNameTitle) {
    this.displayNameTitle = displayNameTitle;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureDTOTimeZoneDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    utcOffset: ").append(StringUtil.toIndentedString(utcOffset)).append("\n");
    sb.append("    displayName: ").append(StringUtil.toIndentedString(displayName)).append("\n");
    sb.append("    displayNameUTC: ").append(StringUtil.toIndentedString(displayNameUTC)).append("\n");
    sb.append("    displayNameTitle: ").append(StringUtil.toIndentedString(displayNameTitle)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
