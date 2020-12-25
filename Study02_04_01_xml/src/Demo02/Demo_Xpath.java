package Demo02;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j 查询某个节点
 */
public class Demo_Xpath {
    public static void main(String[] args) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("Study02_04_01_xml/students.xml");
        Element element = (Element) document.selectSingleNode("students/student[@id='3']");
        String id = element.attributeValue("id");
        String name = element.elementText("name");
        String age = element.elementText("age");
        System.out.println(id+"+"+name+"+"+age);
    }
}
