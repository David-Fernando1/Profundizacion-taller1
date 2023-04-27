package co.edu.poli.taller1.controller;

import co.edu.poli.taller1.exceptions.UsuarioException;
import co.edu.poli.taller1.persistence.entity.Usuario;
import co.edu.poli.taller1.services.UsuarioService;
import co.edu.poli.taller1.services.dto.UsuarioInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody UsuarioInDTO usuarioInDTO){
        return usuarioService.createUsuario(usuarioInDTO);
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @PatchMapping("modify_usuario/{usuarioId}")
    public Usuario modifyUsuario(@PathVariable("usuarioId") Long usuarioId){
        Usuario usuario = this.usuarioService.modifyUsuario(usuarioId);
        if (Objects.isNull(usuario))
            throw new UsuarioException("Usuario no existe", HttpStatus.NOT_FOUND);
        return usuario;
    }

    @DeleteMapping("/{usuarioId}")
    public Usuario deleteUsuarioById(@PathVariable("usuarioId") Long usuarioId){
        Usuario usuario = this.usuarioService.deleteUsuarioById(usuarioId);
        if (Objects.isNull(usuario))
            throw new UsuarioException("Usuario no existe", HttpStatus.NOT_FOUND);
        return usuario;
    }
}
