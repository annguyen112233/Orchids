package sum25.hsf302.exercise2_se184546.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sum25.hsf302.exercise2_se184546.DTO.OrderDTO;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;
import sum25.hsf302.exercise2_se184546.pojo.Orders;
import sum25.hsf302.exercise2_se184546.service.OrderService;

import java.util.List;

@Controller
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/admin/orders")
    public String viewAllOrders(Model model) {
        List<OrderDTO> orders = orderService.getAllOrdersAsDTO();
        model.addAttribute("orders", orders);
        return "orders-admin";
    }

    @PostMapping("/admin/orders/update-status/{orderId}")
    public String updateOrderStatus(@PathVariable int orderId,
                                    @RequestParam("status") String status) {
        orderService.updateStatus(orderId, OrderStatus.valueOf(status));
        return "redirect:/admin/orders"; // về lại trang danh sách đơn hàng
    }


}
