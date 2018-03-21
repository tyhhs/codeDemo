package test.reflect;

/**
 * Employee
 * Author: bjtangyunhao
 * Creation date: 2018年03月16日 11:27
 * Modified by: bjtangyunhao
 * Last modified: 2018年03月16日 11:27
 */
public class Employee extends Person{
    private String title;

    private Double salary;

    public Employee(String name, String title, Double salary) {
        super(name);
        this.title = title;
        this.salary = salary;
    }

    public void desc(){
        System.out.println(super.getName() + " " + this.title + " " + this.salary);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
