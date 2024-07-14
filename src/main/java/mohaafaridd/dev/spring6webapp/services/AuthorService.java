package mohaafaridd.dev.spring6webapp.services;

import mohaafaridd.dev.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
