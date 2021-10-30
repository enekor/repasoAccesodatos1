package JDOM;

import SAX.User;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ObjetoAXML {

    public void listToXML(List<User> lista, String uri) throws IOException {
        Element root = new Element("User");
        Document dom = new Document();

        List<String> qNames = List.of("Nombre","Apellido","Edad","Genero");

        lista.forEach(v->{
            Element child = createNode(qNames,v);
            root.addContent(child);
        });

        dom.setRootElement(root);
        crearXML(dom,uri);
    }

    private Element createNode(List<String> lista, User user){
        Element elemento = new Element("Usuario");
        elemento.setAttribute(new Attribute("id",String.valueOf(user.getId())));

        Element hijo = new Element(lista.get(0));
        hijo.addContent(user.getNombre());
        elemento.addContent(hijo);

        hijo = new Element(lista.get(1));
        hijo.addContent(user.getApellido());
        elemento.addContent(hijo);

        hijo = new Element(lista.get(2));
        hijo.addContent(String.valueOf(user.getEdad()));
        elemento.addContent(hijo);

        hijo = new Element(lista.get(3));
        hijo.addContent(user.getGenero());
        elemento.addContent(hijo);

        return elemento;
    }

    private void crearXML(Document dom, String uri) throws IOException {
        XMLOutputter xml = new XMLOutputter();
        BufferedWriter bw = new BufferedWriter(new FileWriter(uri));
        xml.output(dom,bw);
    }
}
