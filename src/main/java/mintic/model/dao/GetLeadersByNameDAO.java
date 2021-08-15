package mintic.model.dao;

import mintic.model.vo.LeadersByName;
import mintic.util.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetLeadersByNameDAO {
    public ArrayList<LeadersByName> GetLeadersByName() throws SQLException {
        Connection connection = ConnectionJDBC.getConnection();
        ArrayList<LeadersByName> leaders = new ArrayList<LeadersByName>();

        try {
            String query = "select ID_Lider, Nombre, Primer_Apellido " + "from Lider "
                    + "where Primer_Apellido like('%z') " + "order by Nombre";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                LeadersByName leader = new LeadersByName();
                leader.setName(result.getString("Nombre"));
                leader.setFirstName(result.getString("Primer_Apellido"));
                leader.setIdLeader(result.getInt("ID_Lider"));
                leaders.add(leader);
            }

            result.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error consultando los lideres por nombre " + e.getMessage());
        } finally {
            connection.close();
        }

        return leaders;
    }
}