package mohaafaridd.dev.spring6webapp.bootstrap;

import mohaafaridd.dev.spring6webapp.domain.Author;
import mohaafaridd.dev.spring6webapp.domain.Book;
import mohaafaridd.dev.spring6webapp.domain.Publisher;
import mohaafaridd.dev.spring6webapp.repositories.AuthorRepository;
import mohaafaridd.dev.spring6webapp.repositories.BookRepository;
import mohaafaridd.dev.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("David");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234");

        Publisher codingBookPublisher = new Publisher();
        codingBookPublisher.setName("Coding Book Publisher");
        codingBookPublisher.setCity("NY");
        codingBookPublisher.setAddress("New York");
        codingBookPublisher.setState("NY");
        codingBookPublisher.setZip("123");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher codingBookPublisherSaved = publisherRepository.save(codingBookPublisher);

        Author tawfiq = new Author();
        tawfiq.setFirstName("Ahmed");
        tawfiq.setLastName("Tawfiq");

        Book icarus = new Book();
        icarus.setTitle("Icarus");
        icarus.setIsbn("999");

        Publisher novelPublisher = new Publisher();
        novelPublisher.setName("Novel Publisher");
        novelPublisher.setCity("Kafr Abdo");
        novelPublisher.setAddress("12 Khaled Ali");
        novelPublisher.setState("Alexandria");
        novelPublisher.setZip("3333");

        Author tawfiqSaved = authorRepository.save(tawfiq);
        Book icarusSaved = bookRepository.save(icarus);
        Publisher novelPublisherSaved = publisherRepository.save(novelPublisher);

        ddd.setPublisher(codingBookPublisherSaved);
        icarus.setPublisher(novelPublisherSaved);
        ericSaved.getBooks().add(dddSaved);
        tawfiqSaved.getBooks().add(icarusSaved);


        authorRepository.save(ericSaved);
        authorRepository.save(tawfiqSaved);
        bookRepository.save(ddd);
        bookRepository.save(icarusSaved);
        
        System.out.println("In Bootstrap Data");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
