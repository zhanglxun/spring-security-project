package com.sense.base.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* 菜单表
* @TableName s_menu
*/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_menu")
@Schema(description = "角色管理表")
public class Menu implements Serializable {

    /**
    * 菜单的主键ID
    */
    @NotNull(message="[菜单的主键ID]不能为空")
    @Schema(description = "菜单的主键ID")
    private Long id;
    /**
    * 排序ID
    */
    @Schema(description = "排序ID")
    private Integer sortId;
    /**
    * 机构菜单排序ID(子系统)
    */
    @Schema(description = "机构菜单排序ID(子系统)")
    private Integer orgSortId;
    /**
    * 父级ID
    */
    @Schema(description = "父级ID")
    private Long parentId;
    /**
    * 机构菜单上下级关系(子系统)
    */
    @Schema(description = "机构菜单上下级关系(子系统)")
    private Long orgParentId;
    /**
    * 菜单名称
    */
    @NotBlank(message="[菜单名称]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @Schema(description = "菜单名称")
    private String name;
    /**
    * 机构菜单别名(子系统)
    */
    @Size(max= 64,message="编码长度不能超过64")
    @Schema(description = "机构菜单别名(子系统)")

    private String orgAliasName;
    /**
    * 菜单URL
    */
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description = "菜单URL")
    private String url;
    /**
    * 1 机构菜单 2非机构菜单3:不属于任何(子系统)
    */
    @Schema(description = "1 机构菜单 2非机构菜单3:不属于任何(子系统)")
    private Integer orgFlag;
    /**
    * 1 机构定制菜单 2平台定制菜单,3不属于任何(子系统)
    */
    @Schema(description = "1 机构定制菜单 2平台定制菜单,3不属于任何(子系统)")
    private Integer isOrg;
    /**
    * 菜单Class属性对应菜单的图标样式
    */
    @Size(max= 50,message="编码长度不能超过50")
    @Schema(description = "菜单Class属性对应菜单的图标样式")
    private String iconClass;
    /**
    * 功能类型1：系统菜单，2：业务菜单
    */
    @Schema(description = "功能类型1：系统菜单，2：业务菜单")
    private Integer functionType;
    /**
    * 备注描述
    */
    @Size(max= 100,message="编码长度不能超过100")
    @Schema(description = "备注描述")
    private String description;
    /**
    * 系统标识（1 私有化  2 SaaS ）
    */
    @Schema(description = "系统标识（1 私有化  2 SaaS ）")
    private Integer systemCode;
    /**
    * 创建人
    */
    @Schema(description = "创建人")
    private Long createId;
    /**
    * 创建时间
    */
    @Schema(description = "创建时间")
    private Date createTime;
    /**
    * 修改人
    */
    @Schema(description = "修改人")
    private Long modifyId;
    /**
    * 修改时间
    */
    @NotNull(message="[修改时间]不能为空")
    @Schema(description = "修改时间")
    private Date modifyTime;


}
