package Objects;

public class Feedback {
    private int feedbackCode;
    private String presenterName;
    private int feedbackRating;
    private String feedbackDescription;

    // Getters and Setters
    public int getFeedbackCode() {
        return feedbackCode;
    }

    public void setFeedbackCode(int feedbackCode) {
        this.feedbackCode = feedbackCode;
    }

    public String getPresenterName() {
        return presenterName;
    }

    public void setPresenterName(String presenterName) {
        this.presenterName = presenterName;
    }

    public int getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(int feedbackRating) {

        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }
}