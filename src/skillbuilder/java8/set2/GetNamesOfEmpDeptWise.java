package skillbuilder.java8.set2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetNamesOfEmpDeptWise {

	/**
	 * List down the names of all employees in each department?
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Map<String, List<Employee>> stat = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		stat.entrySet().stream().forEach(i -> {
			System.out.println("Department name:" + i.getKey() + ", Employeee names:"
					+ i.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
		});
		/**
		 * OUTPUT:
		 * Department name:Product Development, Employeee names:[Murali Gowda, Wang Liu, Nitin Joshi, Sanvi Pandey, Anuj Chettiar]
			Department name:Security And Transport, Employeee names:[Iqbal Hussain, Jaden Dough]
			Department name:Sales And Marketing, Employeee names:[Paul Niksui, Amelia Zoe, Nicolus Den]
			Department name:Infrastructure, Employeee names:[Martin Theron, Jasna Kaur, Ali Baig]
			Department name:HR, Employeee names:[Jiya Brein, Nima Roy]
			Department name:Account And Finance, Employeee names:[Manu Sharma, Jyothi Reddy]
		 * 
		 */
	}

}
