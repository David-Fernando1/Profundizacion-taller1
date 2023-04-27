package co.edu.poli.taller1.services.dto;

import co.edu.poli.taller1.persistence.entity.Tarea;
import co.edu.poli.taller1.persistence.entity.Usuario;
import lombok.Data;

@Data
public class FilaInDTO {
    private Integer duracion;
    private Usuario usuario;
    private Tarea tarea;
}
