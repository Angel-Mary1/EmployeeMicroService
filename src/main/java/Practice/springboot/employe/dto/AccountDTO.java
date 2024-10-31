package Practice.springboot.employe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO
{
    private Long id;
    private Long accountNumber;
    private String accounHolder;
    private Integer balance;

}
