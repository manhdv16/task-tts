package service;

import dto.StudentDto;
import entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student updateStudent(StudentDto dto, int id);
    public Student addStudent(Student student);
    public void deleteStudent(int id);
    public List<Student> searchByName(String name);
    public void sortByAverageScore();
    public void sortByName();
}
