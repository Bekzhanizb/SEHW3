package bekezhan.io.homework3.Model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String name;
    private LocalDate deadlineDate;
    private boolean completed;
}
