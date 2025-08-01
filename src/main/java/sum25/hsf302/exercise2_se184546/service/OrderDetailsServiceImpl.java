package sum25.hsf302.exercise2_se184546.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.hsf302.exercise2_se184546.pojo.Order_Details;
import sum25.hsf302.exercise2_se184546.repository.OrderDetailsRepository;

@Service

public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Override
    public Order_Details save(Order_Details order_details) {
        return orderDetailsRepository.save(order_details);
    }
}
