package pl.ug.edu.fiszkord.subjects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ug.edu.fiszkord.groups.Group;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
