package Practice.springboot.employe.controller;

import Practice.springboot.employe.entity.Account;
import Practice.springboot.employe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/account/student")
public class AccountController {

    private  final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Account>> getAllAccountDetail()
    {
        return new ResponseEntity<>(accountService.getAllAccountDetail(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Account> addAccount(@RequestBody Account account)
    {
        return new ResponseEntity<>(accountService.addAccountDetail(account),HttpStatus.OK);
    }


}
