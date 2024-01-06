package pl.ug.edu.fiszkord.files;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ug.edu.fiszkord.groups.Group;
import pl.ug.edu.fiszkord.subjects.Subject;
import pl.ug.edu.fiszkord.users.User;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "_file")
public class FileEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name="subject", nullable=false)
    private Subject subject;

}