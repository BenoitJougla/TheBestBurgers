package dataAccess;

import javax.persistence.NoResultException;

import beans.Bean;

public interface Dao<T extends Bean> {

	 final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();
	 
    /**
     * Trouve l'objet par son id
     *
     * @param id
     * @return ne retourne jamais null, doit renvoyer une exception à la place
     */
    default T findById(long id, String entityName, Class<T> entityClass) {
    	try {
    		return entityManagerExecutor.execute(em -> em.createQuery("select u from " + entityName + " u where u.id='" + id + "'", entityClass).getSingleResult());
    	} catch(NoResultException e) {
    		return null;
    	}
    }

    /**
     * Sauvegarde le bean
     *
     * @param bean
     */
    default void save(T bean) {
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
