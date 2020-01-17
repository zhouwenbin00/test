package Message;

option java_package = "message";
option java_outer_classname = "${name}";

// ${desc}

<#--<#list structs as s>-->
<#--// ${s.desc}-->
<#--message ${s.name} {-->
    <#--<#list s.fields as fields>-->
        <#--<#if fields.list??>-->
            <#--<#if fields.list==true>-->
    <#--repeated ${fields.clazz} ${fields.name} = ${fields_index+1}; //${fields.desc}-->
            <#--<#else >-->
    <#--required ${fields.clazz} ${fields.name} = ${fields_index+1}; //${fields.desc}-->
            <#--</#if>-->
        <#--</#if>-->
    <#--</#list>-->
<#--}-->

<#--</#list>-->
<#list messages as m>
// ${m.desc}
message ${m.name} {
    <#if m.msgId??>
    enum MsgID {eMsgID = ${m.msgId};};
    </#if>
    <#list m.fields as fields>
        <#if fields.list??>
            <#if fields.list==true>
    repeated ${fields.clazz} ${fields.name} = ${fields_index+1}; //${fields.desc}
            <#else >
    required ${fields.clazz} ${fields.name} = ${fields_index+1}; //${fields.desc}
            </#if>
        </#if>
    </#list>
}

</#list>

