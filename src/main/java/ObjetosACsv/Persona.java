package ObjetosACsv;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {
    private String nombre, genero;
    private int edad;
}
