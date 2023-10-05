package vn.edu.iuh.fit.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.enums.GrantValue;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.models.Role;

import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private EntityManager em;
    private EntityTransaction trans;

    @Inject
    private RoleRepository roleRepository;
    @Inject
    private GrantAccessRepository grantAccessRepository;

    public AccountRepository() {
        em = Persistence.createEntityManagerFactory("week1").createEntityManager();
        trans = em.getTransaction();
    }

    public void insert(Account account) {
        try {
            trans.begin();
            em.persist(account);
            //when create an account, grant it to all role with false
            List<Role> roles = roleRepository.getAllRoles();
            roles.forEach(role -> {
                GrantAccess grantAccess = new GrantAccess(account.getAccount_id(), role.getRole_id(), false, "initialize");
                grantAccessRepository.insert(grantAccess);
            });
            trans.commit();
        } catch (Exception exception) {
            trans.rollback();
        }
    }

    public void update(Account account) {
        try {
            trans.begin();
            em.merge(account);
            trans.commit();
        } catch (Exception exception) {
            trans.rollback();
        }
    }

    public  boolean updateStatus(long account_id, int status) {
        try {
            trans.begin();
            Account account = em.find(Account.class, account_id);
            if(account!= null) {
                account.setStatus(status);
            }
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Account> checkAccountLogon(long account_id, String password) {
        Account account = em.find(Account.class, account_id);
        if(account.getPassword().equals(password))
            return Optional.of(account);
        return Optional.empty();
    }

    public List<Account> getAllAccounts() {
        TypedQuery<Account> q = em.createQuery("select a from Account a", Account.class);
        return q.getResultList();
    }
}
