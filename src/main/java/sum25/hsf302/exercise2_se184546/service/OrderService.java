package sum25.hsf302.exercise2_se184546.service;


import sum25.hsf302.exercise2_se184546.DTO.OrderDTO;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orders;

import java.util.List;

public interface OrderService {
    Orders save(Orders order);

    List<Orders> findByAccountIdOrderByOrderDateDesc(Accounts account);

    List<OrderDTO> getAllOrdersAsDTO(); // mới thêm

void updateStatus(int orderId, OrderStatus status);



}
