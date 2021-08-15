package mintic.controller;

import mintic.model.dao.GetLeaderBySalaryDAO;
import mintic.model.dao.GetLeadersByNameDAO;
import mintic.model.dao.GetProjectsByCityDAO;
import mintic.model.vo.LeadersByName;
import mintic.model.vo.LeadersBySalary;
import mintic.model.vo.ProjectsByCity;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerReto5 {
    private GetLeaderBySalaryDAO _leadersBySalary;
    private GetProjectsByCityDAO _projectsByCity;
    private GetLeadersByNameDAO _leadersByName;

    public ControllerReto5() {
        _leadersBySalary = new GetLeaderBySalaryDAO();
        _projectsByCity = new GetProjectsByCityDAO();
        _leadersByName = new GetLeadersByNameDAO();
    }

    public ArrayList<LeadersBySalary> GetLeadersBySalary() throws SQLException {
        return _leadersBySalary.GetLeaderBySalary();
    }

    public ArrayList<ProjectsByCity> GetProjectsByCity() throws SQLException {
        return _projectsByCity.GetProjectsByCity();
    }

    public ArrayList<LeadersByName> GetLeadersByName() throws SQLException {
        return _leadersByName.GetLeadersByName();
    }
}