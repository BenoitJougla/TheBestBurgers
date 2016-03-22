package business;

import java.util.List;

import com.google.common.base.Preconditions;

import beans.BurgerBean;
import beans.RestaurantBean;
import dataAccess.DAOManager;

public class Restaurant {
    private final RestaurantBean restaurantBean;

    public Restaurant() {
        restaurantBean = new RestaurantBean();
    }

    public Restaurant(String name) {
        this();
        setName(name);
    }

    public Restaurant(RestaurantBean bean) {
        Preconditions.checkNotNull(bean, "RestaurantBean");
        restaurantBean = bean;
    }

    public void save() {
        DAOManager.getInstance().saveRestaurant(restaurantBean);
    }

    public List<BurgerBean> getBurgers() {
        return restaurantBean.getBurgers();
    }

    public void setBurgers(List<BurgerBean> burgers) {
        restaurantBean.setBurgers(burgers);
    }

    public String getName() {
        return restaurantBean.getName();
    }

    public void setName(String name) {
        restaurantBean.setName(name);
    }

    public double getLatitude() {
        return restaurantBean.getLatitude();
    }

    public void setLatitude(double latitude) {
        restaurantBean.setLatitude(latitude);
    }

    public double getLongitude() {
        return restaurantBean.getLongitude();
    }

    public void setLongitude(double longitude) {
        restaurantBean.setLongitude(longitude);
    }
}
