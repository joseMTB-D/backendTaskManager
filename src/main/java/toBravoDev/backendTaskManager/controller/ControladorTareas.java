package toBravoDev.backendTaskManager.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import toBravoDev.backendTaskManager.model.Tarea;
import toBravoDev.backendTaskManager.service.ControllerService;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/api/tareas")
public class ControladorTareas {

    @Autowired
    private final ControllerService controllerService;

    public ControladorTareas(ControllerService controllerService) {
        this.controllerService = controllerService;
    }

    public List<Tarea> getAllTasks(){
        log.info("[API::FIND ALL] Obteniendo todas las tareas");
        return controllerService.findAllTareas();
    }

    @GetMapping("/{id}")
    public Tarea findTask(@PathVariable Long id){
        log.info("[API::FIND ONE] ID: "+id);
        return controllerService.findById(id);
    }

    @PostMapping
    public Tarea createTask(@RequestBody Tarea tarea){
        log.info("[API::CREATE] ID: " + tarea);
        return controllerService.createTask(tarea);
    }

    @PutMapping("/{id}")
    public Tarea updateTask(@PathVariable Long id, @RequestBody Tarea detallesTarea){
        log.info("[API::UPDATE] ID: " + id + ", Detalles: " + detallesTarea);
        return controllerService.updateValues(id, detallesTarea);
    }

    @DeleteMapping("/{id}")
    public Tarea deleteTask(@PathVariable Long id){
        log.info("[API::DELETE] ID: " + id);
        return controllerService.deleteTask(id);
    }
}
