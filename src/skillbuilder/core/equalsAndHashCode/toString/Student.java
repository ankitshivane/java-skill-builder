package skillbuilder.core.equalsAndHashCode.toString;

import java.util.Objects;

class Student extends Person {
    int id;
    String name;

    Student(int sId, String name) {
        super();
        this.name = name;
        this.id = sId;
    }

   /*
    @Override
    public boolean equals(Object obj) {
        System.out.println("invoking student class equals");
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return student.name.equalsIgnoreCase(this.name) && this.id == student.id;
    }*/
   public String toString() {
       System.out.println("Invoking the Student class toString()");
        return name;
//       return super.toString(); // If we uncomment this line then super class means Person class toString() method will get invoke which again calling super.toString();
   }
   @Override
   public int hashCode() {
       System.out.println("invoking student class hasCode");
       return Objects.hash(name, id);
   }
}