package dom4j;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwb
 */
@Data
public class DefinitionStruct  extends NameAndDesc{
    private List<DefinitionField> fields = new ArrayList<>();

    public List<DefinitionField> getFields() {
        return fields;
    }

    public void setFields(List<DefinitionField> fields) {
        this.fields = fields;
    }
}
