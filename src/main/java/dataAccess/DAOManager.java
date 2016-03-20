package dataAccess;

public class DAOManager {

    private static DAOManager _INSTANCE = null;
    private final JpaUser jpaUser;

    private DAOManager() {
        jpaUser = new JpaUser();
    }

    public static DAOManager getInstance() {
        if (_INSTANCE == null) {
            synchronized (DAOManager.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new DAOManager();
                }
            }
        }
        return _INSTANCE;
    }

    // User
    public UserBean getUserByName(String name) {
        return jpaUser.findByName(name);
    }

    public UserBean getUserById(long id) {
        return jpaUser.findById(id);
    }

    public void saveUser(UserBean bean) {
        jpaUser.save(bean);
    }

}
