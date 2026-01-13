package Assignment.Ass1;

public class Visitor extends Person{

    public Visitor(String name, String id) {
        super(name, id);
    }

    @Override
    public String getRole() {
        return "Visitor";

    }

}
