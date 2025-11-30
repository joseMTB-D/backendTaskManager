package toBravoDev.backendTaskManager.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private boolean completada;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
