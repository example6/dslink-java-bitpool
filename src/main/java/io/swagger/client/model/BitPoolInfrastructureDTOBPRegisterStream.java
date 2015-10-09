package io.swagger.client.model;

import io.swagger.client.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOBPRegisterStream   {
  
  private String localIndex = null;
  private String streamName = null;
  private String description = null;
  private Boolean _public = null;

public enum DataTypeEnum {
  DECIMAL("Decimal"), STRING("String");

  private String value;

  DataTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private DataTypeEnum dataType = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("LocalIndex")
  public String getLocalIndex() {
    return localIndex;
  }
  public void setLocalIndex(String localIndex) {
    this.localIndex = localIndex;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StreamName")
  public String getStreamName() {
    return streamName;
  }
  public void setStreamName(String streamName) {
    this.streamName = streamName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
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
  @JsonProperty("DataType")
  public DataTypeEnum getDataType() {
    return dataType;
  }
  public void setDataType(DataTypeEnum dataType) {
    this.dataType = dataType;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureDTOBPRegisterStream {\n");
    
    sb.append("    localIndex: ").append(StringUtil.toIndentedString(localIndex)).append("\n");
    sb.append("    streamName: ").append(StringUtil.toIndentedString(streamName)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    _public: ").append(StringUtil.toIndentedString(_public)).append("\n");
    sb.append("    dataType: ").append(StringUtil.toIndentedString(dataType)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
