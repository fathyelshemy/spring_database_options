package com.database.demo.demo.jpa.hibernate;

import com.database.demo.demo.Entities.Person;
import com.database.demo.demo.Entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserJPADao {

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(long id){
        return entityManager.find(User.class,id);
    }
    public List<User> findAllUsers(){
        TypedQuery findAllUsersQuery=entityManager.createNamedQuery("find_all_Users",User.class);

        return findAllUsersQuery.getResultList();
    }


    public void saveUser(User user){
        entityManager.merge(user);
    }
    public void deleteUserById(long id){
        User RemovedUser=findById(id);
        entityManager.remove(RemovedUser)  ;
    }

}
