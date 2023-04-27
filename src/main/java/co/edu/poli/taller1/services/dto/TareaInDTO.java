package co.edu.poli.taller1.services.dto;

import co.edu.poli.taller1.persistence.entity.Fila;
import lombok.Data;


@Data
public class TareaInDTO {
    private String nombre;
    private Fila fila;
}
