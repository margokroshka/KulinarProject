package com.tms.kulinar.repository;

import com.tms.kulinar.domain.Feedback;
import com.tms.kulinar.domain.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class UsersRepository {
    public SessionFactory sessionFactory;

    public UsersRepository() {
        sessionFactory=new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<Users> getAllUsers(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Users ");
        ArrayList<Users> list= (ArrayList<Users>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public Users getUserById(int id){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Users user=session.get(Users.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }
    public void createUser(Users user){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
    public void updateUser(Users user){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();

    }
    public void deleteUser(Users user){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
