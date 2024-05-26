package skillbuilder.java8.set2;

import java.util.Map;
import java.util.stream.Collectors;

public class CountNoOfEmpInDept {
	/**
	 * Count the number of employees in each department?
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Map<String, Long> departEMpStat = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		departEMpStat.entrySet().stream().forEach(i -> System.out.println(i.getKey() + ":" + i.getValue()));
		/**
		 * OUTPUT:
		 * Product Development:5
			Security And Transport:2
			Sales And Marketing:3
			Infrastructure:3
			HR:2
			Account And Finance:2
		 * 
		 * 
		 */
	}

}
