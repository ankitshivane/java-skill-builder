package skillbuilder.java8.set2;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class AvgAndTotalSalary {

	/**
	 * What is the average salary and total salary of the whole organization?
	 * 
	 * 
	 */
	public static void main(String[] args) {
		DoubleSummaryStatistics summaryStatistics = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("average salary:" + summaryStatistics.getAverage());
		System.out.println("Total salary:" + summaryStatistics.getSum());
		/**
		 * output:
		 * average salary:21141.235294117647 
		 * Total salary:359401.0
		 * 
		 */
	}

}
