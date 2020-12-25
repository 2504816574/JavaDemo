package Demo01;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 *
 */
public class Demo_dom4j {
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("Study02_04_01_xml/students.xml");
            Element rootElement = document.getRootElement();//获取根元素
            List<Element> elements = rootElement.elements();//子节点
            for (Element element : elements) {
                String id = element.attributeValue("id");
                String name = element.elementText("name");
                String age = element.elementText("age");
                System.out.println(id+"+"+name+"+"+age);

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
