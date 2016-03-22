package dataAccess;

import javax.persistence.NoResultException;

import beans.UserBean;

public class JpaUser implements Dao<UserBean> {

    public UserBean findById(long id) {
       return findById(id, "User", UserBean.class);
    }

    public UserBean findByName(String name) {
        try {
            return entityManagerExecutor.execute(em -> em.createQuery("select u from User u where u.name='" + name + "'", UserBean.class).getSingleResult());
        } catch (final NoResultException e) {
            return null;
        }
    }
}