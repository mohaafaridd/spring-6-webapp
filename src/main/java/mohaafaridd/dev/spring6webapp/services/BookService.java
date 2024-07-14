package mohaafaridd.dev.spring6webapp.services;

import mohaafaridd.dev.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
