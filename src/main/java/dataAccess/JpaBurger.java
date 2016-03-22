package dataAccess;

public class JpaBurger implements Dao<BurgerBean> {

    private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

    @Override
    public BurgerBean findById(long id) {
        return entityManagerExecutor.execute(em -> em.createQuery("select b from Burger b where b.id='" + id + "'", BurgerBean.class).getSingleResult());
    }

    @Override
    public void save(BurgerBean bean) {
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
