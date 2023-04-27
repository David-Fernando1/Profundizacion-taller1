package co.edu.poli.taller1.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table (name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "usuario_id")
    private Long usuarioId;
    @Column (name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private boolean activo;
    private Dependencia dependencia;
    private Perfil perfil;
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Fila> filas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuarioId, usuario.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId);
    }
}
