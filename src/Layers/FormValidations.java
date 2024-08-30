package Layers;

public class FormValidations {
    protected Boolean nameValidation(String name) {
        return !name.isEmpty();
    }

    protected Boolean ratingValidation(Integer rating){
        return (rating >= 1 && rating <= 10);
    }

    protected Boolean descriptionValidation(String description) {
        return (description.length() >= 5);
    }
}
