package com.zwb.demo.gencode.define;

import lombok.Data;

@Data
public class ColumnDefine {

    private String columnName;
    private String columnDesc;
    private String javaType;
    private String javaName;
    private Boolean nullable;
}
