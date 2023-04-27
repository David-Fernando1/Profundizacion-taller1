package co.edu.poli.taller1.services;

import co.edu.poli.taller1.exceptions.FilaException;
import co.edu.poli.taller1.mapper.FilaInDTOToFila;
import co.edu.poli.taller1.persistence.entity.Fila;
import co.edu.poli.taller1.persistence.repository.FilaRepository;
import co.edu.poli.taller1.services.dto.FilaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilaService {

    private final FilaRepository filaRepository;
    private final FilaInDTOToFila filaInDTOToFila;

    public Fila createFila(FilaInDTO filaInDTO){
        if ((filaInDTO.getDuracion() >= 1) && (filaInDTO.getDuracion() <= 60)) {
            return filaRepository.save(filaInDTOToFila.mapper(filaInDTO));
        }else {
            throw new FilaException("Duracion menor a 1 o mayor a 60", HttpStatus.CONFLICT);
        }
    }

    public List<Fila> findAll(){
        return filaRepository.findAll();
    }

}
