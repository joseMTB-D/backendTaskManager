package toBravoDev.backendTaskManager.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import toBravoDev.backendTaskManager.model.Tarea;
import toBravoDev.backendTaskManager.repository.TareaRepository;
import toBravoDev.backendTaskManager.service.ControllerService;

import java.util.List;

@Log4j
public class ControllerServiceImpl implements ControllerService {

    private TareaRepository tareaRepository;

    /**
     * Metodo encargado de obtener todas las tareas
     * @return
     */
    public List<Tarea> findAllTareas() {
        log.info("[API::FIND ALL] Obteniendo todas las tareas");
        return tareaRepository.findAll();
    }
    /**
     * Metodo encargado de buscar una tarea por su ID
     * @param id
     * @return
     */
    public Tarea findById(Long id) {
        log.info("[API::FIND] Buscando tarea con ID: " + id);
        return tareaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarea no encontrada"));
    }

    /**
     * Metodo encargado de crear una nueva tarea
     * @param tarea
     * @return
     */
    public Tarea createTask(Tarea tarea) {
        log.info("[API::CREATE] Creando nueva tarea: " + tarea);
        log.info("""
                Detalles de la tarea:
                Nombre: """ + tarea.getNombre() + """
                Descripcion: """ + tarea.getDescripcion() + """
                Completada: """ + tarea.isCompletada()
        );
        return tareaRepository.save(tarea);
    }

    /**
     * Metodo encargado de actualizar los valores de una tarea
     * @param id
     * @param detallesTarea
     * @return
     */
    public Tarea updateValues(Long id, Tarea detallesTarea) {
        log.info("[API::UPDATE] Aplicando cambios a la tarea con ID: "+ id );
        log.info("""
                Nuevos detalles:
                Nombre: """ + detallesTarea.getNombre() + """
                Descripcion: """ + detallesTarea.getDescripcion() + """
                Completada: """ + detallesTarea.isCompletada()
                );
        return tareaRepository.findById(id).map(tarea ->  {
            tarea.setNombre(detallesTarea.getNombre());
            tarea.setDescripcion(detallesTarea.getDescripcion());
            tarea.setCompletada(detallesTarea.isCompletada());
            return tareaRepository.save(tarea);
        }).orElseThrow(()-> new RuntimeException("Tarea no encontrada"));
    }

    /**
     * Metodo encargado de eliminar una tarea por su ID
     * @param id
     * @return
     */
    public Tarea deleteTask(Long id) {
        log.info("[API::DELETE] Eliminando tarea con ID: " + id);
        Tarea tareaAEliminar = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tareaRepository.delete(tareaAEliminar);
        return tareaAEliminar;
    }
}
