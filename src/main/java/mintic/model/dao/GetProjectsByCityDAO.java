package mintic.model.dao;

import mintic.model.vo.ProjectsByCity;
import mintic.util.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetProjectsByCityDAO {
    private ArrayList<ProjectsByCity> projects = new ArrayList<ProjectsByCity>();

    public ArrayList<ProjectsByCity> GetProjectsByCity() throws SQLException {
        Connection connection = ConnectionJDBC.getConnection();

        try {
            String query = "select ID_Proyecto, Constructora, Ciudad, Estrato " + "from Proyecto p, Tipo t "
                    + "where Ciudad = 'Cartagena' and p.ID_Tipo = t.ID_Tipo " + "order by t.Estrato";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ProjectsByCity project = new ProjectsByCity();
                project.setIdProject(result.getInt("ID_Proyecto"));
                project.setBuilder(result.getString("Constructora"));
                project.setCity(result.getString("Ciudad"));
                project.setStratum(result.getInt("Estrato"));
                projects.add(project);
            }

            result.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error consultando los proyectos por ciudad " + e.getMessage());
        } finally {
            connection.close();
        }

        return projects;
    }
}