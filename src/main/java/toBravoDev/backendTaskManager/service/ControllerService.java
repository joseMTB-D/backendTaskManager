package toBravoDev.backendTaskManager.service;

import org.springframework.stereotype.Service;
import toBravoDev.backendTaskManager.model.Tarea;

import java.util.List;

@Service
public interface ControllerService {


    List<Tarea> findAllTareas();
    Tarea findById(Long id);

    Tarea createTask(Tarea tarea);

    Tarea updateValues(Long id, Tarea detallesTarea);

    Tarea deleteTask(Long id);

}
