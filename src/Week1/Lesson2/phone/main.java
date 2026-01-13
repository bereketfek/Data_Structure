package Week1.Lesson2.phone;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
       // List<PhoneDirectory> p= List.of(new PhoneDirectory("bereket", "65496569"));
        List<PhoneDirectory> p= new ArrayList<>();
        p.add( new PhoneDirectory("john","67259676"));
        p.set(0, new PhoneDirectory("john","67259676"));//replace

    }
}
