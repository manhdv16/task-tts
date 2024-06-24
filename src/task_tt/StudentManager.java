package task_tt;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private final String filePath = "student.txt";

    public StudentManager() {
        readFromFile();
    }

    public void addStudent(String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        Student student = new Student(name, gender, age, mathScore, physicsScore, chemistryScore);
        students.add(student);
    }

    public void updateStudent(int id, String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setGender(gender);
                student.setAge(age);
                student.setMathScore(mathScore);
                student.setPhysicsScore(physicsScore);
                student.setChemistryScore(chemistryScore);
                student.setAverageScore((mathScore + physicsScore + chemistryScore) / 3.0);
                student.setAcademicPerformance(student.calculateAcademicPerformance());
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> searchByName(String name) {
        return students.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void sortByAverageScore() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAverageScore() > o2.getAverageScore() ? -1 : 1;
            }
        });
        //students.sort(Comparator.comparingDouble(Student::getAverageScore));
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));

    }

    public void displayStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            students = (List<Student>) ois.readObject();
            Student.setAutoId(students.size() + 1);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không thể đọc file hoặc file không tồn tại. Khởi tạo danh sách sinh viên mới.");
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm sinh viên.");
            System.out.println("2. Cập nhật thông tin sinh viên bởi ID.");
            System.out.println("3. Xóa sinh viên bởi ID.");
            System.out.println("4. Tìm kiếm sinh viên theo tên.");
            System.out.println("5. Sắp xếp sinh viên theo điểm trung bình (GPA).");
            System.out.println("6. Sắp xếp sinh viên theo tên.");
            System.out.println("7. Hiển thị danh sách sinh viên.");
            System.out.println("8. Ghi danh sách sinh viên vào file 'student.txt'.");
            System.out.println("9. Thoát.");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Tuổi: ");
                    int age = scanner.nextInt();
                    System.out.print("Điểm Toán: ");
                    double mathScore = scanner.nextDouble();
                    System.out.print("Điểm Lý: ");
                    double physicsScore = scanner.nextDouble();
                    System.out.print("Điểm Hóa: ");
                    double chemistryScore = scanner.nextDouble();
                    manager.addStudent(name, gender, age, mathScore, physicsScore, chemistryScore);
                    break;
                case 2:
                    System.out.print("ID: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Giới tính mới: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Tuổi mới: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Điểm Toán mới: ");
                    double newMathScore = scanner.nextDouble();
                    System.out.print("Điểm Lý mới: ");
                    double newPhysicsScore = scanner.nextDouble();
                    System.out.print("Điểm Hóa mới: ");
                    double newChemistryScore = scanner.nextDouble();
                    manager.updateStudent(idToUpdate, newName, newGender, newAge, newMathScore, newPhysicsScore, newChemistryScore);
                    break;
                case 3:
                    System.out.print("ID: ");
                    int idToDelete = scanner.nextInt();
                    manager.deleteStudent(idToDelete);
                    break;
                case 4:
                    System.out.print("Tên: ");
                    String nameToSearch = scanner.nextLine();
                    List<Student> foundStudents = manager.searchByName(nameToSearch);
                    if (foundStudents.isEmpty()) {
                        System.out.println("Không tìm thấy sinh viên nào với tên: " + nameToSearch);
                    } else {
                        foundStudents.forEach(System.out::println);
                    }
                    break;
                case 5:
                    manager.sortByAverageScore();
                    System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình.");
                    break;
                case 6:
                    manager.sortByName();
                    System.out.println("Danh sách sinh viên đã được sắp xếp theo tên.");
                    break;
                case 7:
                    manager.displayStudents();
                    break;
                case 8:
                    manager.saveToFile();
                    System.out.println("Danh sách sinh viên đã được ghi vào file.");
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }
}

