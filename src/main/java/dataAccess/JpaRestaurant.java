package dataAccess;

import beans.RestaurantBean;

public class JpaRestaurant implements Dao<RestaurantBean> {

    public RestaurantBean findById(long id) {
        return findById(id, "Restaurant", RestaurantBean.class);
    }
}
