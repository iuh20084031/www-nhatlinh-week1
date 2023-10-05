package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.Optional;

public class AccountServices {
    @Inject
    private AccountRepository accountRepository;

    // Thêm xóa sửa Account
    public void insertAccount(Account account) {
        accountRepository.insert(account);
    }

    public void updateAccount(Account account) {
        accountRepository.update(account);
    }

    public void deleteAccount(long account_id) {
        accountRepository.updateStatus(account_id,-1);
    }

    // kiểm tra đăng nhập
    public Optional<Account>  checkLogon(long account_id, String password) {
        return accountRepository.checkAccountLogon(account_id,password);
    }

}
