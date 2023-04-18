import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XML {
    public static void main(String[] args) {
        readXMLFile("data.xml");
    }

    public static void readXMLFile(String filePath) {
            try {
                File xmlFile = new File(filePath);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
        
                NodeList nodeList = doc.getElementsByTagName("person");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    String name = nodeList.item(i).getChildNodes().item(1).getTextContent();
                    int age = Integer.parseInt(nodeList.item(i).getChildNodes().item(3).getTextContent());
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    
