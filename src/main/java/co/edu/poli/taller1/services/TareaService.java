package co.edu.poli.taller1.services;

import co.edu.poli.taller1.mapper.TareaInDTOToTarea;
import co.edu.poli.taller1.persistence.entity.Tarea;
import co.edu.poli.taller1.persistence.repository.TareaRepository;
import co.edu.poli.taller1.services.dto.TareaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;
    private final TareaInDTOToTarea tareaInDTOToTarea;

    public Tarea createTarea(TareaInDTO tareaInDTO){
        return tareaRepository.save(tareaInDTOToTarea.mapper(tareaInDTO));
    }

    public List<Tarea> findAll(){
        return tareaRepository.findAll();
    }

}
