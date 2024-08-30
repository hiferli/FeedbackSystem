package DataAccessObjects;

import DatabaseConnection.DatabaseConnection;
import Objects.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    // Method to insert feedback
    public void insertFeedback(Feedback feedback) {
        String sql = "INSERT INTO Feedback (PresenterName, FeedbackRating, FeedbackDescription) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getPresenterName());
            stmt.setInt(2, feedback.getFeedbackRating());
            stmt.setString(3, feedback.getFeedbackDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFeedback(Integer feedbackID) {
        String deleteQuery = "DELETE FROM Feedback WHERE FeedbackCode = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, feedbackID);
            deleteStatement.executeUpdate();
            System.out.println("Feedback " + feedbackID + " deleted!");
        } catch (SQLException e) {
            System.out.println("Error in deleting feedbacks: " + e.getMessage());
        }
    }

    // Method to get all feedback
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM Feedback";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackCode(rs.getInt("FeedbackCode"));
                feedback.setPresenterName(rs.getString("PresenterName"));
                feedback.setFeedbackRating(rs.getInt("FeedbackRating"));
                feedback.setFeedbackDescription(rs.getString("FeedbackDescription"));
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }
}