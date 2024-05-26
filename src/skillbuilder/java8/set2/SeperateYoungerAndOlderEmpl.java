package skillbuilder.java8.set2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeperateYoungerAndOlderEmpl {
	/**
	 * Separate the employees who are younger or equal to 25 years from those
	 * employees who are older than 25 years.
	 */
	public static void main(String[] args) {
		Map<Boolean, List<Employee>> stat = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.partitioningBy(i -> i.getAge() > 25));
		stat.entrySet().stream().forEach(i -> {
			if (i.getKey()) {
				System.out.println("Older employees are:"
						+ i.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
			} else {
				System.out.println("Younger employee are:"
						+ i.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
			}
		});
		
		/**
		 * OUTPUT:
		 * 
		 * Younger employee are:[Paul Niksui, Amelia Zoe, Nitin Joshi, Nicolus Den, Ali Baig]
	
		Older employees are:[Jiya Brein, Martin Theron, Murali Gowda, Nima Roy, Iqbal Hussain, Manu Sharma, Wang Liu, Jaden Dough, Jasna Kaur, Jyothi Reddy, Sanvi Pandey, Anuj Chettiar]

		 */
	}

}
