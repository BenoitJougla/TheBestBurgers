package dataAccess;

public interface Dao<T> {

    /**
     * Trouve l'objet par son id
     *
     * @param id
     * @return ne retourne jamais null, doit renvoyer une exception à la place
     */
    T findById(long id);

    /**
     * Sauvegarde le bean
     *
     * @param bean
     */
    void save(T bean);
}
