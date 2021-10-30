package JDOM;

import SAX.Sax;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Sax sax = new Sax();
        ObjetoAXML o = new ObjetoAXML();
        String uri=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"users2.xml";

        sax.crearObjetosDesdeXml();

        o.listToXML(sax.getUserList(),uri);

    }
}
