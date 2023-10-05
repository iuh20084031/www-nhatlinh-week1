package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Log;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.LogRepository;

import java.sql.Date;
import java.util.Optional;

public class LogServices {
    @Inject
    private LogRepository logRepository;
    @Inject
    private AccountRepository accountRepository;

    // Thêm sửa Log
    private void insertLog(Log log) {
        logRepository.insert(log);
    }

    private void updateLog(Log log) {
        logRepository.insert(log);
    }

    // Lưu log đăng nhập
    private long saveLogLogon(long acount_id) {
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);
        Log log = new Log(acount_id, currentDate, null, "no note");
        logRepository.insert(log);
        return log.getLog_id();
    }

    // Lưu log đăng xuất
    private long saveLogLogout(long account_id, long log_id) {
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);
        Log logInUse = logRepository.findLog(log_id);
        Log log = new Log(account_id, logInUse.getLogin_time(), currentDate, "no note");
        logRepository.update(log);
        return log.getLog_id();
    }
}
