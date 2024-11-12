package Practice.springboot.employe.dto;

import lombok.*;

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
