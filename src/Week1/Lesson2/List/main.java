package Week1.Lesson2.List;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>();// default initial capacity=10
//        l.add(10);
//        System.out.println(l);
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("John", 20));
        emp.add(new Employee("Alice", 25));
        emp.add(new Employee("Bob", 30));
        emp.forEach(e -> System.out.println(e.name + " " + e.age));

        // remove john from the list by using index
        emp.remove(1);

        //remove alice by using object reference
        emp.remove(emp.get(1));
        System.out.println(emp);
        // if int Ineteger.valueOf(20)

    }
}