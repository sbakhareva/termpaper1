import java.util.Objects;

public class Employee {
    private int id;
    private static int idCounter;
    private final String name;
    private int department;
    private int salary;

    public Employee(String name, int salary, int department) {
        this.id = ++idCounter;
        this.name = name;
        this.salary = salary;
        this.department = department;

    }

    @Override
    public String toString() {
        return name + ", " + salary + "," + department;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Найдется работа получше");
        } else this.salary = salary;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        } else this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, id);
    }
}
