package Practice.springboot.employe.repository;

import Practice.springboot.employe.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositry extends JpaRepository<Account, Long> {
}
