package pl.ug.edu.fiszkord.subjects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectRequest {
    private Integer groupId;
    private String name;
}
