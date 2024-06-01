package skillbuilder.core.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
//		operationsOnList();
//		operationsOnSet();
		operationsOnMap();
	}

	public static void operationsOnMap() {
		Student s1 = new Student(1, "ankit", 25);
		Student s2 = new Student(1, "ankit", 2522);
		Student s3 = new Student(2, "anurag", 22);
		Student s4 = s1;

		Map<Student, String> mp = new HashMap<>();
		mp.put(s1, "stud-1");
		mp.put(s2, "stud-2");
		mp.put(s3, "stud-3");
//		mp.put(s4, "stud-4");

		System.out.println("Before removing S1 element, size of Map is==> " + mp.size());
		System.out.println("Does Map contains S1 Object==>"+mp.containsKey(s1));
		mp.entrySet().stream().forEach(i -> {
			System.out.println("Key:"+i.getKey()+", Value:"+i.getValue());
		});
		System.out.println("-----------------------------------------------------------");
		mp.remove(s1);
		System.out.println("-----------------------------------------------------------");
		System.out.println("After removing S1 element, size of Map is==> " + mp.size());
		System.out.println("Does Map contains S1 Object==>"+mp.containsKey(s1));
		System.out.println("-----------------------------------------------------------");
		System.out.println("Element of Map are:");
		mp.entrySet().stream().forEach(i -> {
			System.out.println("Key:"+i.getKey()+", Value:"+i.getValue());
		});
		System.out.println("-----------------------------------------------------------");
		System.out.println("s1.equals(s2)==>>" + s1.equals(s2));
		System.out.println("s1.hashCode() == s2.hashCode()==>" + (s1.hashCode() == s2.hashCode()));
		System.out.println("-----------------------------------------------------------");
		System.out.println("s1.equals(s3)==>>" + s1.equals(s3));
		System.out.println("s1.hashCode() == s3.hashCode()==>" + (s1.hashCode() == s3.hashCode()));
		/**
		 ** OUTPUT: consider the below output as there is equals and hasCode method defined in student class properly currently:::

		Before removing S1 element, size of Map is==> 2
		Does Map contains S1 Object==>true
		Key:Student [id=1, name=ankit, age=25], Value:stud-4			//<--- Note: here on this line you can see that as map contains unique key but value it has replaced from stude-1 to stud-4 if we comment code line mp.put(s4, "stud-4"); this one then still the object key will be same as S1 and not S2 (see age of S2) but value will be stud-2 
		Key:Student [id=2, name=anurag, age=22], Value:stud-3
		-----------------------------------------------------------
		-----------------------------------------------------------
		After removing S1 element, size of Map is==> 1
		Does Map contains S1 Object==>false
		-----------------------------------------------------------
		Element of Map are:
		Key:Student [id=2, name=anurag, age=22], Value:stud-3
		-----------------------------------------------------------
		s1.equals(s2)==>>true
		s1.hashCode() == s2.hashCode()==>true
		-----------------------------------------------------------
		s1.equals(s3)==>>false
		s1.hashCode() == s3.hashCode()==>false

		
		 * 
		 */
	}

	public static void operationsOnSet() {
		Student s1 = new Student(1, "ankit", 25);
		Student s2 = new Student(1, "ankit", 2522);
		Student s3 = new Student(2, "anurag", 22);
		Student s4 = s1;

		Set<Student> ls = new HashSet<>();
		ls.add(s1);
		ls.add(s2);
		ls.add(s3);
		ls.add(s4);
		System.out.println("Before removing S1 element, size of hashset is==> " + ls.size());
		System.out.println("Does Hashset contains S1 Object==>"+ls.contains(s1));
		System.out.println("-----------------------------------------------------------");
		ls.remove(s1);
		System.out.println("-----------------------------------------------------------");
		System.out.println("After removing S1 element, size of hashset is==> " + ls.size());
		System.out.println("Does Hashset contains S1 Object==>"+ls.contains(s1));
		System.out.println("-----------------------------------------------------------");
		System.out.println("Element of HashSet are:");
		ls.forEach(i -> {
			System.out.println(i);
		});
		System.out.println("-----------------------------------------------------------");
		System.out.println("s1.equals(s2)==>>" + s1.equals(s2));
		System.out.println("s1.hashCode() == s2.hashCode()==>" + (s1.hashCode() == s2.hashCode()));
		System.out.println("-----------------------------------------------------------");
		System.out.println("s1.equals(s3)==>>" + s1.equals(s3));
		System.out.println("s1.hashCode() == s3.hashCode()==>" + (s1.hashCode() == s3.hashCode()));
		
		/**
		 ** OUTPUT: consider the below output as there is equals and hasCode method defined in student class properly currently:::

		Before removing S1 element, size of hashset is==> 2
		Does Hashset contains S1 Object==>true
		-----------------------------------------------------------
		-----------------------------------------------------------
		After removing S1 element, size of hashset is==> 1
		Does Hashset contains S1 Object==>false
		-----------------------------------------------------------
		Element of HashSet are:
		Student [id=2, name=anurag, age=22]
		-----------------------------------------------------------
		s1.equals(s2)==>>true
		s1.hashCode() == s2.hashCode()==>true
		-----------------------------------------------------------
		s1.equals(s3)==>>false
		s1.hashCode() == s3.hashCode()==>false


		 */

	}

	public static void operationsOnList() {

		Student s1 = new Student(1, "ankit", 25);
		Student s2 = new Student(1, "ankit", 2522);
		Student s3 = new Student(2, "anurag", 22);
		Student s4 = s1;
		List<Student> ls = new ArrayList<>();
		ls.add(s1);
		ls.add(s2);
		ls.add(s3);
		ls.add(s4);

		System.out.println("Before removing S1 element, size of List is==> " + ls.size());
		System.out.println("Does List contains S1 Object==>"+ls.contains(s1));
		System.out.println("-----------------------------------------------------------");
		ls.remove(s1);
		System.out.println("-----------------------------------------------------------");
		System.out.println("After removing S1 element, size of List is==> " + ls.size());
		System.out.println("Does List contains S1 Object==>"+ls.contains(s1));
		System.out.println("-----------------------------------------------------------");
		System.out.println("Element of List are:");
		ls.forEach(i -> {
			System.out.println(i);
		});
		System.out.println("-----------------------------------------------------------");
		System.out.println("s1.equals(s2)==>>" + s1.equals(s2));
		System.out.println("s1.hashCode() == s2.hashCode()==>" + (s1.hashCode() == s2.hashCode()));
		System.out.println("-----------------------------------------------------------");
		System.out.println("s1.equals(s3)==>>" + s1.equals(s3));
		System.out.println("s1.hashCode() == s3.hashCode()==>" + (s1.hashCode() == s3.hashCode()));
		
		/**
		 * OUTPUT: consider the below output as there is equals and hasCode method defined in student class properly currently:::
		 *  
			Before removing S1 element, size of List is==> 4
			Does List contains S1 Object==>true
			-----------------------------------------------------------
			-----------------------------------------------------------
			After removing S1 element, size of List is==> 3
			Does List contains S1 Object==>true			// <----NOTE: here output is true because we have S2 defined with the same new student object with name id and name and due to equals method it is considering true if we remove the equals method from the Student class the output will be false as it will then use the equals() method of Object class and that uses reference comparison. for more you can verify the below lines of equals method output.
			-----------------------------------------------------------
			Element of List are:
			Student [id=1, name=ankit, age=2522]
			Student [id=2, name=anurag, age=22]
			Student [id=1, name=ankit, age=25]
			-----------------------------------------------------------
			s1.equals(s2)==>>true
			s1.hashCode() == s2.hashCode()==>true
			-----------------------------------------------------------
			s1.equals(s3)==>>false
			s1.hashCode() == s3.hashCode()==>false



		 */
		
		
	}

}
