package dataAccess;

import java.util.List;

import javax.persistence.NoResultException;

import beans.IngredientBean;
import business.Ingredient;

public class JpaIngredient implements Dao<IngredientBean> {

    public IngredientBean findById(long id) {
        return findById(id, "Ingredient", IngredientBean.class);
    }
    
    public IngredientBean findByName(String name) {
        try {
            return entityManagerExecutor.execute(em -> em.createQuery("select i from Ingredient i where i.name='" + name + "'", IngredientBean.class).getSingleResult());
        } catch (final NoResultException e) {
            return null;
        }
    }
    
    public List<Ingredient> findAllIngredients(){
    	try{
    		return (List<Object>) entityManagerExecutor.findAllEntity("Ingredient");
    	}
    }
}
