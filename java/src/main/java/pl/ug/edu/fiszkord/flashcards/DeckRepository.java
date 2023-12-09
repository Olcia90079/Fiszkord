package pl.ug.edu.fiszkord.flashcards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Integer> {

    @Query(value = "SELECT * FROM _deck WHERE subject_id = ?1", nativeQuery = true)
    Optional<List<Deck>> findAllDecksBySubjectId(Integer subjectId);

}