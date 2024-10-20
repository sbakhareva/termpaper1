public class EmployeeBook {

    private static Employee[] employees = {
            new Employee("Исаков Варлаам Вениаминович", 23876, 4),
            new Employee("Игнатова Амира Евгеньевна", 115743, 1),
            new Employee("Ершов Ермак Валерьянович", 67802, 3),
            new Employee("Крылова Лариса Геннадьевна", 37800, 5),
            new Employee("Пахомова Анна Феликсовна", 54876, 1),
            new Employee("Лихачёв Павел Улебович", 45600, 3),
            new Employee("Алексеева Марианна Артемовна", 73980, 2),
            null,
            null,
            null
    };

    public static void main(String[] args) {
        printEmployees();
        printSalarySum();
        findMaxSalary();
        findMinSalary();
        findAverageSalary();
        printName();
        indexingSalary(9.8);
        printMinDepartmentSalary(1);
        printMaxDepartmentSalary(2);
        printSumDepartmentSalary(3);
        averageDepartmentSalary(4);
        indexDepartmentSalary(5, 9.8);
        printAllDepartmentStaff(4);
        printPoorEmployees(30000);
        printNotPoorEmployees(90000);
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

        public void printSalarySum() {
            int sumSalary = 0;
            for (Employee employees : employees) {
                sumSalary += employees.getSalary();
            }
            System.out.println(sumSalary);
        }

        public void findMaxSalary() {
            Employee oneWithMaxSalary = employees[0];
            for (Employee employee : employees) {
                if (employee.getSalary() > oneWithMaxSalary.getSalary()) {
                    oneWithMaxSalary = employee;
                }
            }
            System.out.println("Сотрудник с максимальной зарплатой — " + oneWithMaxSalary.getName());
        }

        public void findMinSalary() {
            Employee oneWithMinSalary = employees[0];
            for (Employee employee : employees) {
                if (employee.getSalary() < oneWithMinSalary.getSalary()) {
                    oneWithMinSalary = employee;
                }
            }
            System.out.println("Сотрудник с минимальной зарплатой — " + oneWithMinSalary.getName());
        }

        public void findAverageSalary() {
            int sumSalary = 0;
            for (Employee employees : employees) {
                sumSalary += employees.getSalary();
            }
            float averageSalary;
            averageSalary = (float) sumSalary / employees.length;
            System.out.println("Средняя зарплата в компании в месяц — " + averageSalary + " рублей.");
        }

        public void printName() {
            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }
        }

        public void indexingSalary(double index) {
            float indexWages;
            double indexing = 1 + (index / 100);
            for (Employee salary : employees) {
                indexWages = (float) (salary.getSalary() * indexing);
                System.out.println(salary.getName() + " теперь получает " + indexWages + " рублей.");
            }
        }

        public void printMinDepartmentSalary(int department) {
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

        public void printMaxDepartmentSalary(int department) {
            Employee maxSalary = employees[0];
            for (Employee employee : employees) {
                if (employee.getSalary() > maxSalary.getSalary() && department == employee.getDepartment()) {
                    maxSalary = employee;
                }
            }
            System.out.println("В отеделе №" + department + " сотрудник с самой высокой зарплатой — " + maxSalary.getName());
        }

        public void printSumDepartmentSalary(int department) {
            int sumSalary = 0;
            for (Employee employee : employees) {
                if (department == employee.getDepartment()) {
                    sumSalary += employee.getSalary();
                }
            }
            System.out.println("В отделе №" + department + " сумма затрат на зарплату равна " + sumSalary + " рублей");
        }

        public void averageDepartmentSalary(int department) {
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

        public void indexDepartmentSalary(int department, double index) {
            float indexedSalary;
            double indexing = 1 + (index / 100);
            for (Employee employee : employees) {
                if (department == employee.getDepartment()) {
                    indexedSalary = (float) (employee.getSalary() * indexing);
                    System.out.println("Теперь " + employee.getName() + " получает зарплату " + indexedSalary + " рублей");
                }
            }
        }

    public void printAllDepartmentStaff(int department) {
            for (Employee employee : employees) {
                if (department == employee.getDepartment()) {
                    System.out.println("Сотрудник: " + employee.getName() + ", " + employee.getSalary() + ", " + employee.getId());
                }
            }
        }

    public void printPoorEmployees(int number) {
            if (number <= 0) {
                throw new IllegalArgumentException("Ты зарабатываешь на хлеб и масло!");
            }
            for (Employee employee : employees) {
                if (employee.getSalary() < number) {
                    System.out.println("Сотрудник " + employee.getName() + ", " + employee.getSalary() + ", " + employee.getId() + " в месяц получает меньше " + number);
                }
            }
        }

    public void printNotPoorEmployees(int number) {
            for (Employee employee : employees) {
                if (employee.getSalary() > number) {
                    System.out.println("Сотрудник " + employee.getName() + ", " + employee.getSalary() + ", " + employee.getId() + " в месяц получает более " + number);
                }
            }
        }
    }
