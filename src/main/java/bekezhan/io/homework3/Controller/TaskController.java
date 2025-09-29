package bekezhan.io.homework3.Controller;

import bekezhan.io.homework3.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Go to Gym", "01.10.2025", false));
        tasks.add(new Task(2L, "Go to University", "02.09.2025", true));
        tasks.add(new Task(3L, "Hang out with Friends", "27.08.2025", true));
        tasks.add(new Task(4L, "Date with a Girl", "14.10.2025", false));
        tasks.add(new Task(5L, "Watch SakaMoto Days 17 episode", "22.09.2025", true));
        tasks.add(new Task(6L, "Buy sweet cake", "17.09.2025", false));
        tasks.add(new Task(7L, "Hiking to Furmanova", "07.09.2025", true));
        tasks.add(new Task(8L, "Shopping with friends", "08.10.2025", false));
        tasks.add(new Task(9L, "Watch the match FC Kairat vs Real Madrid", "30.09.2025", false));
        tasks.add(new Task(10L, "Listen to the 'The Weekend'", "10.09.2025", true));
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "/tasks";
    }
}
