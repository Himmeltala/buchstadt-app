package com.buchstadt.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuchCommentVo {

    private String type;
    private Float id;
    private String diggOp;
    private String buryOp;
    private Float digg;
    private Float bury;

}
