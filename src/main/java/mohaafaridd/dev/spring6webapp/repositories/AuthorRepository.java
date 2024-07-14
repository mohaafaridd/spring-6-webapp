package mohaafaridd.dev.spring6webapp.repositories;

import mohaafaridd.dev.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
