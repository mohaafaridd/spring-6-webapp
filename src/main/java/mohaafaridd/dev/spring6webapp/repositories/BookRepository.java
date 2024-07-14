package mohaafaridd.dev.spring6webapp.repositories;

import mohaafaridd.dev.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
