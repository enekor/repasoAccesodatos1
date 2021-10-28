package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Dom {

    Document dom;
    String uri = System.getProperty("user.dir")+File.separator+"data"+File.separator+"users.xml";

    /**
     * creamos un dom desde 0 para poder crear un xml sin usar referencia de otro
     * @throws ParserConfigurationException
     */
    public void crearDomDeCero() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbFactory.newDocumentBuilder();

        dom=db.newDocument();
        Element root = dom.createElement("Users");
        dom.appendChild(root);
    }

    /**
     * creamos un dom a partir de un xml existente
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public void inicializarDomXml() throws ParserConfigurationException, IOException, SAXException {
        File XMLFile = new File(uri);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbFactory.newDocumentBuilder();
        dom=db.parse(XMLFile);
        dom.getDocumentElement().normalize();
    }

    /**
     * obtenemos el nodo con el nombre especificado
     * @param tag el nombre que queremos buscar
     * @param element donde buscaremos
     */
    public void getNodeByTag(String tag,Element element){
        NodeList nl = element.getElementsByTagName(tag);
        Node node = nl.item(0);
    }

    /**
     * primero verificamos que se trata de un elemento para poder castearlo a elemento
     * obtenemos un objeto usuario a partir de un nodo del xml
     * @param node donde esta almacenado el usuario
     */
    public void getUserfromNode(Node node){
        User user = new User();

        if(node.getNodeType()==Node.ELEMENT_NODE){
            Element element = (Element)node;
            user.setId(Integer.parseInt(element.getAttribute("id")));
            user.setAge(Integer.parseInt(getTagValue(element,"age")));
            user.setFirstName(getTagValue(element,"firstName"));
            user.setLastName(getTagValue(element,"lastName"));
            user.setGender(getTagValue(element,"gender"));
        }
    }

    /**
     * obtenemos el nodo con el ombre especificado por parametro
     * @param element donde buscaremos el nodo
     * @param nombre del nodo que buscamos
     * @return el contenido del nodo
     */
    private String getTagValue(Element element,String nombre){
        NodeList lista = element.getElementsByTagName(nombre);
        Node nodo = lista.item(0);
        if(nodo!=null){
            return nodo.getNodeValue();
        }
        return null;
    }

    /**
     * añadimos un nuevo usuario a partir de un usuario existente como objeto
     * @param user que deseamos añadir
     */
    public void addUser(User user){
        Element newUser = dom.createElement("User");
        newUser.setAttribute("id",String.valueOf(user.getId()));
        newUser.appendChild(createNode("firstName",user.getFirstName()));
        newUser.appendChild(createNode("lastName",user.getLastName()));
        newUser.appendChild(createNode("age",String.valueOf(user.getAge())));
        newUser.appendChild(createNode("gender",user.getGender()));
    }

    /**
     * creamos un nuevo elemento que funcionara como nodo a añadir
     * @param name del nodo
     * @param value del nodo
     * @return el elemento nodo
     */
    private Node createNode(String name, String value){
        Element node = dom.createElement(name);
        node.appendChild(dom.createTextNode(value));
        return node;
    }
}
