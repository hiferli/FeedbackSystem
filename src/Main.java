import DataAccessObjects.CloudDAO;
import DataAccessObjects.FeedbackDAO;
import Layers.ValidationLogics;
import Objects.Credential;
import Objects.Feedback;

import java.util.List;

public class Main {
    private static void displayFeedbacks(
//            FeedbackDAO feedbackDAO,
            ValidationLogics validationLogicsDAO
    ) {
//        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        List<Feedback> feedbackList = validationLogicsDAO.getAllFeedback();

        for (Feedback feedback : feedbackList) {
            System.out.println("Feedback Code: " + feedback.getFeedbackCode());
            System.out.println("Presenter Name: " + feedback.getPresenterName());
            System.out.println("Feedback Rating: " + feedback.getFeedbackRating());
            System.out.println("Feedback Description: " + feedback.getFeedbackDescription());
            System.out.println("-----------");
        }
    }

    private static void deleteFeedback(
//            FeedbackDAO feedbackDAO
            ValidationLogics validationLogicsDAO
    ) {
        System.out.println("Performing Deletion");
//        feedbackDAO.deleteFeedback(3);
        validationLogicsDAO.deleteFeedback(6);
        System.out.println("Deleted!");
    }

    private static void addFeedback(
//            FeedbackDAO feedbackDAO,
            ValidationLogics validationLogicsDAO
    ){
        Feedback feedback1 = new Feedback();
        feedback1.setPresenterName("Ishaan Joshi");
        feedback1.setFeedbackRating(-1);
        feedback1.setFeedbackDescription("");
//        feedbackDAO.insertFeedback(feedback1);
        validationLogicsDAO.insertFeedback(feedback1);

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

////        FeedbackDAO feedbackDAO = new FeedbackDAO();
//        ValidationLogics validationLogicsDAO = new ValidationLogics();
//
//        // Insert new feedback
//        addFeedback(validationLogicsDAO);
//
//        // Get all feedback
//        displayFeedbacks(validationLogicsDAO);
//
//        // deleting feedback
//        deleteFeedback(validationLogicsDAO);
//
//        // Get all feedback
//        displayFeedbacks(validationLogicsDAO);

        CloudDAO newDao = new CloudDAO();
        List<Credential> allCreds = newDao.getAllCredentials();

        for(Credential credential : allCreds){
            System.out.println("Credentials: ");
            System.out.println("Name: " + credential.getName());
            System.out.println("Username: " + credential.getUsername());
            System.out.println("Password: " + credential.getPassword());
            System.out.println("Sandbox Name: " + credential.getSandboxName());
        }
    }
}