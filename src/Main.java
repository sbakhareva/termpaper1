import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        book.addNewEmployee("Исаков Варлаам Вениаминович", 23876, 4);
        book.addNewEmployee("Игнатова Амира Евгеньевна", 115743, 1);
        book.addNewEmployee("Ершов Ермак Валерьянович", 67802, 3);
        book.addNewEmployee("Крылова Лариса Геннадьевна", 37800, 5);
        book.addNewEmployee("Пахомова Анна Феликсовна", 54876, 1);
        book.addNewEmployee("Лихачёв Павел Улебович", 45600, 3);
        book.addNewEmployee("Алексеева Марианна Артемовна", 73980, 2);



        System.out.println("Задание 8.а");
        book.printEmployees();
        System.out.println("Задание 8.b");
        book.printSalarySum();
        System.out.println("Задание 8.с");;
        book.findMinSalary();
        System.out.println("Задание 8.d");
        book.findMaxSalary();
        System.out.println("Задание 8.e");
        book.findAverageSalary();
        System.out.println("Задание 8.f");
        book.printName();
        System.out.println("Задание 1");
        book.indexingSalary(3.4);
        System.out.println("Задание 2.a");
        book.printMinDepartmentSalary(2);
        System.out.println("Задание 2.b");
        book.printMaxDepartmentSalary(5);
        System.out.println("Задание 2.c");
        book.printSumDepartmentSalary(2);
        System.out.println("Задание 2.d");
        book.averageDepartmentSalary(1);
        System.out.println("Задание 2.e");
        book.indexDepartmentSalary(3,9.8);
        System.out.println("Задание 2.f");
        book.printAllDepartmentStaff(5);
        System.out.println("Задание 3.a");
        book.printPoorEmployees(30000);
        System.out.println("Задание 3.b");
        book.printNotPoorEmployees(100000);
    }
}