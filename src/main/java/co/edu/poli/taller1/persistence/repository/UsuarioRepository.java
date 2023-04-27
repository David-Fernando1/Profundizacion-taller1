package co.edu.poli.taller1.persistence.repository;

import co.edu.poli.taller1.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Modifying
    @Query(value = "UPDATE USUARIOS SET activo=TRUE WHERE usuario_id=:usuario_id",
           nativeQuery = true)
    void modifyUsuario(@Param("usuario_id") Long usuarioId);

}
