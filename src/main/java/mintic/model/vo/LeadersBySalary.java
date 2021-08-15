package mintic.model.vo;

public class LeadersBySalary {
    private String name;
    private String firstName;
    private Integer idLeader;
    private Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public Integer getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(Integer newIdLeader) {
        idLeader = newIdLeader;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer newSalary) {
        salary = newSalary;
    }
}