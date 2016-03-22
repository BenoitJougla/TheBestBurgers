package dataAccess;

import beans.BurgerBean;

public class JpaBurger implements Dao<BurgerBean> {

    public BurgerBean findById(long id) {
        return findById(id, "Burger", BurgerBean.class);
    }
}
