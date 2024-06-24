package dto;

import entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String name;
    private String gender;
    private int age;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double averageScore;
    private String academicPerformance;

    public void setAverageScore() {
        this.averageScore = (mathScore + physicsScore + chemistryScore) / 3.0;
    }
    public Student toEntity() {
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setAge(age);
        student.setMathScore(mathScore);
        student.setPhysicsScore(physicsScore);
        student.setChemistryScore(chemistryScore);
        student.setAverageScore((mathScore+physicsScore+chemistryScore)/3.0);
        student.setAcademicPerformance(academicPerformance);
        return student;
    }
}
