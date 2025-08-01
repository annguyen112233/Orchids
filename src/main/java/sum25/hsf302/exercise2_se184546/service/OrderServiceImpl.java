package sum25.hsf302.exercise2_se184546.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.hsf302.exercise2_se184546.DTO.OrderDTO;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orders;
import sum25.hsf302.exercise2_se184546.repository.OrderRepository;

import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Orders save(Orders order) {
        return orderRepository.save(order);

    }

    @Override
    public List<Orders> findByAccountIdOrderByOrderDateDesc(Accounts accounts) {
        return orderRepository.findByAccountIdOrderByOrderDateDesc(accounts);
    }

    @Override
    public List<OrderDTO> getAllOrdersAsDTO() {
        List<Orders> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderDTO::new)  // giả sử bạn có constructor OrderDTO(Orders o)
                .toList();
    }

    @Override
    public void updateStatus(int orderId, OrderStatus status) {
        Orders existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setOrderStatus(status);
        orderRepository.save(existingOrder);
    }


}
