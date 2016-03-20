package dataAccess;

import javax.persistence.NoResultException;

public class JpaUser implements Dao<UserBean> {

    private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

    @Override
    public UserBean findById(long id) {
        return entityManagerExecutor.execute(em -> em.createQuery("select u from User u where u.id='" + id + "'", UserBean.class).getSingleResult());
    }

    public UserBean findByName(String name) {
        try {
            return entityManagerExecutor.execute(em -> em.createQuery("select u from User u where u.name='" + name + "'", UserBean.class).getSingleResult());
        } catch (final NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(UserBean bean) {
        if (bean.getId() > 0) {
            entityManagerExecutor.update(bean);
        } else {
            try {
                entityManagerExecutor.insert(bean);
            } catch (final RuntimeException e) {
                // On repasse l'id à zero sinon on ne pourra pas enregistrer la
                // valeur
                bean.setId(0);
                throw e;
            }
        }
    }

}