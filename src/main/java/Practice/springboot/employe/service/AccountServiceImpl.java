package Practice.springboot.employe.service;

import Practice.springboot.employe.entity.Account;
import Practice.springboot.employe.repository.AccountRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AccountServiceImpl implements AccountService {



    private AccountRepositry accountRepositry;

    public AccountServiceImpl(AccountRepositry accountRepositry) {
        this.accountRepositry=accountRepositry;
    }


    @Override
    public List<Account> getAllAccountDetail() {
        return accountRepositry.findAll();
    }

    @Override
    public Account addAccountDetail(Account account) {
        accountRepositry.save(account);
        return account;
    }
}
