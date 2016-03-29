package dataAccess;

import java.util.List;

import beans.BurgerBean;
import beans.IngredientBean;
import beans.RestaurantBean;
import beans.UserBean;
import business.Burger;
import business.Ingredient;
import business.Restaurant;

public class DAOManager {

    private static DAOManager _INSTANCE = null;
    private final JpaUser jpaUser;
    private final JpaBurger jpaBurger;
    private final JpaRestaurant jpaRestaurant;
    private final JpaIngredient jpaIngredient;

    private DAOManager() {
        jpaUser = new JpaUser();
        jpaBurger = new JpaBurger();
        jpaRestaurant = new JpaRestaurant();
        jpaIngredient = new JpaIngredient();
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
        final BurgerBean bean = jpaBurger.findById(id);
        if (bean != null) {
            return new Burger(bean);
        }

        return null;
    }

    public Burger getBurgerByName(String name) {
        return jpaBurger.findByName(name);
    }

    public void saveBurger(BurgerBean bean) {
        jpaBurger.save(bean);
    }
    
    public List<Burger> getAllBurgers(){
    	return jpaBurger.findAllBurgers();
    }

    // Restaurant
    public Restaurant getRestaurantById(long id) {
        final RestaurantBean bean = jpaRestaurant.findById(id);
        if (bean != null) {
            return new Restaurant(bean);
        }

        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return jpaRestaurant.findAllRestaurants();

    }

    public void saveRestaurant(RestaurantBean bean) {
        jpaRestaurant.save(bean);
    }

    // Ingredient
    public Ingredient getIngredientById(long id) {
        final IngredientBean bean = jpaIngredient.findById(id);
        if (bean != null) {
            return new Ingredient(bean);
        }
        return null;
    }

    public void saveIngredient(IngredientBean bean) {
        jpaIngredient.save(bean);
    }

    public List<Ingredient> getAllIngredients() {
        return jpaIngredient.findAllIngredients();
    }
}
