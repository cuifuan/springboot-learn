package store.zabbix.bran.ekko.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "ip_data")
@NoArgsConstructor
@Accessors(chain = true)
public class IPData {

    @Id
    @ApiModelProperty(value = "编号")
    private Long ipNo;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "IP地址")
    private String ipAddress;

    @ApiModelProperty(value = "端口")
    private Integer port;

    @ApiModelProperty(value = "服务器地址")
    private String serverAddress;

    @ApiModelProperty(value = "是否匿名")
    private String anonymous;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "速度")
    private String speed;

    @ApiModelProperty(value = "连接时间")
    private String connTime;

    @ApiModelProperty(value = "存活时间")
    private String survivalTime;

    @ApiModelProperty(value = "验证时间")
    private String postTime;

}
