package DataAccessObjects;

import DatabaseConnection.DatabaseConnection;
import Objects.Credential;
import Objects.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CloudDAO {
    public List<Credential> getAllCredentials() {
        List<Credential> credentialList = new ArrayList<>();
        String sql = "SELECT * FROM Credentials";
        try (Connection conn = DatabaseConnection.getCloudConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Credential newCred = new Credential();
                newCred.setName(rs.getString("Name"));
                newCred.setUsername(rs.getString("Username"));
                newCred.setPassword(rs.getString("Password"));
                newCred.setSandboxName(rs.getString("SandboxName"));
                credentialList.add(newCred);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentialList;
    }
}
