package co.edu.poli.taller1.mapper;

import co.edu.poli.taller1.persistence.entity.Fila;
import co.edu.poli.taller1.services.dto.FilaInDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaInDTOToFila implements IMapper<FilaInDTO, Fila>{
    @Override
    public Fila mapper(FilaInDTO in) {
        Fila fila = new Fila();
        fila.setDuracion(in.getDuracion());
        fila.setUsuario(in.getUsuario());
        fila.setTarea(in.getTarea());
        return fila;
    }
}
