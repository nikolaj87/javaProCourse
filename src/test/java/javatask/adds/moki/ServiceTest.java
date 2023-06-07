package javatask.adds.moki;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ServiceTest {

//    @Mock
//    Gen gen;

    Gen gen = mock(Gen.class);

//    @Mock
//    Author auth;

    Author auth = mock(Author.class);

    @Test
    void testGetByAuthor() {

        Service serv = new Service();
        serv.setGen(gen);

        Author author = new Author("John333", true, 30);

        Book book1 = new Book(author, 1999);
        Book book2 = new Book(auth, 2011);
        Book book3 = new Book(new Author("Jane", false, 25), 3);

        List<Book> books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);

        when(gen.get()).thenReturn(books);

        List<Book> result = serv.getByAuthor(author);
        assertEquals(1, result.size());
    }
}