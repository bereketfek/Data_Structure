package Assignment.Ass1;

public class Student extends Person{
    public Student(String name, String id) {
        super(name, id);
    }
    @Override
    public String getRole() {

        return "Student";
    }
}
