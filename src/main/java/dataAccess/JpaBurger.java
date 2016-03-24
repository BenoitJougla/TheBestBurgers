package dataAccess;

import javax.persistence.NoResultException;

import beans.BurgerBean;
import business.Burger;

public class JpaBurger implements Dao<BurgerBean> {

    public BurgerBean findById(long id) {
        return findById(id, "Burger", BurgerBean.class);
    }
    
    public Burger findByName(String name) {
        try {
            return new Burger (entityManagerExecutor.execute(em -> em.createQuery("select b from Burger b where b.name='" + name + "'", BurgerBean.class).getSingleResult()));
        } catch (final NoResultException e) {
            return null;
        }
    }
}
