package business;

import java.util.List;

import com.google.common.base.Preconditions;

import beans.IngredientBean;
import dataAccess.DAOManager;
import dataAccess.JpaIngredient;

public class Ingredient {
    private final IngredientBean ingredientBean;
    private final JpaIngredient jpaIngredient;

    public Ingredient()
    {
    	ingredientBean = new IngredientBean();
    	jpaIngredient = new JpaIngredient();
    }
    
    public Ingredient(IngredientBean bean) {
        Preconditions.checkNotNull(bean, "IngredientBean");
        jpaIngredient = new JpaIngredient();
        ingredientBean = bean;
    }

    public Ingredient(String name) {
        ingredientBean = new IngredientBean();
        jpaIngredient = new JpaIngredient();
        setName(name);
    }

    public void setName(String name) {
        ingredientBean.setName(name);
    }

    public String getName() {
        return ingredientBean.getName();
    }
    
    public String getPicture(){
    	return ingredientBean.getPicture();
    }
    
    public void setPicture(String picture){
    	ingredientBean.setPicture(picture);
    }
    
    public IngredientBean getBean(){
    	return ingredientBean;
    }
    
    public void save (){
    	DAOManager.getInstance().saveIngredient(ingredientBean);
    }
    
    public List<Ingredient> getAllIngredients(){
    	return DAOManager.getInstance().getAllIngredients();
    }
}
