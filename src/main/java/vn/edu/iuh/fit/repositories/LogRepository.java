package vn.edu.iuh.fit.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.models.Log;

import java.sql.Date;
import java.util.List;

@Stateless
public class LogRepository {
    private EntityManager em;

    public LogRepository() {
        em = Persistence.createEntityManagerFactory("week1").createEntityManager();
    }

    public List<Log> findAll() {
        TypedQuery<Log> query = em.createQuery("select l from Log l", Log.class);
        return query.getResultList();
    }

    public List<Log> findLogByUser(long account_id) {
        TypedQuery<Log> query = em.createQuery("select l from Log l where l.account_id=?1", Log.class);
        query.setParameter(1,account_id);
        return query.getResultList();
    }

    public List<Log> findLogInTime(Date begin, Date end) {
        TypedQuery<Log> query = em.createQuery("select l from Log l where l.login_time>=?1 and l.logout_time<=?2", Log.class);
        query.setParameter(1, begin);
        query.setParameter(2,end);
        return query.getResultList();
    }

    public void insert(Log log) {
        em.persist(log);
    }

    public void update(Log log) {
        em.merge(log);
    }
}
