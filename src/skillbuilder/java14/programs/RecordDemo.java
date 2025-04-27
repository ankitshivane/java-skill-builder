package skillbuilder.java14.programs;

public class RecordDemo {
    public static void main(String[] args) {
        Student s = new Student(1, "ankit", 99.9f);
        // CASE:1
        System.out.println(s); // Checking whether toString() method is able to perform printing or not
        // CASE:2
        System.out.println("Student ID:" + s.studentId());
        System.out.println("Student Name:" + s.studentName());
        System.out.println("Student Marks:" + s.marks());

        // CASE:3
        Student s2 = new Student(1, "ankit", 99.9f);
        System.out.println("Compare S And S2 ->" + s.equals(s2));
        Student s3 = new Student(2, "ankit", 99.9f);
        System.out.println("Compare S2 And S3 ->" + s2.equals(s3));

        // CASE:4
        Student.age=23;
    }
}
