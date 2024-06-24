package service.impl;

import dto.StudentDto;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    @Cacheable(value = "students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(StudentDto dto, int id) {
        dto.setAverageScore();
        Student st = studentRepository.findById(id).get();
        if(!dto.getName().equals(st.getName())) st.setName(dto.getName());
        if(!dto.getGender().equals(st.getGender())) st.setGender(dto.getGender());
        if(dto.getAge() != st.getAge()) st.setAge(dto.getAge());
        if(dto.getMathScore() != st.getMathScore()) st.setMathScore(dto.getMathScore());
        if(dto.getPhysicsScore() != st.getPhysicsScore()) st.setPhysicsScore(dto.getPhysicsScore());
        if(dto.getChemistryScore() != st.getChemistryScore()) st.setChemistryScore(dto.getChemistryScore());
        if(dto.getAverageScore() != st.getAverageScore()) st.setAverageScore(dto.getAverageScore());
        if(!dto.getAcademicPerformance().equals(st.getAcademicPerformance())) st.setAcademicPerformance(dto.getAcademicPerformance());
        return studentRepository.save(st);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "students", key = "#name")
    public List<Student> searchByName(String name) {
        return studentRepository.searchByName(name);
    }

    @Override
    public void sortByAverageScore() {
        studentRepository.sortByAverageScore();
    }

    @Override
    public void sortByName() {
        studentRepository.sortByName();
    }
}
