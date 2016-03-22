package dataAccess;

import beans.BurgerBean;
import beans.UserBean;
import business.Burger;

public class DAOManager {

    private static DAOManager _INSTANCE = null;
    private final JpaUser jpaUser;
    private final JpaBurger jpaBurger;

    private DAOManager() {
        jpaUser = new JpaUser();
        jpaBurger = new JpaBurger();
    }

    public static DAOManager getInstance() {
        if (_INSTANCE == null) {
            synchronized (DAOManager.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new DAOManager();
                }
            }
        }
        return _INSTANCE;
    }

    // User
    public UserBean getUserByName(String name) {
        return jpaUser.findByName(name);
    }

    public UserBean getUserById(long id) {
        return jpaUser.findById(id);
    }

    public void saveUser(UserBean bean) {
        jpaUser.save(bean);
    }
    
    // Burger
    public Burger getBurgerById(long id) {
    	BurgerBean bean = jpaBurger.findById(id);
    	if(bean != null){
    		return new Burger(bean);
    	}
    	
    	return null;
    }
    
    public void saveBurger(BurgerBean bean) {
    	jpaBurger.save(bean);
    }
}
