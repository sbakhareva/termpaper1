public class Main {

    private static final Employee[] employees = {
            new Employee("Исаков Варлаам Вениаминович", 23876, 4),
            new Employee("Игнатова Амира Евгеньевна", 115743, 1),
            new Employee("Ершов Ермак Валерьянович", 67802, 3),
            new Employee("Крылова Лариса Геннадьевна", 37800, 5),
            new Employee("Пахомова Анна Феликсовна", 54876, 1),
            new Employee("Лихачёв Павел Улебович", 45600, 3),
            new Employee("Алексеева Марианна Артемовна", 73980, 2),
            new Employee("Демяненко Василий Викторович", 95000, 2),
            new Employee("Ларионова Лейла Никитишна", 70300, 4),
            new Employee("Никонов Кондратий Егорович", 53700, 5)
    };

    public static void main(String[] args) {
        System.out.println("Задание 8.а");
        printEmployees();
        System.out.println("Задание 8.b");
        printSalarySum();
        System.out.println("Задание 8.с");;
        findMinSalary();
        System.out.println("Задание 8.d");
        findMaxSalary();
        System.out.println("Задание 8.e");
        findAverageSalary();
        System.out.println("Задание 8.f");
        printName();
        System.out.println("Задание 1");
        indexingSalary(3.4);
        System.out.println("Задание 2.a");
        printMinDepartmentSalary(2);
        System.out.println("Задание 2.b");
        printMaxDepartmentSalary(5);
        System.out.println("Задание 2.c");
        printSumDepartmentSalary(2);
        System.out.println("Задание 2.d");
        averageDepartmentSalary(1);
        System.out.println("Задание 2.e");
        indexDepartmentSalary(3,9.8);
        System.out.println("Задание 2.f");
        printAllDepartmentStaff(5);
        System.out.println("Задание 3.a");
        printPoorEmployees(30000);
        System.out.println("Задание 3.b");
        printNotPoorEmployees(100000);
    }

    public static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void printSalarySum() {
        int sumSalary = 0;
        for (Employee employees : employees) {
            sumSalary += employees.getSalary();
        }
        System.out.println(sumSalary);
    }

    public static void findMaxSalary() {
        Employee oneWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > oneWithMaxSalary.getSalary()) {
                oneWithMaxSalary = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой — " + oneWithMaxSalary.getName());
    }

    public static void findMinSalary() {
        Employee oneWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < oneWithMinSalary.getSalary()) {
                oneWithMinSalary = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой — " + oneWithMinSalary.getName());
    }

    public static void findAverageSalary() {
        int sumSalary = 0;
        for (Employee employees : employees) {
            sumSalary += employees.getSalary();
        }
        float averageSalary;
        averageSalary = (float) sumSalary / employees.length;
        System.out.println("Средняя зарплата в компании в месяц — " + averageSalary + " рублей.");
    }

    public static void printName() {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    public static void indexingSalary(double index) {
        float indexWages;
        double indexing = 1 + ( index / 100);
        for (Employee salary : employees) {
            indexWages = (float) (salary.getSalary() * indexing);
            System.out.println(salary.getName() + " теперь получает " + indexWages + " рублей.");
        }
    }

    public static void printMinDepartmentSalary(int department) {
        Employee minSalary = employees[1];
        for (Employee employee : employees) {
            if (minSalary == null || (employee.getSalary() < minSalary.getSalary() && department == employee.getDepartment())) {
                minSalary = employee;
            }
        }
        if (minSalary != null) {
            System.out.println("В отеделе №" + department + " сотрудник с минимальной зарплатой — " + minSalary.getName());
        }
    }

    public static void printMaxDepartmentSalary(int department) {
        Employee maxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary.getSalary() && department == employee.getDepartment()) {
                maxSalary = employee;
            }
        }
        System.out.println("В отеделе №" + department + " сотрудник с самой высокой зарплатой — " + maxSalary.getName());
    }

    public static void printSumDepartmentSalary(int department) {
        int sumSalary = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                sumSalary += employee.getSalary();
            }
        }
        System.out.println("В отделе №" + department + " сумма затрат на зарплату равна " + sumSalary + " рублей");
    }

    public static void averageDepartmentSalary(int department) {
        int sumSalary = 0;
        int counter = 0;
        float averageSalary = 0.00f;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                ++counter;
                sumSalary += employee.getSalary();
                averageSalary = (float) sumSalary / counter;
            }
        }
        System.out.println("Средняя зарпалата в отделе — " + averageSalary + " рублей.");
    }

    public static void indexDepartmentSalary(int department, double index) {
        float indexedSalary;
        double indexing = 1 + ( index / 100);
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                indexedSalary = (float) (employee.getSalary() * indexing);
                System.out.println("Теперь " + employee.getName() + " получает зарплату " + indexedSalary + " рублей");
            }
        }
    }

    public static void printAllDepartmentStaff(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.println("Сотрудник: " + employee.getName() + ", " + employee.getSalary() + ", " + employee.getId());
            }
        }
    }

    public static void printPoorEmployees(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Ты зарабатываешь на хлеб и масло!");
        }
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println("Сотрудник " + employee.getName() + ", " + employee.getSalary() + ", " + employee.getId() + " в месяц получает меньше " + number);
            }
        }
    }

    public static void printNotPoorEmployees(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                System.out.println("Сотрудник " + employee.getName() + ", " + employee.getSalary() + ", " + employee.getId() + " в месяц получает более " + number);
            }
        }
    }
}