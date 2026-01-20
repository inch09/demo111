package samostoyatelnaya;
import com.example.demo.Club;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
public class BookController {
    List<Book> books = new ArrayList<>();

    @PostMapping(value = "/api/books")
    public ResponseEntity<Integer> plusBook(@RequestBody  Book book) {
        books.add(book);
        return ResponseEntity.ok(books.size() - 1);
    }

    @GetMapping(value = "/api/books")
    public ResponseEntity<List<Book>> vydachaBooks() {
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "/api/books/{id}")
    public ResponseEntity<Book> vydachaBook(@PathVariable(name = "id") int id) {
        Book book = new Book(books.get(id).getId(), books.get(id).getTitle(), books.get(id).getAuthor(),books.get(id).getIsbn(),books.get(id).getPublishYear(),books.get(id).isAvailable());
        return ResponseEntity.ok(book);
    }
    @PutMapping(value = "/api/books/{id}")
    public ResponseEntity<Integer> obnovitBook(@PathVariable(name = "id") int id, @RequestBody Book book) {
        books.get(id).setTitle(book.getTitle());
        books.get(id).setAuthor(book.getAuthor());
        books.get(id).setIsbn(book.getIsbn());
        books.get(id).setPublishYear(book.getPublishYear());
        books.get(id).setAvailable(book.isAvailable());
        return ResponseEntity.ok(id);
    }

    @DeleteMapping(value = "/api/books/{id}")
    public ResponseEntity<Integer> deleteBook(@PathVariable(name = "id") int id) {
        books.remove(id);
        return ResponseEntity.ok(id);
    }
    @GetMapping(value = "/api/books/search?title={fragment}")
    public ResponseEntity<Book> vydachaPoNazvaniu(@PathVariable(name = "fragment") String fragment) {
        for (Book y:books){
            if(y.getTitle().toLowerCase().contains(fragment.toLowerCase())){
                return ResponseEntity.ok(y);
            }
        }
        return ResponseEntity.status(409).build();
    }
}
