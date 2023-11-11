package pl.ug.edu.fiszkord.groups;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.ug.edu.fiszkord.users.User;
import pl.ug.edu.fiszkord.users.UserRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    private final UserRepository userRepository;

    public ResponseEntity<String> createGroup(GroupRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        var group = Group.builder()
                .admins(List.of(user))
                .members(List.of(user))
                .name(request.getName())
                .code(request.getCode())
                .build();
        try {
            groupRepository.save(group);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(201).body("Group " + group.getName() + " created.");
    }

    public ResponseEntity<String> joinGroup(GroupRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        Group group = null;

        try {
            group = groupRepository.findByCode(request.getCode()).orElseThrow();
        } catch (NoSuchElementException e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

        if(group.getMembers().stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))){
            return ResponseEntity.status(409).body("User " + user.getUsername() + " is already a member of " + group.getName() + " group.");
        }

        user.getMemberOfGroups().add(group);
        userRepository.save(user);

        return ResponseEntity.status(202).body("User " + user.getUsername() + " added to " + group.getName() + " group.");
    }
}
