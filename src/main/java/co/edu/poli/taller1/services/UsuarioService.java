package co.edu.poli.taller1.services;

import co.edu.poli.taller1.exceptions.UsuarioException;
import co.edu.poli.taller1.mapper.UsuarioInDTOToUsuario;
import co.edu.poli.taller1.persistence.entity.Usuario;
import co.edu.poli.taller1.persistence.repository.UsuarioRepository;
import co.edu.poli.taller1.services.dto.UsuarioInDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioInDTOToUsuario usuarioInDTOToUsuario;

    public Usuario createUsuario(UsuarioInDTO usuarioInDTO){
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = usuarioInDTO.getFechaNacimiento().toInstant().
                atZone(ZoneId.systemDefault()).toLocalDate();
        long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
        if (edad >=18) {
            return usuarioRepository.save(usuarioInDTOToUsuario.mapper(usuarioInDTO));
        }else {
            throw new UsuarioException("El usuario es menor de edad", HttpStatus.CONFLICT);
        }
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario modifyUsuario(Long usuarioId){
        Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioId);
        if (usuario.isEmpty()) return null;
        this.usuarioRepository.modifyUsuario(usuarioId);
        return usuario.orElse(null);
    }

    @Transactional
    public Usuario deleteUsuarioById(Long usuarioId){
        Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioId);
        if (usuario.isEmpty()) return null;
        this.usuarioRepository.deleteById(usuarioId);
        return usuario.orElse(null);
    }
}
