package toBravoDev.backendTaskManager.repository;

import toBravoDev.backendTaskManager.model.Tarea;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{
    Tarea deleteTareaByIdIs(Long id);
}
