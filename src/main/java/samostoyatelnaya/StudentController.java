package samostoyatelnaya;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
public class StudentController {
    List<Student> students = new ArrayList<>();

    @PostMapping(value = "/api/students")
    public ResponseEntity<Integer> plusStudent(@RequestBody  Student student) {
        students.add(student);
        return ResponseEntity.ok(students.size() - 1);
    }

    @GetMapping(value = "/api/students")
    public ResponseEntity<List<Student>> vydachaStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/api/students/{id}")
    public ResponseEntity<Student> vydachaStudent(@PathVariable(name = "id") int id) {
        Student student = new Student(students.get(id).getId(), students.get(id).getFullName(), students.get(id).getGrade(),students.get(id).getEmail(),students.get(id).isActive());
        return ResponseEntity.ok(student);
    }
    @PutMapping(value = "/api/students/{id}")
    public ResponseEntity<Integer> obnovitStudent(@PathVariable(name = "id") int id, @RequestBody Student student) {
        students.get(id).setFullName(student.getFullName());
        students.get(id).setGrade(student.getGrade());
        students.get(id).setEmail(student.getEmail());
        students.get(id).setActive(student.isActive());
        return ResponseEntity.ok(id);
    }

    @DeleteMapping(value = "/api/students/{id}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable(name = "id") int id) {
        students.remove(id);
        return ResponseEntity.ok(id);
    }
    @GetMapping(value = "/api/students/grade/{grade}")
    public ResponseEntity<List<Student>> vydachaStudents(@PathVariable(name = "grade") int grade) {
        List<Student> s = new ArrayList<>();
        for (Student e:students){
            if(e.getGrade()==grade){
                s.add(e);
            }
        }
        return ResponseEntity.ok(s);
    }
}
