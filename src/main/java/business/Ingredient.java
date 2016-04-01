package business;

import java.util.List;

import com.google.common.base.Preconditions;

import beans.IngredientBean;
import dataAccess.DAOManager;

public class Ingredient {
    private final IngredientBean ingredientBean;

    public Ingredient() {
        ingredientBean = new IngredientBean();
    }

    public Ingredient(IngredientBean bean) {
        Preconditions.checkNotNull(bean, "IngredientBean");
        ingredientBean = bean;
    }

    public Ingredient(String name) {
        ingredientBean = new IngredientBean();
        setName(name);
    }

    public static Ingredient getIngredientById(long id) {
        return DAOManager.getInstance().getIngredientById(id);
    }

    public void setName(String name) {
        ingredientBean.setName(name);
    }

    public String getName() {
        return ingredientBean.getName();
    }

    public String getPicture() {
        return ingredientBean.getPicture();
    }

    public void setPicture(String picture) {
        ingredientBean.setPicture(picture);
    }

    public IngredientBean getBean() {
        return ingredientBean;
    }

    public void save() {
        DAOManager.getInstance().saveIngredient(ingredientBean);
    }

    public List<Ingredient> getAllIngredients() {
        return DAOManager.getInstance().getAllIngredients();
    }
}
