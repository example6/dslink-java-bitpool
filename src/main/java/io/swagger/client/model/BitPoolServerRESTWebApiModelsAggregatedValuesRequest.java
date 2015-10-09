package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolServerRESTWebApiModelsAggregatedValuesRequest   {
  

public enum TimeRangeEnum {
  CUSTOM("Custom"), THISHOUR("ThisHour"), TODAY("Today"), THISWEEK("ThisWeek"), THISMONTH("ThisMonth"), THISYEAR("ThisYear"), LASTHOUR("LastHour"), YESTERDAY("Yesterday"), LASTWEEK("LastWeek"), LASTMONTH("LastMonth"), LASTYEAR("LastYear"), ROLLINGDAY("RollingDay"), ROLLINGWEEK("RollingWeek"), ROLLINGMONTH("RollingMonth"), ROLLINGYEAR("RollingYear");

  private String value;

  TimeRangeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private TimeRangeEnum timeRange = null;
  private Date from = null;
  private Date to = null;

public enum AggregationTypeEnum {
  AVG("Avg"), SUM("Sum"), DIFF("Diff"), MIN("Min"), MAX("Max"), HIGHDURATION("HighDuration"), LOWDURATION("LowDuration"), NONE("None"), MINTIMEOCCURENCE("MinTimeOccurence"), MAXTIMEOCCURENCE("MaxTimeOccurence"), FIRST("First"), LAST("Last"), ACCUM("Accum");

  private String value;

  AggregationTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private AggregationTypeEnum aggregationType = null;

public enum AggregationPeriodEnum {
  HOURLY("Hourly"), DAILY("Daily"), WEEKLY("Weekly"), MONTHLY("Monthly"), YEARLY("Yearly"), NONE("None"), MINUTE("Minute"), FINANCIALYEARLY("FinancialYearly"), mINUTES15("Minutes15");

  private String value;

  AggregationPeriodEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private AggregationPeriodEnum aggregationPeriod = null;
  private String timeZone = null;
  private Boolean autoTimeZone = null;
  private Boolean nullWhenNoData = null;
  private Double multiplier = null;
  private Boolean postProcessIfAvailable = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("timeRange")
  public TimeRangeEnum getTimeRange() {
    return timeRange;
  }
  public void setTimeRange(TimeRangeEnum timeRange) {
    this.timeRange = timeRange;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("from")
  public Date getFrom() {
    return (from == null) ? null : (Date) from.clone();
  }
  public void setFrom(Date from) {
    this.from = (from == null) ? null : (Date) from.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("to")
  public Date getTo() {
    return (to == null) ? null : (Date) to.clone();
  }
  public void setTo(Date to) {
    this.to = (to == null) ? null : (Date) to.clone();
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("aggregationType")
  public AggregationTypeEnum getAggregationType() {
    return aggregationType;
  }
  public void setAggregationType(AggregationTypeEnum aggregationType) {
    this.aggregationType = aggregationType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("aggregationPeriod")
  public AggregationPeriodEnum getAggregationPeriod() {
    return aggregationPeriod;
  }
  public void setAggregationPeriod(AggregationPeriodEnum aggregationPeriod) {
    this.aggregationPeriod = aggregationPeriod;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("timeZone")
  public String getTimeZone() {
    return timeZone;
  }
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("autoTimeZone")
  public Boolean getAutoTimeZone() {
    return autoTimeZone;
  }
  public void setAutoTimeZone(Boolean autoTimeZone) {
    this.autoTimeZone = autoTimeZone;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("nullWhenNoData")
  public Boolean getNullWhenNoData() {
    return nullWhenNoData;
  }
  public void setNullWhenNoData(Boolean nullWhenNoData) {
    this.nullWhenNoData = nullWhenNoData;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("multiplier")
  public Double getMultiplier() {
    return multiplier;
  }
  public void setMultiplier(Double multiplier) {
    this.multiplier = multiplier;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("postProcessIfAvailable")
  public Boolean getPostProcessIfAvailable() {
    return postProcessIfAvailable;
  }
  public void setPostProcessIfAvailable(Boolean postProcessIfAvailable) {
    this.postProcessIfAvailable = postProcessIfAvailable;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolServerRESTWebApiModelsAggregatedValuesRequest {\n");
    
    sb.append("    timeRange: ").append(StringUtil.toIndentedString(timeRange)).append("\n");
    sb.append("    from: ").append(StringUtil.toIndentedString(from)).append("\n");
    sb.append("    to: ").append(StringUtil.toIndentedString(to)).append("\n");
    sb.append("    aggregationType: ").append(StringUtil.toIndentedString(aggregationType)).append("\n");
    sb.append("    aggregationPeriod: ").append(StringUtil.toIndentedString(aggregationPeriod)).append("\n");
    sb.append("    timeZone: ").append(StringUtil.toIndentedString(timeZone)).append("\n");
    sb.append("    autoTimeZone: ").append(StringUtil.toIndentedString(autoTimeZone)).append("\n");
    sb.append("    nullWhenNoData: ").append(StringUtil.toIndentedString(nullWhenNoData)).append("\n");
    sb.append("    multiplier: ").append(StringUtil.toIndentedString(multiplier)).append("\n");
    sb.append("    postProcessIfAvailable: ").append(StringUtil.toIndentedString(postProcessIfAvailable)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
