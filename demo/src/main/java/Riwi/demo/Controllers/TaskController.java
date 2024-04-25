package Riwi.demo.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import Riwi.demo.Entitys.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import Riwi.demo.Services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import Riwi.demo.Services.StatusService;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired StatusService statusService;

    @GetMapping
    @ResponseBody
    public String hola(){
        StringBuilder mensaje = new StringBuilder();

        for(Task tempTask : taskService.findAll()){
            mensaje.append(tempTask.toString());
        }
        return mensaje.toString();
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<Task> taskList = taskService.findAll();
        model.addAttribute("taskList", taskList);
        return "allTasks";
    }

    @GetMapping("/create")
    public String createTask(Model model) {
        Task newTask = new Task();
        model.addAttribute("task",newTask);
        model.addAttribute("action", "/create/new");
        model.addAttribute("toEdit", "/edit");
        model.addAttribute("stateList", statusService.findAll());
        return "tasknew";
    }
    
     @PostMapping("/create/new")
    public RedirectView postMethodName(@ModelAttribute Task taskTemp) {
        System.out.println(taskTemp.toString());
        this.taskService.create(taskTemp);
        return new RedirectView("/create");
    } 

    @PutMapping("/edit/{id}")
    public RedirectView putTask(@PathVariable Long id, Task actTask ) {
        System.out.println(actTask);
        this.taskService.update(actTask);
        return new RedirectView("/tasks");
    }

    @GetMapping("/edit/{id}")
    public String getone(@PathVariable Long id, Task actTask, Model model ) {
        Task gettedTask = taskService.findById(id);
        System.out.println(gettedTask.getFechaCreacion());
        model.addAttribute("task", gettedTask);
        model.addAttribute("stateList", statusService.findAll());
        model.addAttribute("edit", "/edit/"+ String.valueOf(id));

        return "edit";
    }
    
    @DeleteMapping("/delete/{id}")
    public RedirectView deleteid(@PathVariable Long id){
        taskService.delete(id);
        return new RedirectView("/tasks");
    }
    
}
