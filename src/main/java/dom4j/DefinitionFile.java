package dom4j;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwb
 */
@Data
@ToString
public class DefinitionFile extends NameAndDesc{
//    private List<DefinitionStruct> structs = new ArrayList<>();
    private List<DefinitionMessage> messages = new ArrayList<>();

//    public List<DefinitionStruct> getStructs() {
//        return structs;
//    }

//    public void setStructs(List<DefinitionStruct> structs) {
//        this.structs = structs;
//    }

    public List<DefinitionMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<DefinitionMessage> messages) {
        this.messages = messages;
    }
}
