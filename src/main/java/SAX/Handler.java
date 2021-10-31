package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {

    boolean hasNombre = false;
    boolean hasApellido = false;
    boolean hasEdad = false;
    boolean hasGenero = false;

    List<User> userList;
    User user;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(userList==null){
            userList=new ArrayList<>();
        }
        if(qName.equalsIgnoreCase("usuario")){
           user = new User();
            user.setId(Integer.parseInt(attributes.getValue("id")));
            if(qName.equalsIgnoreCase("nombre")){
                hasNombre=true;
            }
            else if(qName.equalsIgnoreCase("apellido")){
                hasApellido=true;
            }
            else if (qName.equalsIgnoreCase("edad")){
                hasEdad=true;
            }
            else if(qName.equalsIgnoreCase("genero")){
                hasGenero=true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("user"))
            userList.add(user);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(hasEdad) {
            user.setEdad(Integer.parseInt(new String(ch, start, length)));
            hasEdad=false;
        }
        if(hasNombre) {
            user.setNombre(new String(ch, start, length));
            hasNombre = false;
        }
        if(hasApellido) {
            user.setApellido(new String(ch, start, length));
            hasApellido = false;
        }
        if(hasGenero) {
            user.setGenero(new String(ch, start, length));
            hasGenero = false;
        }
    }

    public List<User> getUserList(){return userList;}
}
