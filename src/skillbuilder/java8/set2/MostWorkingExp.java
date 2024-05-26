package skillbuilder.java8.set2;

import java.util.Comparator;

public class MostWorkingExp {

	/**
	 * Who has the most working experience in the organization?
	 */
	public static void main(String[] args) {
		Employee employee = EmployeeDB.getAllEmployee().stream()
				.sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst().get();
		System.out.println(employee);
		
		/**
		 * OUTPUT:
		 * Id : 177, Name : Manu Sharma, age : 35, Gender : Male, Department : Account And Finance, Year Of Joining : 2010, Salary : 27000.0
		 * 
		 */
		//approach 2
		Employee employee2 = EmployeeDB.getAllEmployee().stream().min(Comparator.comparing(Employee::getYearOfJoining))
				.get();
		System.out.println(employee2);
		/**
		 * OUTPUT:
		 * Id : 177, Name : Manu Sharma, age : 35, Gender : Male, Department : Account And Finance, Year Of Joining : 2010, Salary : 27000.0
		 * 
		 */
	}

}
