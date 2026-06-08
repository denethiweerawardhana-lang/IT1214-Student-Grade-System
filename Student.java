public class Student {
    
    private String studentId;
    private String studentName;
    private double marks;

    
    public Student(String studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

   
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

   
    public void displayStudentDetails() {
        System.out.printf("ID: %-10s | Name: %-20s | Marks: %.2f\n", studentId, studentName, marks);
    }
}



