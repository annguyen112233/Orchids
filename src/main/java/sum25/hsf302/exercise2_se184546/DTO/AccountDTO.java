package sum25.hsf302.exercise2_se184546.DTO;

import lombok.Data;

@Data
public class AccountDTO {
    private String accountName;
    private String email;
    private String password;
    private String confirmPassword;
}

