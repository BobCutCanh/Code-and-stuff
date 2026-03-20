import java.util.ArrayList;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("E")) {
                list.add(new Employee(name, salary));
            } else if (type.equalsIgnoreCase("D")) {
                int ot = sc.nextInt();
                list.add(new Developer(name, salary, ot));
            } else if (type.equalsIgnoreCase("T")) {
                int bugs = sc.nextInt();
                list.add(new Tester(name, salary, bugs));
            }
        }

        for (Employee emp : list) {
            System.out.println(emp.getName() + " - Bonus: " + emp.calculateBonus());

            if (emp instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (emp instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
            System.out.println();
        }

        sc.close();
    }
}