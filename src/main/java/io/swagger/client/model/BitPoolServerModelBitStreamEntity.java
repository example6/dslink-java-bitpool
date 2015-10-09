package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolServerModelBitStreamEntity   {
  
  private String streamKey = null;
  private String localIndex = null;
  private String name = null;
  private String description = null;
  private Date registrationDate = null;
  private Date lastTimestamp = null;
  private Date firstTimestamp = null;
  private Double lastValue = null;
  private Double firstValue = null;
  private String poolKey = null;
  private Boolean _public = null;
  private Boolean virtual = null;

public enum VirtualTypeEnum {
  DEFAULT("Default"), POWERTOENERGY("PowerToEnergy"), ACCUMULATINGTOINTERVAL("AccumulatingToInterval");

  private String value;

  VirtualTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private VirtualTypeEnum virtualType = null;
  private Boolean recalculate = null;
  private Boolean weather = null;
  private Boolean owner = null;
  private Integer streamLogsCount = null;

public enum PostProcessingTypeEnum {
  NONE("None"), SMOOTHDATA("SmoothData");

  private String value;

  PostProcessingTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private PostProcessingTypeEnum postProcessingType = null;

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
  @JsonProperty("LastTimestamp")
  public Date getLastTimestamp() {
	  
    return (lastTimestamp == null) ? null : (Date) lastTimestamp.clone();
  }
  public void setLastTimestamp(Date lastTimestamp) {
    this.lastTimestamp = (lastTimestamp == null) ? null : (Date) lastTimestamp.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("FirstTimestamp")
  public Date getFirstTimestamp() {
    return (firstTimestamp == null) ? null : (Date) firstTimestamp.clone();
  }
  public void setFirstTimestamp(Date firstTimestamp) {
    this.firstTimestamp = (firstTimestamp == null) ? null : (Date) firstTimestamp.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("LastValue")
  public Double getLastValue() {
    return lastValue;
  }
  public void setLastValue(Double lastValue) {
    this.lastValue = lastValue;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("FirstValue")
  public Double getFirstValue() {
    return firstValue;
  }
  public void setFirstValue(Double firstValue) {
    this.firstValue = firstValue;
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
  @JsonProperty("VirtualType")
  public VirtualTypeEnum getVirtualType() {
    return virtualType;
  }
  public void setVirtualType(VirtualTypeEnum virtualType) {
    this.virtualType = virtualType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Recalculate")
  public Boolean getRecalculate() {
    return recalculate;
  }
  public void setRecalculate(Boolean recalculate) {
    this.recalculate = recalculate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Weather")
  public Boolean getWeather() {
    return weather;
  }
  public void setWeather(Boolean weather) {
    this.weather = weather;
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
  @JsonProperty("StreamLogsCount")
  public Integer getStreamLogsCount() {
    return streamLogsCount;
  }
  public void setStreamLogsCount(Integer streamLogsCount) {
    this.streamLogsCount = streamLogsCount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("PostProcessingType")
  public PostProcessingTypeEnum getPostProcessingType() {
    return postProcessingType;
  }
  public void setPostProcessingType(PostProcessingTypeEnum postProcessingType) {
    this.postProcessingType = postProcessingType;
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
    sb.append("class BitPoolServerModelBitStreamEntity {\n");
    
    sb.append("    streamKey: ").append(StringUtil.toIndentedString(streamKey)).append("\n");
    sb.append("    localIndex: ").append(StringUtil.toIndentedString(localIndex)).append("\n");
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    registrationDate: ").append(StringUtil.toIndentedString(registrationDate)).append("\n");
    sb.append("    lastTimestamp: ").append(StringUtil.toIndentedString(lastTimestamp)).append("\n");
    sb.append("    firstTimestamp: ").append(StringUtil.toIndentedString(firstTimestamp)).append("\n");
    sb.append("    lastValue: ").append(StringUtil.toIndentedString(lastValue)).append("\n");
    sb.append("    firstValue: ").append(StringUtil.toIndentedString(firstValue)).append("\n");
    sb.append("    poolKey: ").append(StringUtil.toIndentedString(poolKey)).append("\n");
    sb.append("    _public: ").append(StringUtil.toIndentedString(_public)).append("\n");
    sb.append("    virtual: ").append(StringUtil.toIndentedString(virtual)).append("\n");
    sb.append("    virtualType: ").append(StringUtil.toIndentedString(virtualType)).append("\n");
    sb.append("    recalculate: ").append(StringUtil.toIndentedString(recalculate)).append("\n");
    sb.append("    weather: ").append(StringUtil.toIndentedString(weather)).append("\n");
    sb.append("    owner: ").append(StringUtil.toIndentedString(owner)).append("\n");
    sb.append("    streamLogsCount: ").append(StringUtil.toIndentedString(streamLogsCount)).append("\n");
    sb.append("    postProcessingType: ").append(StringUtil.toIndentedString(postProcessingType)).append("\n");
    sb.append("    dataType: ").append(StringUtil.toIndentedString(dataType)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
