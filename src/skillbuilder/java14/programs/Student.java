package skillbuilder.java14.programs;

public record Student(int studentId, String studentName, float marks) {
    static int age = 3;

    // Canonical constructor
    public Student(int studentId, String studentName, float marks) {
        if (marks < 0) {
            throw new IllegalArgumentException("Marks cannot be negative!");
        }
        this.studentName = studentName;
        this.marks = age;
    }
}
