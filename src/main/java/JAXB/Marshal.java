package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Marshal {
    String uri = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"usuarios.xml";
    JAXBContext jc = JAXBContext.newInstance(Usuario.class);
    Marshaller marshaller = jc.createMarshaller();

    public Marshal() throws JAXBException {
    }

    public void marshall() throws JAXBException {
        Usuario user = new Usuario("Pepe","Martinez","Literario",98,1);

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.setProperty(String.valueOf(user),System.out);
        marshaller.marshal(user,new File(uri));
    }

    public static void main(String[] args) throws JAXBException {
        Marshal m = new Marshal();
        m.marshall();
    }
}