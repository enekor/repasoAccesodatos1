package SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sax {

    private String uri=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"users.xml";
    List<User> userList = new ArrayList<>();

    public void crearObjetosDesdeXml() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spFactory = SAXParserFactory.newInstance();
        SAXParser parser = spFactory.newSAXParser();

        Handler handler = new Handler();

        parser.parse(uri,handler);

        userList = handler.getUserList();

        System.out.println(userList.size());
        System.out.println(userList);
    }

    public static void main(String[] args) {
        Sax s = new Sax();
        try {
            s.crearObjetosDesdeXml();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUserList(){return userList;}
}
