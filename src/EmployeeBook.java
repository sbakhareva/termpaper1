public class EmployeeBook {
    private final EmployeeBook[] book;
    private int size;

    public EmployeeBook() {
        this.book = new EmployeeBook[10];
    }

    public void addNewEmployee(String name, int salary, int department) {
        if (size >= book.length) {
            System.out.println("Этой конторе не нужен новый сотрудник.");
        }
        EmployeeBook newEmployee = new EmployeeBook();
        book[size++] = newEmployee;
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < book.length; i++) {
            if (Employee.getId(book[i]).equals(id)) {
                System.out.println(Employee.getName(book[i]) + " удален.");
                System.arraycopy(book, i + 1, book, i, size - i - 1);
                book[size - 1] = null;
                size--;
            }
        }
    }

    public static void main(String[] args) {

    }

    public void printEmployees() {
        for (EmployeeBook employee : book) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void printSalarySum() {
        int sumSalary = 0;
        for (EmployeeBook employee : book) {
            sumSalary += Employee.getSalary(employee);
        }
        System.out.println(sumSalary);
    }

    public void findMaxSalary() {
        EmployeeBook oneWithMaxSalary = book[0];
        for (EmployeeBook employee : book) {
            if (Employee.getSalary(employee) > Employee.getSalary(oneWithMaxSalary)) {
                oneWithMaxSalary = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой — " + Employee.getName(oneWithMaxSalary));
    }

    public void findMinSalary() {
        EmployeeBook oneWithMinSalary = book[0];
        for (EmployeeBook employee : book) {
            if (Employee.getSalary(employee) < Employee.getSalary(oneWithMinSalary)) {
                oneWithMinSalary = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой — " + Employee.getName(oneWithMinSalary));
    }

    public void findAverageSalary() {
        int sumSalary = 0;
        for (EmployeeBook employee : book) {
            sumSalary += Employee.getSalary(employee);
        }
        float averageSalary;
        averageSalary = (float) sumSalary / book.length;
        System.out.println("Средняя зарплата в компании в месяц — " + averageSalary + " рублей.");
    }

    public void printName() {
        for (EmployeeBook employee : book) {
            System.out.println(Employee.getName(employee));
        }
    }

    public void indexingSalary(double index) {
        float indexWages;
        double indexing = 1 + (index / 100);
        for (EmployeeBook salary : book) {
            indexWages = (float) (Employee.getSalary(salary) * indexing);
            System.out.println(Employee.getName(salary) + " теперь получает " + indexWages + " рублей.");
        }
    }

    public void printMinDepartmentSalary(int department) {
        EmployeeBook minSalary = null;
        for (EmployeeBook employee : book) {
            if (minSalary == null || (employee != null && Employee.getSalary(employee) < Employee.getSalary(minSalary) && department == Employee.getDepartment(employee))) {
                minSalary = employee;
                System.out.println("Сотрудник с минимальной зарплатойЖ " + minSalary);
            }
        }
    }

        public void printMaxDepartmentSalary(int department){
            EmployeeBook maxSalary = book[0];
            for (EmployeeBook employee : book) {
                if (Employee.getSalary(employee) > Employee.getSalary(maxSalary) && department == Employee.getDepartment(employee)) {
                    maxSalary = employee;
                }
            }
            System.out.println("В отеделе №" + department + " сотрудник с самой высокой зарплатой — " + Employee.getName(maxSalary)); // тут вообще непонятно откуда брать метод
        }

        public void printSumDepartmentSalary ( int department){
            int sumSalary = 0;
            for (EmployeeBook employee : book) {
                if (department == Employee.getDepartment(employee)) {
                    sumSalary += Employee.getSalary(employee);
                }
            }
            System.out.println("В отделе №" + department + " сумма затрат на зарплату равна " + sumSalary + " рублей");
        }

        public void averageDepartmentSalary(int department){
            int sumSalary = 0;
            int counter = 0;
            float averageSalary = 0.00f;
            for (EmployeeBook employee : book) {
                if (department == Employee.getDepartment(employee)) {
                    ++counter;
                    sumSalary += Employee.getSalary(employee);
                    averageSalary = (float) sumSalary / counter;
                }
            }
            System.out.println("Средняя зарпалата в отделе — " + averageSalary + " рублей.");
        }

        public void indexDepartmentSalary(int department, double index) {
            float indexedSalary;
            double indexing = 1 + (index / 100);
            for (EmployeeBook employee : book) {
                if (department == Employee.getDepartment(employee)) {
                    indexedSalary = (float) (Employee.getSalary(employee) * indexing);
                    System.out.println("Теперь " + Employee.getName(employee) + " получает зарплату " + indexedSalary + " рублей");
                }
            }
        }

        public void printAllDepartmentStaff(int department) {
            for (EmployeeBook employee : book) {
                if (department == Employee.getDepartment(employee)) {
                    System.out.println("Сотрудник: " + Employee.getName(employee) + ", " + Employee.getSalary(employee) + ", " + Employee.getId(employee));
                }
            }
        }

        public void printPoorEmployees(int number) {
            if (number <= 0) {
                throw new IllegalArgumentException("Всё не может быть настолько плохо.");
            }
            for (EmployeeBook employee : book) {
                if (Employee.getSalary(employee) < number) {
                    System.out.println("Сотрудник " + Employee.getName(employee) + ", " + Employee.getSalary(employee) + ", " + Employee.getId(employee) + " в месяц получает меньше " + number);
                }
            }
        }

        public void printNotPoorEmployees(int number) {
            for (EmployeeBook employee : book) {
                if (Employee.getSalary(employee) > number) {
                    System.out.println("Сотрудник " + Employee.getName(employee) + ", " + Employee.getSalary(employee) + ", " + Employee.getId(employee) + " в месяц получает более " + number);
                }
            }
        }
}