package samostoyatelnaya;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
public class BorrowController {
    List<BorrowRecord> borrows = new ArrayList<>();
    List<Book> bookss = new ArrayList<>();


    @PostMapping(value = "/api/borrows")
    public ResponseEntity<Integer> plusBorrow(@RequestBody  int bookId, int studentId, int days) {
        BorrowRecord borrow = new BorrowRecord(borrows.size(),bookId,studentId, LocalDate.now(),LocalDate.now().plusDays(days), false);
        borrows.add(borrow);
        return ResponseEntity.ok(borrows.size() - 1);
    }

    @GetMapping(value = "/api/borrows")
    public ResponseEntity<List<BorrowRecord>> vydachaBorrows() {
        return ResponseEntity.ok(borrows);
    }
    @GetMapping(value = "/api/borrows/student/{studentId}")
    public ResponseEntity<List<BorrowRecord>> vydachaStudentu(@PathVariable(name = "studentId") int studentId) {
        List<BorrowRecord> r = new ArrayList<>();
        for(BorrowRecord h:borrows){
            if(h.getStudentId()==studentId){
                r.add(h);
            }
        }
        return ResponseEntity.ok(r);
    }
    @PutMapping(value = "/api/borrows/{id}/return")
    public ResponseEntity<Integer> vozvraschena(@PathVariable(name = "id") int id) {
        borrows.get(id).setReturned(borrows.get(id).isReturned());
        return ResponseEntity.ok(id);
    }



}
