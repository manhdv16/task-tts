package repository;

import entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> searchByName(String name);
    @Query("SELECT s FROM Student s ORDER BY s.averageScore DESC")
    public List<Student> sortByAverageScore();
    @Query("SELECT s FROM Student s ORDER BY s.name ASC")
    public List<Student> sortByName();
}
