package pl.ug.edu.fiszkord.groups;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import pl.ug.edu.fiszkord.domain.Token;
import pl.ug.edu.fiszkord.domain.User;
import pl.ug.edu.fiszkord.subjects.Subject;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "_group")
public class Group {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany(mappedBy = "adminOfGroups", fetch = FetchType.EAGER)
    private List<User> admins;

    @ManyToMany(mappedBy = "memberOfGroups", fetch = FetchType.EAGER)
    private List<User> members;

    private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Subject> subjects;

}
