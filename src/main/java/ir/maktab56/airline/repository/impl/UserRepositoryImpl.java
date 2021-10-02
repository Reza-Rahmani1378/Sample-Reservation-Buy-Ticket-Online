package ir.maktab56.airline.repository.impl;

import ir.maktab56.airline.base.repository.impl.BaseRepositoryImpl;
import ir.maktab56.airline.domain.User;
import ir.maktab56.airline.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }


    @Override
    public User existByUsername(String username) {
        TypedQuery<User> user_name = entityManager.createQuery(
                "select u from User u where u.username = :username",
                User.class
        ).setParameter("username", username);
        try {
            return user_name.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
