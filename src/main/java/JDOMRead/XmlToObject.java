package JDOMRead;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlToObject {
    String uri = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"usuarios.xml";
    Document dom =  getDom(uri);
    static List<Usuario> userList;
    public XmlToObject() throws IOException, JDOMException {}

    /**
     * init
     */
    public void init(){
        try {
            getDom(uri);
            crearObjetos(dom);
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
    }

    /**
     * get DOM from the XML file
     * @param uri XML´s uri
     * @return dom based on the XML
     * @throws IOException
     * @throws JDOMException
     */
    private Document getDom(String uri) throws IOException, JDOMException {
        SAXBuilder sb = new SAXBuilder();
        return sb.build(uri);
    }

    /**
     * object creator caller
     * @param dom where we´re going to get the objects
     */
    private void crearObjetos(Document dom){
        Element root = dom.getRootElement();
//        System.out.println(root.getName());
        root.getChildren("user").forEach(XmlToObject :: crearObjeto);
    }

    /**
     * object creator
     * @param element who´s going to bring the info to create the elements
     */
    private static void crearObjeto(Element element){
        if(userList==null) //si no funca es esto
            userList = new ArrayList<>();

        Usuario user = new Usuario();
         user.setNombre(element.getChildText("nombre"));
         user.setApellidos(element.getChildText("apellidos"));
         user.setEdad(Integer.parseInt(element.getChildText("edad")));
         user.setGenero(element.getChildText("genero"));

         userList.add(user);
    }

    /**
     * main
     */
    public static void main(String[] args) throws IOException, JDOMException {
        XmlToObject d = new XmlToObject();
        d.init();
        System.out.println(userList.size());
        userList.forEach(System.out::println);
    }
}
