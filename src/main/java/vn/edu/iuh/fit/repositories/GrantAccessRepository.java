package vn.edu.iuh.fit.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.enums.GrantValue;
import vn.edu.iuh.fit.models.GrantAccess;

public class GrantAccessRepository {
    private EntityManager em;
    private EntityTransaction trans;

    @Inject
    private AccountRepository accountRepository;
    @Inject
    private RoleRepository roleRepository;

    public GrantAccessRepository() {
        em = Persistence.createEntityManagerFactory("week1").createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(GrantAccess grantAccess) {
        try {
            trans.begin();
            em.persist(grantAccess);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public void update(long account_id, long role_id, boolean allowed) {
        try {
            trans.begin();
            GrantAccess grantAccess = new GrantAccess(account_id, role_id, allowed,allowed?"enable":"disable");
            em.merge(grantAccess);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }
}
