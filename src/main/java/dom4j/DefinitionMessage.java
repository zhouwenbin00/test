package dom4j;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwb
 */
@Data
public class DefinitionMessage extends NameAndDesc {

    private String msgId;
    private List<DefinitionField> fields = new ArrayList<>();

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public List<DefinitionField> getFields() {
        return fields;
    }

    public void setFields(List<DefinitionField> fields) {
        this.fields = fields;
    }
}
