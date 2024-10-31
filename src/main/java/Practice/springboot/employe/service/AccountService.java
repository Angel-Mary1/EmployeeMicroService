package Practice.springboot.employe.service;

import Practice.springboot.employe.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    public List<Account> getAllAccountDetail();

    public Account addAccountDetail( Account account);
}
