package Assignment.Ass9;

import java.time.LocalDateTime;

public class Visitor {
    private String name;
    private int badgeNumber;
    private LocalDateTime entryTime;


    public Visitor(String name, int badgeNumber ) {
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.entryTime = LocalDateTime.now();
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", badgeNumber=" + badgeNumber +
                ", entryTime=" + entryTime +
                '}';
    }
}

