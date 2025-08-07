package workshop.oop.flexible.copy;

public class Employee extends Object {

	private String name;
	protected double salary;

	public Employee() {
	}
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}



	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}

}