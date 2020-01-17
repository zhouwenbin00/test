package dom4j;

import freemaker.FreemakerTest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** @author zwb */
public class Dom4jTest {

    private static final String ProtocolsSrcDir = "E:\\project\\trunk_XLZ_skill\\Protocols";
    private static final String genDir = "E:\\project\\trunk_XLZ_skill\\protocolsa\\protocols";

    private static Map<String, DefinitionFile> definitionFileMap = new HashMap<>();

    public static void main(String[] args) throws DocumentException {
        File src = new File(ProtocolsSrcDir);
        for (File file : src.listFiles()) {
            if (!file.getName().endsWith(".xml")) {
                continue;
            }
            if (file.isDirectory()) {
                continue;
            }
            String absolutePath = file.getAbsolutePath();
            parseFile(absolutePath);
        }
        System.out.println(1);

        genCode();
    }

    private static void genCode() {
        FreemakerTest freemakerTest = new FreemakerTest();
        definitionFileMap.forEach(
                (k, v) -> freemakerTest.main(v, genDir));
    }

    private static void parseFile(String fileName) throws DocumentException {
        SAXReader reader = new SAXReader();
        File file = new File(fileName);
        Document document = reader.read(file);
        Element rootElement = document.getRootElement();

        DefinitionFile definitionFile = new DefinitionFile();
        definitionFile.setName(rootElement.attributeValue("namespace"));
        definitionFile.setDesc(rootElement.attributeValue("explain"));
        Iterator it = rootElement.elementIterator();
        while (it.hasNext()) {
            Element next = (Element) it.next();
//            if (next.getName().equalsIgnoreCase("struct")) {
//                definitionFile.getMessages().add(createStruct(next));
//            } else if (next.getName().equalsIgnoreCase("message")) {
//                definitionFile.getMessages().add(createMessage(next));
//            }
            definitionFile.getMessages().add(createMessage(next));
        }
        definitionFileMap.put(definitionFile.getName(), definitionFile);
    }

    private static DefinitionMessage createMessage(Element element) {
        DefinitionMessage definitionMessage = new DefinitionMessage();
        definitionMessage.setName(element.attributeValue("name"));
        definitionMessage.setDesc(element.attributeValue("explain"));
        definitionMessage.setMsgId(element.attributeValue("msgId"));
        Iterator it = element.elementIterator();
        while (it.hasNext()) {
            Element next = (Element) it.next();
            DefinitionField definitionField = createField(next);
            definitionMessage.getFields().add(definitionField);
        }
        return definitionMessage;
    }

    public static DefinitionStruct createStruct(Element element) {
        DefinitionStruct definitionStruct = new DefinitionStruct();
        definitionStruct.setName(element.attributeValue("name"));
        definitionStruct.setDesc(element.attributeValue("explain"));

        Iterator it = element.elementIterator();
        while (it.hasNext()) {
            Element next = (Element) it.next();
            DefinitionField definitionField = createField(next);
            definitionStruct.getFields().add(definitionField);
        }
        return definitionStruct;
    }

    public static DefinitionField createField(Element element) {
        DefinitionField definitionField = new DefinitionField();
        definitionField.setName(element.attributeValue("name"));
        definitionField.setDesc(element.attributeValue("explain"));
        definitionField.setClazz(convertClazz(element.attributeValue("class")));
        definitionField.setList(element.getName().equalsIgnoreCase("list"));
        return definitionField;
    }

    public static String convertClazz(String src) {
        switch (src) {
            case "int":
                return "int32";
            case "long":
                return "int64";
            case "byte":
                return "bytes";
            case "short":
                return "int32";
        }
        return src;
    }
}
