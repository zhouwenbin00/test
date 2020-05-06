package com.zwb.demo.gencode.define;

import lombok.Data;

import java.util.List;

@Data
public class TableDefine {

    private  String tableName;
    private  String packageName;
    private  String tableDesc;
    private  String javaName;
    private  String keyType;
    private List<String> pkg;
    private ColumnDefine key;


}
