package com.sense.base.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
* 角色表
* @TableName s_roles
*/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_roles")
@Schema(description = "角色管理表")
public class Roles extends Model<Roles> {

    /**
    * 角色id
    */
    @NotNull(message="[角色id]不能为空")
    @Schema(description = "角色id")
    private Long id;
    /**
    * 角色名称
    */
    @Size(max= 64,message="编码长度不能超过64")
    @Schema(description="角色名称")
    private String name;
    /**
    * 角色类别:字典配置
    */
    @Schema(description="角色类别:字典配置")
    private Integer type;
    /**
    * 登录的客户端
    */
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description="登录的客户端")
    private String login_client;
    /**
    * 机构ID(SaaS子系统)
    */
    @Schema(description="机构ID(SaaS子系统)")
    private Long orgId;
    /**
    * 0：平台角色，1：saas角色
    */
    @Schema(description="0：平台角色，1：saas角色")
    private Integer orgFlag;
    /**
    * 角色描述
    */
    @Size(max= 500,message="编码长度不能超过500")
    @Schema(description="角色描述")
    private String description;
    /**
    * 创建时间
    */
    @Schema(description="创建时间")
    private Date createTime;
    /**
    * 创建人ID
    */
    @Schema(description="创建人ID")
    private Long createId;
    /**
    * 修改时间
    */
    @Schema(description="修改时间")
    private Date modifyTime;
    /**
    * 修改人ID
    */
    @Schema(description="修改人ID")
    private Long modifyId;



}
