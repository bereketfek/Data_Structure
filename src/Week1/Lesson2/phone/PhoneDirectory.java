package Week1.Lesson2.phone;

public class PhoneDirectory {
    public String phoneNumber;
    public String name;
    public PhoneDirectory(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
