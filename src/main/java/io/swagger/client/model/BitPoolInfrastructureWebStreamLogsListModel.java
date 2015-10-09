package io.swagger.client.model;

import io.swagger.client.StringUtil;
import java.util.*;
import io.swagger.client.model.BitPoolServerModelValueEntity;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureWebStreamLogsListModel   {
  
  private List<BitPoolServerModelValueEntity> data = new ArrayList<BitPoolServerModelValueEntity>();
  private Long total = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Data")
  public List<BitPoolServerModelValueEntity> getData() {
    return data;
  }
  public void setData(List<BitPoolServerModelValueEntity> data) {
    this.data = data;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Total")
  public Long getTotal() {
    return total;
  }
  public void setTotal(Long total) {
    this.total = total;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureWebStreamLogsListModel {\n");
    
    sb.append("    data: ").append(StringUtil.toIndentedString(data)).append("\n");
    sb.append("    total: ").append(StringUtil.toIndentedString(total)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
