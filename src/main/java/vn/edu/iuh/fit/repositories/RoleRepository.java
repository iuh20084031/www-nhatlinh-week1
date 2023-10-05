package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.models.Role;

import java.util.List;

public class RoleRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public RoleRepository() {
        em = Persistence.createEntityManagerFactory("week1").createEntityManager();
        trans = em.getTransaction();
    }

    public void insert(Role role) {
        try {
            trans.begin();
            em.persist(role);
            //when insert new role, autoatically grant access to all account with false
            AccountRepository accountRepository = new AccountRepository();
            GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
            List<Account> accounts = accountRepository.getAllAccounts();
            accounts.forEach(account -> {
                GrantAccess grantAccess = new GrantAccess(account.getAccount_id(), role.getRole_id(), false, "initialize");
                grantAccessRepository.insert(grantAccess);
            });
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public void update(Role role) {
        try {
            trans.begin();
            em.merge(role);
            trans.commit();
        } catch (Exception exception) {
            trans.rollback();
        }
    }

    public boolean updateStatus(long role_id, int status) {
        try {
            trans.begin();
            Account acc = em.find(Account.class, role_id);
            if (acc != null)
                acc.setStatus(status);
            trans.commit();
            return true;
        } catch (Exception exception) {
            trans.rollback();
        }
        return false;
    }

    public List<Role> getAllRoles() {
        TypedQuery<Role> q = em.createQuery("select r from Role r", Role.class);
        return q.getResultList();
    }
}
