package pl.ug.edu.fiszkord.groups;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/group")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService service;


    @PostMapping("/create")
    public ResponseEntity<String> createGroup(
            @RequestBody CreateGroupRequest request,
            Principal connectedUser
    ) {
        return service.createGroup(request, connectedUser);
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinGroup(
            @RequestBody CreateGroupRequest request,
            Principal connectedUser
    ) {
        return service.joinGroup(request, connectedUser);
    }

}
