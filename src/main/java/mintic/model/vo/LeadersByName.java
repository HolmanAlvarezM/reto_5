package mintic.model.vo;

public class LeadersByName {
    private Integer idLeader;
    private String name;
    private String firstName;

    public Integer getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(Integer newIdLeader) {
        idLeader = newIdLeader;
    }

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
}