import java.util.ArrayList;
abstract class Employee{
  private String name;
  private int id;
  // cunstructor
  public Employee(String name, int id){
    this.name=name;
    this.id=id;
  }
  public String getname(){
    return name;
  }
  public int getid(){
    return id;
  }
  public abstract double calculateSalary();
  public String toString(){
    return "Employee[name="+name+",id="+id+",Salary="+calculateSalary()+"]";
  }
}
class fullTimeEmployee extends Employee{
  private double monthlySalary;
  public fullTimeEmployee(String name, int id, double monthlySalary){
    super(name, id);
    this.monthlySalary=monthlySalary;
  }
  public double calculateSalary(){
    return monthlySalary;
  }
}
class partTimeEmployee extends Employee{
  private int hourWorked;
  private double hourleyRate;
  public partTimeEmployee(String name, int id, int hourWorked, double hourleyRate){
    super(name, id);
    this.hourWorked=hourWorked;
    this.hourleyRate=hourleyRate;
  }
  public double calculateSalary(){
    return hourWorked*hourleyRate;
  }
}
class payRollSystem{
  // declation of arraylist for storing employee's data in arraylist
  private ArrayList<Employee> employeeList;
  // payrollsystem cunstrutor and we can initialise the aaray list in this cunstrutor
  public payRollSystem(){
   employeeList= new ArrayList<>();
  }
  public void addEmployee(Employee employee){
    employeeList.add(employee);
  }
  public void removeEmployee(int id){
    Employee employeeToRemove= null;
    for(Employee employee: employeeList){
      if(employee.getid()==id){
        employeeToRemove = employee;
        break;
      }
    }
    if(employeeToRemove!= null){
      employeeList.remove(employeeToRemove);
    }
  }
  public void displayEmployee(){
    for(Employee employee: employeeList){
      System.out.println(employee);
    }
  }
}
// main method
public class EmployeePayrollSystem{
  public static void main(String[] args){
    payRollSystem PayRollSystem  = new payRollSystem();
    fullTimeEmployee emp1= new fullTimeEmployee("vikas",1, 70000.00);
    partTimeEmployee emp2 = new partTimeEmployee("neha",2,50,100.00);
    PayRollSystem.addEmployee(emp1);
    PayRollSystem.addEmployee(emp2);
    System.out.println("initial emloyee details: ");
    PayRollSystem.displayEmployee();
    System.out.println("removing employee details: ");
    PayRollSystem.removeEmployee(2);
    System.out.println("remaining employee details: ");
    PayRollSystem.displayEmployee();

  }
}