package business;

import com.google.common.base.Preconditions;

import beans.UserBean;
import dataAccess.DAOManager;

public class User {

    private final UserBean userBean;

    public static User getUserByName(String name) {
        final UserBean bean = DAOManager.getInstance().getUserByName(name);

        if (bean != null) {
            return new User(bean);
        }

        return null;
    }

    public User(UserBean bean) {
        Preconditions.checkNotNull(bean, "UserBean");
        userBean = bean;
    }

    public User(String name) {
        userBean = new UserBean();
        setName(name);
    }

    public void setName(String name) {
        userBean.setName(name);
    }

    public String getName() {
        return userBean.getName();
    }

    public void save() {
        DAOManager.getInstance().saveUser(userBean);
    }

    public boolean exists() {
        return userBean.getId() > 0l;
    }

    public UserBean getBean() {
        return userBean;
    }

    public void addGrade(Grade grade) {
        userBean.addGrade(grade.getBean());
    }

    public void removeGrade(Grade grade) {
        userBean.removeGrade(grade.getBean());
    }
}
