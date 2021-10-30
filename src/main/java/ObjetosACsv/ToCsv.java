package ObjetosACsv;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToCsv {

    private String uri = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources";
    List<Persona> lista = new ArrayList<>();

    /**
     * crreamos personas
     */
    private void crearPersonas(){
        lista.add(new Persona("Juan","Perez",34));
        lista.add(new Persona("Pepe","Gomez",44));
        lista.add(new Persona("Maria","Perez",87));
        lista.add(new Persona("Pilu","Paramecio",12));
        lista.add(new Persona("Jose","Paramecio",22));
    }

    /**
     * pasamos los objetos a csv, poniendo true en el fileWriter para que no se sobreescriba
     * @throws IOException
     */
    private void toCsv() throws IOException {
        BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(uri+File.separator+"Personas.csv",true));
            lista.forEach(v->{
                try {
                    bw.write(v.getNombre()+";"+v.getGenero()+";"+v.getEdad()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();
            bw.close();
    }

    /**
     * llamamos a todos los metodos
     * @throws IOException
     */
    public void init() throws IOException {
        crearPersonas();
        toCsv();
    }

    public static void main(String[] args) throws IOException {
        ToCsv c = new ToCsv();
        c.init();
    }
}
