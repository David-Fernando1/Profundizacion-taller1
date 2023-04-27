package co.edu.poli.taller1.controller;

import co.edu.poli.taller1.persistence.entity.Tarea;
import co.edu.poli.taller1.services.TareaService;
import co.edu.poli.taller1.services.dto.TareaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @PostMapping
    public Tarea createTarea(@RequestBody TareaInDTO tareaInDTO){
        return tareaService.createTarea(tareaInDTO);
    }

    @GetMapping
    public List<Tarea> findAl(){
        return tareaService.findAll();
    }

}
