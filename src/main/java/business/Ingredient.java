package business;

import com.google.common.base.Preconditions;

import beans.IngredientBean;

public class Ingredient {
    private final IngredientBean ingredientBean;

    public Ingredient()
    {
    	ingredientBean= new IngredientBean();
    }
    
    public Ingredient(IngredientBean bean) {
        Preconditions.checkNotNull(bean, "IngredientBean");
        ingredientBean = bean;
    }

    public Ingredient(String name) {
        ingredientBean = new IngredientBean();
        setName(name);
    }

    public void setName(String name) {
        ingredientBean.setName(name);
    }

    public String getName() {
        return ingredientBean.getName();
    }
    
    public IngredientBean getBean(){
    	return ingredientBean;
    }
}
