package com.buchstadt.pojo.vo;

import com.buchstadt.constant.ValidMsgVals;
import com.buchstadt.constant.ValidRegexVals;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressVo {

    private Integer id;

    @NotNull
    private List<String> zone;

    @NotNull
    @Pattern(regexp = ValidRegexVals.PHONE, message = ValidMsgVals.PHONE)
    private String phone;

    @NotNull(message = ValidMsgVals.HOLDER)
    private String holder;

    @NotNull(message = ValidMsgVals.DETAIL)
    private String detail;

}
