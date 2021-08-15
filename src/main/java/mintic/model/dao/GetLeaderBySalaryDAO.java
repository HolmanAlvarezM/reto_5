package mintic.model.dao;

import mintic.model.vo.LeadersBySalary;
import mintic.util.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetLeaderBySalaryDAO {
    public ArrayList<LeadersBySalary> GetLeaderBySalary() throws SQLException {
        Connection connection = ConnectionJDBC.getConnection();
        ArrayList<LeadersBySalary> leaders = new ArrayList<LeadersBySalary>();

        try {
            String query = "SELECT Nombre, Primer_Apellido, ID_Lider, Salario " + "FROM Lider "
                    + "WHERE Salario <= 500000 " + "ORDER BY Salario";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                LeadersBySalary leader = new LeadersBySalary();
                leader.setName(result.getString("Nombre"));
                leader.setFirstName(result.getString("Primer_Apellido"));
                leader.setIdLeader(result.getInt("ID_Lider"));
                leader.setSalary(result.getInt("Salario"));
                leaders.add(leader);
            }

            result.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error consultando los lideres por salario " + e.getMessage());
        } finally {
            connection.close();
        }

        return leaders;
    }
}