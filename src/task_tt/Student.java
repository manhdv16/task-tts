package task_tt;

import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int autoId = 1;
    private int id;
    private String name;
    private String gender;
    private int age;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double averageScore;
    private String academicPerformance;

    public Student(String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        this.id = autoId++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
        this.averageScore = (mathScore + physicsScore + chemistryScore) / 3.0;
        this.academicPerformance = calculateAcademicPerformance();
    }

    public String calculateAcademicPerformance() {
        if (averageScore >= 8) {
            return "Giỏi";
        } else if (averageScore >= 6.5) {
            return "Khá";
        } else if (averageScore >= 5) {
            return "Trung Bình";
        } else {
            return "Yếu";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Giới tính: " + gender + ", Tuổi: " + age +
                ", Toán: " + mathScore + ", Lý: " + physicsScore + ", Hóa: " + chemistryScore +
                ", Điểm TB: " + averageScore + ", Học lực: " + academicPerformance;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Student.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(double physicsScore) {
        this.physicsScore = physicsScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(String academicPerformance) {
        this.academicPerformance = academicPerformance;
    }
}

