package business;

import java.util.List;

import com.google.common.base.Preconditions;

import dataAccess.BurgerBean;
import dataAccess.IngredientBean;
import dataAccess.JpaBurger;

public class Burger {

    private final BurgerBean burgerBean;
    private final JpaBurger jpaBurger;

    public Burger(BurgerBean bean, JpaBurger jpa) {
        Preconditions.checkNotNull(bean, "BurgerBean");
        Preconditions.checkNotNull(jpa, "JpaBurger");
        burgerBean = bean;
        jpaBurger = jpa;
    }

    public Burger() {
        this(new BurgerBean(), new JpaBurger());
    }

    public void save() {
        jpaBurger.save(burgerBean);
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

}
