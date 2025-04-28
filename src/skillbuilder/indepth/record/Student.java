package skillbuilder.indepth.record;

public record Student(String name, int marks) {
    public Student {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        // No need to assign: compiler assigns automatically
    }

    public void printMarks() {
        System.out.println(this.marks);
    }

    public static void main(String[] args) {
        Student s = new Student("Ankit", -2);
        s.printMarks();
    }
    /*
    OUTPUT:
Exception in thread "main" java.lang.IllegalArgumentException: Marks must be between 0 and 100
	at skillbuilder.indepth.record.Student.<init>(Student.java:6)
	at skillbuilder.indepth.record.Student.main(Student.java:16)
     */
}