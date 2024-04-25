package Riwi.demo.Services;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Riwi.demo.Entitys.Task;
import Riwi.demo.Repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public List<Task> findAll(){
        return  this.taskRepository.findAll();
    }
    
    public Task findById(long id){
        //Sin el or else genera error para compilar ten cuidado con no ponerlo
        return this.taskRepository.findById(id).orElse(null);
    }

    public void delete(long id){
       this.taskRepository.deleteById(id);
    }

    public Task update(Task task){
        /** Verificar que si exista */
        if(this.findById(task.getId()) !=null){
             // Guardarlo
            return taskRepository.save(task);
        }else{
            return null;
        }
    }

    public void create(Task task){
        //EL SAVE RETORNA UN OBJETO DEL TIPO ENTITY
        taskRepository.save(task);
    }

    // public List<Task> findByDate(LocalDate inicio, LocalDate finDate){
    //     return this.taskRepository.findBetweenFechaCreacion(inicio, finDate);
    // }
}
