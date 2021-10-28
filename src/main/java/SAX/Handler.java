package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {

    boolean hasFirstName = false;
    boolean hasLasttName = false;
    boolean hasAge = false;
    boolean hasGender = false;
    List<User> userList;
    User user;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(userList==null){
            userList=new ArrayList<>();
        }
        if(qName.equalsIgnoreCase("User")){
           user = new User();
            user.setId(Integer.parseInt(attributes.getValue("id")));
            if(qName.equalsIgnoreCase("firstName")){
                hasFirstName=true;
            }
            else if(qName.equalsIgnoreCase("lastName")){
                hasLasttName=true;
            }
            else if (qName.equalsIgnoreCase("age")){
                hasAge=true;
            }
            else if(qName.equalsIgnoreCase("gender")){
                hasGender=true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("User"))
            userList.add(user);
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(hasAge) {
            user.setAge(Integer.parseInt(new String(ch, start, length)));
            hasAge=false;
        }
        if(hasFirstName) {
            user.setFirstName(new String(ch, start, length));
            hasFirstName = false;
        }
        if(hasLasttName) {
            user.setLastName(new String(ch, start, length));
            hasLasttName = false;
        }
        if(hasGender) {
            user.setGender(new String(ch, start, length));
            hasGender = false;
        }
    }

    public List<User> getUserList(){return userList;}
}
