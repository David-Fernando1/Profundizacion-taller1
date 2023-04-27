package co.edu.poli.taller1.services.dto;

import co.edu.poli.taller1.persistence.entity.Dependencia;
import co.edu.poli.taller1.persistence.entity.Fila;
import co.edu.poli.taller1.persistence.entity.Perfil;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioInDTO {
    private Date fechaNacimiento;
    private boolean activo;
    private Dependencia dependencia;
    private Perfil perfil;
    private List<Fila> filas;
}
