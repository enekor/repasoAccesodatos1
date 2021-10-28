package FicherosBinarios;

import java.io.*;

public class FicherosBinarios {

    public void escribirArchivosBinarios(){
        ObjectOutputStream oos = null;
        File archivo = null;

        Persona p = new Persona("Juan","Perez","Rojo",34);
        Persona q = new Persona("Maria","Gonzalez","Verde",44);

        try{
            archivo = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"empleados");
            oos = new ObjectOutputStream(new FileOutputStream(archivo));

            oos.writeObject(p);
            oos.writeObject(q);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void leerArchivosBinarios(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"empleados")));
            Persona p = (Persona)ois.readObject();
            System.out.println(p);
            Persona q = (Persona)ois.readObject();
            System.out.println(q);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FicherosBinarios fb = new FicherosBinarios();
        fb.escribirArchivosBinarios();
        fb.leerArchivosBinarios();
    }
}
