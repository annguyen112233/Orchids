package sum25.hsf302.exercise2_se184546.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orders;

import java.util.List;

@Repository

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByAccountId(Accounts accountId);

    List<Orders> findByAccountIdOrderByOrderDateDesc(Accounts account);

}
