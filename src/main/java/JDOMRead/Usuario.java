package JDOMRead;

import lombok.Data;

@Data
public class Usuario {
    private String nombre,apellidos,genero;
    private int edad;

    public String toString(){
        return nombre+" "+apellidos+" "+", "+genero+", "+edad;
    }
}
