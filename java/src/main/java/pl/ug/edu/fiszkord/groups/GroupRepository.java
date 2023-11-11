package pl.ug.edu.fiszkord.groups;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ug.edu.fiszkord.domain.User;

import java.util.Optional;
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findByCode(String code);

}