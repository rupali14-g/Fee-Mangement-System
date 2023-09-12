import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private double totalFees;
    private double feesPaid;

    public Student(String studentId, String name, double totalFees) {
        this.studentId = studentId;
        this.name = name;
        this.totalFees = totalFees;
        this.feesPaid = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees() {
        return totalFees - feesPaid;
    }
}

class FeesManagementSystem {
    private List<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void collectFees() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found: " + student.getName());
            System.out.print("Enter fees amount to pay: ");
            double amount = scanner.nextDouble();
            student.payFees(amount);
            System.out.println("Fees paid successfully.");
        }
    }

    public void printStudentDetails(String studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Total Fees: " + student.getTotalFees());
            System.out.println("Fees Paid: " + student.getFeesPaid());
            System.out.println("Remaining Fees: " + student.getRemainingFees());
        } else {
            System.out.println("Student not found.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        FeesManagementSystem feesSystem = new FeesManagementSystem();
        Student student1 = new Student("1001", "Aman", 5000.0);
        Student student2 = new Student("1002", "Bob", 6000.0);
        feesSystem.addStudent(student1);
        feesSystem.addStudent(student2);

        // Simulate fee collection
        feesSystem.collectFees();
        feesSystem.collectFees();

        // Print student details
        feesSystem.printStudentDetails("1001");
        feesSystem.printStudentDetails("1002");

    }
}
