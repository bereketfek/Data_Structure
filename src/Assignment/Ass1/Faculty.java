package Assignment.Ass1;

public class Faculty extends Person {

    public Faculty(String name, String id) {
        super(name, id);
    }

    @Override
    public String getRole() {

        return "Faculty";
    }
}
