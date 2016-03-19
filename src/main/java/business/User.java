package business;

import com.google.common.base.Preconditions;

import dataAccess.JpaUser;
import dataAccess.UserBean;

public class User {

    private final UserBean userBean;
    private final JpaUser jpaUser;

    public User(UserBean bean, JpaUser jpa) {
        Preconditions.checkNotNull(bean, "UserBean");
        Preconditions.checkNotNull(jpa, "JpaUser");
        userBean = bean;
        jpaUser = jpa;
    }

    public User() {
        this(new UserBean(), new JpaUser());
    }

    public void setName(String name) {
        userBean.setName(name);
    }

    public String getName() {
        return userBean.getName();
    }

    public void save() {
        jpaUser.save(userBean);
    }

    public boolean exists() {
        return userBean.getId() > 0l;
    }

}
