package pl.ug.edu.fiszkord.files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ug.edu.fiszkord.subjects.Subject;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {

    @Query(value = "SELECT * FROM _file WHERE subject_id = ?1", nativeQuery = true)
    Optional<List<Subject>> findAllFilesBySubjectId(Integer subjectId);
}
