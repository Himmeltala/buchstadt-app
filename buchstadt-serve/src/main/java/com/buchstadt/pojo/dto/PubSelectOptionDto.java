package com.buchstadt.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @package: com.buchstadt.pojo.dto
 * @author: zheng
 * @date: 2023/9/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PubSelectOptionDto {

    private String label;
    private String value;

}
