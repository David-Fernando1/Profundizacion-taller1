package co.edu.poli.taller1.mapper;

import co.edu.poli.taller1.persistence.entity.Tarea;
import co.edu.poli.taller1.services.dto.TareaInDTO;
import org.springframework.stereotype.Component;

@Component
public class TareaInDTOToTarea implements IMapper<TareaInDTO, Tarea>{
    @Override
    public Tarea mapper(TareaInDTO in) {
        Tarea tarea = new Tarea();
        tarea.setNombre(in.getNombre());
        tarea.setFila(in.getFila());
        return tarea;
    }
}
