package pl.ug.edu.fiszkord.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JoinGroupRequest {
    private String code;
}
