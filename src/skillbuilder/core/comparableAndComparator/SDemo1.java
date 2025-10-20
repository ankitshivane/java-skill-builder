package skillbuilder.core.comparableAndComparator;

import javax.swing.text.Style;
import java.util.*;

public class SDemo1 {
    public static void main(String[] args) {

        List<Student> studData = getStudData();

        sortingByIntegerIdDemo(studData);

        sortingByStringNameDemo(studData);

        sortingByDateDobDemo(studData);

        sortingByFloatGpaDemo(studData);
        List<Student> sorted1 = studData.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getDob)).toList();
        System.out.println("Multi Sorting First by Name and then By DOB::" + sorted1);

        /** OUTPUT
         Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}
         Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}
         Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}
         Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}
         --- 1. Sorted by ID (Default compareTo) ---
         [Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}, Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}]
         --- 1. Reverse Sorting by Id Only (Default compareTo) ---
         [Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}]
         --- 2. Sorted by Name (String) ---
         [Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}]
         --- 2. Reversed Sorting by Name ---
         [Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}]
         ------------------------------------------
         --- 3. Sorted by DOB (Date - Oldest first) ---
         [Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}]
         --- 3. Reversed Sorting by DOB (Newest first) ---
         [Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}]
         ------------------------------------------
         --- 4. Sorted by GPA (Float - Lowest first) ---
         [Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}]
         --- 4. Reversed Sorting by GPA (Highest first) ---
         [Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}, Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}]
         ------------------------------------------
         Multi Sorting::[Student{id=104, name='Zoya Shaikh', dob=Sat Jan 15 00:00:00 IST 2000, gpa=3.85}, Student{id=103, name='Sameer Khan', dob=Tue Sep 28 00:00:00 IST 1999, gpa=3.21}, Student{id=102, name='Ankit', dob=Thu Apr 05 00:00:00 IST 2001, gpa=2.0}, Student{id=101, name='Ankit', dob=Sat May 20 00:00:00 IST 1995, gpa=4.1}]


         */
    }

    private static void sortingByIntegerIdDemo(List<Student> studData) {
        Collections.sort(studData);
        System.out.println("--- 1. Sorted by ID (Default compareTo) ---");
        System.out.println(studData);
        Collections.sort(studData, Comparator.reverseOrder());
        System.out.println("--- 1. Reverse Sorting by Id Only (Default compareTo) ---");
        System.out.println(studData);
    }

    private static void sortingByFloatGpaDemo(List<Student> studData) {
        // ----------------------------------------------------------------------
        // --- 4. Sorting by Float (GPA) ---
        // ----------------------------------------------------------------------
        // Comparator uses Float.compare()
        Comparator<Student> gpaComparator = (s1, s2) -> s1.getGpa().compareTo(s2.getGpa());
        Collections.sort(studData, gpaComparator);
        // Default Float sorting (lowest GPA first)
        Collections.sort(studData, gpaComparator);
        System.out.println("--- 4. Sorted by GPA (Float - Lowest first) ---");
        System.out.println(studData);

        // Reversed Float sorting (highest GPA first)
        Collections.sort(studData, gpaComparator.reversed());
        System.out.println("--- 4. Reversed Sorting by GPA (Highest first) ---");
        System.out.println(studData);
        System.out.println("------------------------------------------");
    }

    private static void sortingByDateDobDemo(List<Student> studData) {
        // ----------------------------------------------------------------------
        // --- 3. Sorting by Date (Date of Birth - DOB) ---
        // ----------------------------------------------------------------------
        // Comparator uses Date.compareTo()
        Comparator<Student> dobComparator = (o1, o2) -> o1.getDob().compareTo(o2.getDob());
        // Default Date sorting (older dates/earlier years first)
        Collections.sort(studData, dobComparator);
        System.out.println("--- 3. Sorted by DOB (Date - Oldest first) ---");
        System.out.println(studData);

        // Reversed Date sorting (newer dates/later years first)
        Collections.sort(studData, dobComparator.reversed());
        System.out.println("--- 3. Reversed Sorting by DOB (Newest first) ---");
        System.out.println(studData);
        System.out.println("------------------------------------------");
    }

    private static void sortingByStringNameDemo(List<Student> studData) {
        // ----------------------------------------------------------------------
        // --- 2. Sorting by String (Name) ---
        // ----------------------------------------------------------------------
        // Comparator uses String.compareTo()
        Comparator<Student> namedComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(studData, namedComparator);
        System.out.println("--- 2. Sorted by Name (String) ---");
        System.out.println(studData);

        // Reversed sorting by Name
        Collections.sort(studData, namedComparator.reversed());
        System.out.println("--- 2. Reversed Sorting by Name ---");
        System.out.println(studData);
        System.out.println("------------------------------------------");
    }

    private static List<Student> getStudData() {
        // 1. Create an empty List of Student objects
        List<Student> students = new ArrayList<>();

        // 2. Create Date objects for the DOB field
        // Note: Months in Calendar are 0-indexed (0 = January, 11 = December)
        Date dob1 = new GregorianCalendar(2000, Calendar.JANUARY, 15).getTime();
        Date dob2 = new GregorianCalendar(1999, Calendar.SEPTEMBER, 28).getTime();
        Date dob3 = new GregorianCalendar(2001, Calendar.APRIL, 5).getTime();
        Date dob4 = new GregorianCalendar(1995, Calendar.MAY, 20).getTime();

        // 3. Initialize and add Student objects to the list
        students.add(new Student(
                104,                  // id
                "Zoya Shaikh",      // name
                dob1,                 // dob
                "CA",                 // state
                3.85f                 // gpa (use 'f' for Float literal)
        ));

        students.add(new Student(
                103,                  // id
                "Sameer Khan",          // name
                dob2,                 // dob
                "TX",                 // state
                3.21f
        ));

        students.add(new Student(
                102,                  // id
                "Ankit",      // name
                dob3,                 // dob
                "NY",                 // state
                2.00f
        ));
        students.add(new Student(
                101,                  // id
                "Ankit",          // name
                dob4,                 // dob
                "LA",                 // state
                4.1f
        ));

        // 4. (Optional) Print the list to verify the initialization
        System.out.println("Initialized Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
        return students;
    }
}
