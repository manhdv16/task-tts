package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private int age;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double averageScore;
    private String academicPerformance;

}
