package ml.salastexido.parallelstream;

import java.util.Arrays;
import java.util.Collection;

import ml.salastexido.parallelstream.models.Employee;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		Collection<Employee> employees = Arrays.asList(
				new Employee("A",25),new Employee("B",45),new Employee("C",16));
		
		int total = employees.stream()
										.parallel()
										.mapToInt(Employee::getAge).sum();
		System.out.println(total);	

	}

}
