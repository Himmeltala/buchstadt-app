package com.buchstadt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.buchstadt.constant.ValidMsgVals;
import com.buchstadt.constant.ValidRegexVals;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description:
 * @package: com.buchstadt.pojo
 * @author: zheng
 * @date: 2023/8/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("addresses")
public class Address {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @Size(max = 30, message = ValidMsgVals.PROVINCE)
    private String province;

    @Size(max = 30, message = ValidMsgVals.CITY)
    private String city;

    @Size(max = 30, message = ValidMsgVals.AREA)
    private String area;

    @Size(max = 50, message = ValidMsgVals.STREET)
    private String street;

    @NotNull
    @Pattern(regexp = ValidRegexVals.PHONE, message = ValidMsgVals.PHONE)
    private String phone;

    @NotNull(message = ValidMsgVals.HOLDER)
    private String holder;

    @NotNull(message = ValidMsgVals.DETAIL)
    private String detail;

    @TableField("create_date")
    private Timestamp createDate;

    @TableField("modify_date")
    private Timestamp modifyDate;

    @Size(max = 1)
    @Pattern(regexp = "[01]", message = "值只能是 0 或 1！")
    @TableField("is_default")
    private Integer isDefault;

}
