package FicherosBinarios;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Persona implements Serializable {
    private String nombre,apellido,colorFav;
    private int edad;

    public String toString(){
        return nombre+" "+apellido+", su color favorito es el "+colorFav+". Tiene "+edad+" años";
    }
}
