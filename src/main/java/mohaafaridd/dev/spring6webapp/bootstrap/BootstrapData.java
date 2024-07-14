package mohaafaridd.dev.spring6webapp.bootstrap;

import mohaafaridd.dev.spring6webapp.domain.Author;
import mohaafaridd.dev.spring6webapp.domain.Book;
import mohaafaridd.dev.spring6webapp.repositories.AuthorRepository;
import mohaafaridd.dev.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("David");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author tawfiq = new Author();
        tawfiq.setFirstName("Ahmed");
        tawfiq.setLastName("Tawfiq");

        Book icarus = new Book();
        icarus.setTitle("Icarus");
        icarus.setIsbn("999");

        Author tawfiqSaved = authorRepository.save(tawfiq);
        Book icarusSaved = bookRepository.save(icarus);

        ericSaved.getBooks().add(dddSaved);
        tawfiqSaved.getBooks().add(icarusSaved);

        System.out.println("In Bootstrap Data");
        System.out.println("Author Count: "+authorRepository.count());
        System.out.println("Book Count: "+bookRepository.count());
    }
}
