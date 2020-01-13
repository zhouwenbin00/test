package freemaker;

import dom4j.DefinitionFile;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/** @author zwb */
public class FreemakerTest {

    public void main(DefinitionFile w, String dir) {
        try {
            String src = "E:\\project\\test\\src\\main\\resources";
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(src));
            Template template = configuration.getTemplate("proto.ftl");
            Writer out = new FileWriter(dir + "/" + w.getName() + ".proto");
            template.process(w, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
