package bekezhan.io.homework3.Controller;

import bekezhan.io.homework3.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1L, "John", "Doe", 80));
        students.add(new Student(2L, "Steve", "Cooper", 70));
        students.add(new Student(3L, "Alex", "Taylor", 90));
        students.add(new Student(4L, "Aston", "Martin", 55));
        students.add(new Student(5L, "Rick", "And", 25));
        students.add(new Student(6L, "Morty", "Ben", 84));
        students.add(new Student(7L, "Kelly", "Duisalip", 69));
        students.add(new Student(8L, "Nick", "Smith", 72));
        students.add(new Student(9L, "Peter", "Parker", 95));
        students.add(new Student(10L, "Han", "Gone", 38));
        students.add(new Student(11L, "Billy", "Hope", 86));
        students.add(new Student(12L, "Serious", "Black", 48));
    }

    @GetMapping("/")
    public String getStudent(Model model) {
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        student.setId((long) (students.size() + 1));
        students.add(student);
        return "redirect:/";
    }
}
