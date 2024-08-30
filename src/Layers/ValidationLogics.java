package Layers;

import DataAccessObjects.FeedbackDAO;
import Objects.Feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ValidationLogics extends FormValidations {
    private static final FeedbackDAO feedbackDAO = new FeedbackDAO();

    private Boolean validateFeedback(Feedback feedback) {
        int feedbackCode = feedback.getFeedbackCode();
        String presenterName = feedback.getPresenterName();
        int feedbackRating = feedback.getFeedbackRating();
        String feedbackDescription = feedback.getFeedbackDescription();

        if(!nameValidation(presenterName)) {
            System.out.println("Error: Name is not valid");
            return false;
        }

        if(!ratingValidation(feedbackRating)) {
            System.out.println("Error: Ratings is not valid");
            return false;
        }

        if(!descriptionValidation(feedbackDescription)) {
            System.out.println("Error: Description is not valid");
            return false;
        }

        return true;
    }

    public void insertFeedback(Feedback feedback){
        if(validateFeedback(feedback)){
            feedbackDAO.insertFeedback(feedback);
        }
    }

    public void deleteFeedback(Integer feedbackID) {
        feedbackDAO.deleteFeedback(feedbackID);
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> allFeedbacks = feedbackDAO.getAllFeedback();
        List<Feedback> goodFeedbacks = new ArrayList<>();

        for(Feedback feedback : allFeedbacks){
            if(feedback.getFeedbackRating() > 6){
                goodFeedbacks.add(feedback);
            }
        }

        return goodFeedbacks;
    }
}
