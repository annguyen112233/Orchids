package sum25.hsf302.exercise2_se184546.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.hsf302.exercise2_se184546.DTO.AccountDTO;
import sum25.hsf302.exercise2_se184546.file_enum.RoleType;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Roles;
import sum25.hsf302.exercise2_se184546.repository.AccountRepository;
import sum25.hsf302.exercise2_se184546.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepo;
    @Override
    public long countAccounts() {
        return accountRepository.count();
    }

    @Override
    public Accounts save(Accounts account) {
        return accountRepository.save(account);
    }

    @Override
    public void updateAccount(int id, String accountName, String password, String roleName) {
        Accounts account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

        account.setAccountName(accountName);

        if (password != null && !password.isBlank()) {
            account.setPassword(password); // mã hóa nếu cần
        }

        try {
            RoleType roleEnum = RoleType.valueOf(roleName.toUpperCase());

            Roles role = roleRepo.findByRoleName(roleEnum)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));

            account.setRole(role);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role name: " + roleName);
        }

        accountRepository.save(account);
    }


    @Override
    public Optional<Accounts> findByEmailAndPassword(String email, String password) {
        return accountRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void createCustomerAccount(AccountDTO dto) {
        Roles customerRole = roleRepo.findByRoleName(RoleType.CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Role CUSTOMER not found"));

        Accounts account = new Accounts();
        account.setAccountName(dto.getAccountName());
        account.setEmail(dto.getEmail());
        account.setPassword(dto.getPassword());
        account.setRole(customerRole); // Gán role từ DB

        accountRepository.save(account);
    }
    @Override
    public boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public List<Accounts> findAllAccounts() {
        return accountRepository.findAll();
    }


}
