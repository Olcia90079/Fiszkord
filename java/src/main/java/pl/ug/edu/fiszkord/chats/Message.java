package pl.ug.edu.fiszkord.chats;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="_message")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;
    private String sender;
    private java.sql.Timestamp date;

}
