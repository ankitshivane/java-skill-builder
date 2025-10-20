package skillbuilder.core.comparableAndComparator;

import java.util.Date;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Date dob;
    private String state;
    private Float gpa;

    public Student(int id, String name, Date dob, String state, Float gpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.state = state;
        this.gpa = gpa;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Student o) {
//        return this.id - o.id;  // sorting by id
//        return this.name.compareTo(o.name); // Sorting by name
        return Integer.compare(this.id, o.id); // sorting by method inside which just return the +,-,0 number
//        return Integer.compare(o.id,this.id); // Uncomment and then Run SDemo1 cls, here by just swapping the input classes you will see by default it sorts in reverse order
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
//                ", state='" + state + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
