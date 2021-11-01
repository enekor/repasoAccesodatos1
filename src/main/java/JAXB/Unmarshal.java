package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Unmarshal {

    String uri = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"usuarios.xml";

    public void unmarshall() throws JAXBException {
        JAXBContext jb = JAXBContext.newInstance(Usuario.class);
        Unmarshaller unmarshaller = jb.createUnmarshaller();
        Usuario user = (Usuario)unmarshaller.unmarshal(new File(uri));
        System.out.println(user);
    }

    public static void main(String[] args) throws JAXBException {
        Unmarshal un = new Unmarshal();
        un.unmarshall();
    }
}
