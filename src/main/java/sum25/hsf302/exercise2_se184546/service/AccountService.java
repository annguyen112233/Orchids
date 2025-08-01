package sum25.hsf302.exercise2_se184546.service;

import sum25.hsf302.exercise2_se184546.DTO.AccountDTO;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    long countAccounts();

    Accounts save(Accounts account);

     void updateAccount(int id, String accountName, String password, String roleName);
    //dung dang nhap
    Optional<Accounts> findByEmailAndPassword(String email, String password);
    void createCustomerAccount(AccountDTO dto);
    boolean existsByEmail(String email);

    List<Accounts> findAllAccounts();

}
