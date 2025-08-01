package sum25.hsf302.exercise2_se184546.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
