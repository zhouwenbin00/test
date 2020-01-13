package dom4j;

import lombok.Data;
import lombok.ToString;

/**
 * @author zwb
 */
@Data
@ToString
public class DefinitionField extends NameAndDesc {

    private String clazz;
    private boolean list = false;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }
}
