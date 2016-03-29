package dataAccess;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import beans.BurgerBean;
import beans.RestaurantBean;
import business.Burger;

public class JpaBurger implements Dao<BurgerBean> {

    public BurgerBean findById(long id) {
        return findById(id, "Burger", BurgerBean.class);
    }
    
    public List<Burger> findAllBurgers(){
    	List<BurgerBean> listBean = entityManagerExecutor.execute(em -> em.createQuery("select b from Burger b", BurgerBean.class).getResultList());
    	List<Burger> burgerList = new ArrayList<Burger>();
    	
    	for(BurgerBean bean : listBean){
    		burgerList.add(new Burger(bean));
    	}
    	
    	return burgerList;
    }
    
    public Burger findByName(String name) {
        try {
            return new Burger (entityManagerExecutor.execute(em -> em.createQuery("select b from Burger b where b.name='" + name + "'", BurgerBean.class).getSingleResult()));
        } catch (final NoResultException e) {
            return null;
        }
    }
}
