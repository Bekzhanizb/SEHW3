package bekezhan.io.homework3.Controller;

import bekezhan.io.homework3.Model.Task;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Go to Gym", LocalDate.of(2025, 10, 1), false));
        tasks.add(new Task(2L, "Go to University", LocalDate.of(2025, 9, 2), true));
        tasks.add(new Task(3L, "Hang out with Friends", LocalDate.of(2025, 8, 27), true));
        tasks.add(new Task(4L, "Date with a Girl", LocalDate.of(2025, 10, 14), false));
        tasks.add(new Task(5L, "Watch SakaMoto Days 17 episode", LocalDate.of(2025, 9, 22), true));
        tasks.add(new Task(6L, "Buy sweet cake", LocalDate.of(2025, 9, 17), false));
        tasks.add(new Task(7L, "Hiking to Furmanova", LocalDate.of(2025, 9, 7), true));
        tasks.add(new Task(8L, "Shopping with friends", LocalDate.of(2025, 10, 8), false));
        tasks.add(new Task(9L, "Watch the match FC Kairat vs Real Madrid", LocalDate.of(2025, 9, 30), false));
        tasks.add(new Task(10L, "Listen to the 'The Weekend'", LocalDate.of(2025, 9, 10), true));
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/tasks/update")
    public String updateTask(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadlineDate,
                             @RequestParam(required = false) Boolean completed) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setName(name);
                t.setDeadlineDate(deadlineDate);
                t.setCompleted(completed != null && completed);
                break;
            }
        }
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/delete")
    public String deleteTask(@RequestParam Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
        return "redirect:/tasks";
    }

}
