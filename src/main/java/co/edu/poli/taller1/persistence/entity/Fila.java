package co.edu.poli.taller1.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@Table (name = "filas")
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "fila_id")
    private Long filaId;
    private Integer duracion;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fila fila = (Fila) o;
        return Objects.equals(filaId, fila.filaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filaId);
    }
}
