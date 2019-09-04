package multithreading;

public class EmployeeSalary1 extends Thread {
	private int empno;
	private String empName;
	private int salary;
	EmployeeSalary1 es = null;
	public void setEmployee(EmployeeSalary1 es){
		this.es= es;
		es.start();
	}
	public void run(){
		es.salaryCalculation();
	}
	public EmployeeSalary1(int empno, String empName, int salary) {
		super();
		this.empno = empno;
		this.empName = empName;
		this.salary = salary;
	}
	public void salaryCalculation(){
		System.out.println("Basic hra of emp : "+empno+" is: "+(salary*0.1));
		System.out.println("Basic da of emp : "+empno+" is: "+(salary*0.25));
		System.out.println("Basic ca of emp : "+empno+" is: "+(salary*0.1));
		
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String name) {
		this.empName = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static void main(String... sd) {
			EmployeeSalary1 es1 = new EmployeeSalary1(1,"Rishabh",200);
			EmployeeSalary1 es2 = new EmployeeSalary1(2,"Manas",300);
			EmployeeSalary1 es3 = new EmployeeSalary1(3,"Rishi",400);
			EmployeeSalary1 es4 = new EmployeeSalary1(4,"Ronak",500);
			EmployeeSalary1 es5 = new EmployeeSalary1(5,"Rohit",600);
			es1.setEmployee(es1);
			es2.setEmployee(es2);
			es3.setEmployee(es3);
			es4.setEmployee(es4);
			es5.setEmployee(es5);
		
			
			
	}
}
