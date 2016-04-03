package presentation.get;

import java.util.List;

import business.Burger;
import business.Grade;
import business.Ingredient;
import business.Restaurant;

public class BurgerViewBean {
    private final Burger burger;
    private long average_originality;
    private long average_quality;
    private long average_presentation;
    private long average_taste;
    private int nbGrades = 0;

    public BurgerViewBean(Burger burger) {
        this.burger = burger;

        burger.getGrades().forEach(grade -> {
            average_originality += grade.getOriginality();
            average_quality += grade.getQuality();
            average_presentation += grade.getPresentation();
            average_taste += grade.getTaste();
            ++nbGrades;
        });

        average_originality /= nbGrades;
        average_quality /= nbGrades;
        average_presentation /= nbGrades;
        average_taste /= nbGrades;
    }

    public long getId() {
        return burger.getId();
    }

    public String getName() {
        return burger.getName();
    }

    public String getDescription() {
        return burger.getDescription();
    }

    public String getPicture() {
        return burger.getPicture();
    }

    public long getAverageOriginality() {
        return average_originality;
    }

    public long getAverageQuality() {
        return average_quality;
    }

    public long getAveragePresentation() {
        return average_presentation;
    }

    public long getAverageTaste() {
        return average_taste;
    }

    public List<Ingredient> getIngredients() {
        return burger.getIngredients();
    }

    public Restaurant getRestaurant() {
        return burger.getRestaurant();
    }

    public List<Grade> getGrades() {
        return burger.getGrades();
    }
}
