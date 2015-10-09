package io.swagger.client.model;

import io.swagger.client.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-09-23T16:25:54.634-07:00")
public class BitPoolInfrastructureDTOBPRegisterPool   {
  
  private String poolname = null;
  private Boolean _public = null;
  private Boolean virtual = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Poolname")
  public String getPoolname() {
    return poolname;
  }
  public void setPoolname(String poolname) {
    this.poolname = poolname;
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitPoolInfrastructureDTOBPRegisterPool {\n");
    
    sb.append("    poolname: ").append(StringUtil.toIndentedString(poolname)).append("\n");
    sb.append("    _public: ").append(StringUtil.toIndentedString(_public)).append("\n");
    sb.append("    virtual: ").append(StringUtil.toIndentedString(virtual)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
