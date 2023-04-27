package co.edu.poli.taller1.controller;

import co.edu.poli.taller1.persistence.entity.Fila;
import co.edu.poli.taller1.services.FilaService;
import co.edu.poli.taller1.services.dto.FilaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filas")
@RequiredArgsConstructor
public class FilaController {

    private final FilaService filaService;

    @PostMapping
    public Fila createFila(@RequestBody FilaInDTO filaInDTO){
        return filaService.createFila(filaInDTO);
    }

    @GetMapping
    public List<Fila> findAl(){
        return filaService.findAll();
    }

}
