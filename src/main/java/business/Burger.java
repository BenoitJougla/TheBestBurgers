package business;

import java.util.List;

import com.google.common.base.Preconditions;

import beans.BurgerBean;
import beans.GradeBean;
import beans.IngredientBean;
import dataAccess.DAOManager;

public class Burger {

    private final BurgerBean burgerBean;

    public Burger(BurgerBean bean) {
        Preconditions.checkNotNull(bean, "BurgerBean");
        burgerBean = bean;
    }

    public Burger() {
        this(new BurgerBean());
    }

    public void save() {
        DAOManager.getInstance().saveBurger(burgerBean);
    }

    public boolean exists() {
        return burgerBean.getId() > 0l;
    }

    public List<IngredientBean> getIngredients() {
        return burgerBean.getIngredients();
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        burgerBean.setIngredients(ingredients);
    }

    public long getId() {
        return burgerBean.getId();
    }

    public void setId(long id) {
        burgerBean.setId(id);
    }

    public String getName() {
        return burgerBean.getName();
    }

    public void setName(String name) {
        burgerBean.setName(name);
    }

    public String getDescription() {
        return burgerBean.getDescription();
    }

    public void setDescription(String description) {
        burgerBean.setDescription(description);
    }

    public String getPicture() {
        return burgerBean.getPicture();
    }

    public void setPicture(String picture) {
        burgerBean.setPicture(picture);
    }

    public void addIngredient(IngredientBean i) {
        final List<IngredientBean> ingredients = burgerBean.getIngredients();
        ingredients.add(i);
        burgerBean.setIngredients(ingredients);
    }
    
    public void addGrade(GradeBean g) {
        final List<GradeBean> grades = burgerBean.getGrades();
        grades.add(g);
        burgerBean.setGrades(grades);
    }

}
