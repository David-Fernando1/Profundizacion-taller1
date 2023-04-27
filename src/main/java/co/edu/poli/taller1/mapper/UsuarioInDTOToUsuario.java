package co.edu.poli.taller1.mapper;

import co.edu.poli.taller1.persistence.entity.Usuario;
import co.edu.poli.taller1.services.dto.UsuarioInDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInDTOToUsuario implements IMapper<UsuarioInDTO, Usuario>{
    @Override
    public Usuario mapper(UsuarioInDTO in) {
        Usuario usuario = new Usuario();
        usuario.setFechaNacimiento(in.getFechaNacimiento());
        usuario.setActivo(false);
        usuario.setDependencia(in.getDependencia());
        usuario.setPerfil(in.getPerfil());
        usuario.setFilas(in.getFilas());
        return usuario;
    }
}
