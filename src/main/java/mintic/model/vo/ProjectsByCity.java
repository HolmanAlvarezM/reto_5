package mintic.model.vo;

public class ProjectsByCity {
    private Integer idProject;
    private String builder;
    private String city;
    private Integer stratum;

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer newIdProject) {
        idProject = newIdProject;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String newBuilder) {
        builder = newBuilder;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String newCity) {
        city = newCity;
    }

    public Integer getStratum() {
        return stratum;
    }

    public void setStratum(Integer newStratum) {
        stratum = newStratum;
    }
}