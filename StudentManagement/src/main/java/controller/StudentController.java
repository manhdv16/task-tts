package controller;

import dto.StudentDto;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> list = studentService.getAllStudents();
        return ResponseEntity.ok(list);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto student) {
        return ResponseEntity.ok(studentService.addStudent(student.toEntity()));
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.updateStudent(dto, id));
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
