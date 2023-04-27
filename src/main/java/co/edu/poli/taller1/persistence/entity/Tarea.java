package co.edu.poli.taller1.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@Table (name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "tarea_id")
    private Long tareaId;
    private String nombre;
    @JsonBackReference
    @OneToOne(mappedBy = "tarea", fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Fila fila;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(tareaId, tarea.tareaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tareaId);
    }
}
