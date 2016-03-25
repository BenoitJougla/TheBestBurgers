package dataAccess;

import java.util.ArrayList;
import java.util.List;

import beans.RestaurantBean;
import business.Restaurant;

public class JpaRestaurant implements Dao<RestaurantBean> {

    public RestaurantBean findById(long id) {
        return findById(id, "Restaurant", RestaurantBean.class);
    }
    
    public List<Restaurant> findAllRestaurants(){
    	List<RestaurantBean> listBean = entityManagerExecutor.execute(em -> em.createQuery("select r from Restaurant r", RestaurantBean.class).getResultList());
    	List<Restaurant> restaurantList = new ArrayList<Restaurant>();
    	for(RestaurantBean r : listBean){
    		restaurantList.add(new Restaurant(r));
    	}
    	
    	return restaurantList;
    }
}
