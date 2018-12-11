/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.User;
import util.rsHibernateUtil;

/**
 *
 * @author MR98X
 */
public class UserHelper {

    public List<User> getUser() {
        Session session = rsHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<User> hasil = null;
        Query q = session.createQuery("from User u");
        hasil = q.list();
        tx.commit();
        session.close();
        return hasil;
    }

    public User login(String email, String password) {
        Session session = rsHibernateUtil.getSessionFactory().openSession();
        String q = "From User a where a.email=:email AND a.password =:password";
        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (User) query.uniqueResult();
    }
}
