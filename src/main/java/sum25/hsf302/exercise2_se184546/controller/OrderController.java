package sum25.hsf302.exercise2_se184546.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sum25.hsf302.exercise2_se184546.DTO.OrderDTO;
import sum25.hsf302.exercise2_se184546.DTO.OrderForm;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.pojo.Order_Details;
import sum25.hsf302.exercise2_se184546.pojo.Orders;
import sum25.hsf302.exercise2_se184546.repository.OrderRepository;
import sum25.hsf302.exercise2_se184546.service.OrchidService;
import sum25.hsf302.exercise2_se184546.service.OrderDetailsService;
import sum25.hsf302.exercise2_se184546.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrchidService orchidService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/order")
    public String showOrderForm(@RequestParam("orchidId") int orchidId, Model model) {
        Orchids orchid = orchidService.findById(orchidId);
        if (orchid == null) return "redirect:/home";

        OrderForm form = new OrderForm();
        form.setOrchidId(orchidId); // gán orchidId vào form

        model.addAttribute("orchid", orchid);
        model.addAttribute("orderForm", form);

        return "order-form";
    }

    @PostMapping("/order")
    public String submitOrder(@ModelAttribute("orderForm") OrderForm form,
                              HttpSession session, Model model) {
        Accounts user = (Accounts) session.getAttribute("loggedInUser");

        if (user == null) return "redirect:/login";

        Orchids orchid = orchidService.findById(form.getOrchidId());
        if (orchid == null) return "redirect:/home";

        double total = orchid.getPrice() * form.getQuantity();

        Orders order = new Orders();
        order.setAccountId(user);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setTotalAmount(String.valueOf(total));

        Orders savedOrder = orderService.save(order);

        Order_Details details = new Order_Details();
        details.setOrderId(savedOrder);
        details.setOrchidId(orchid);
        details.setQuantity(form.getQuantity());
        details.setPrice(orchid.getPrice());

        orderDetailsService.save(details);

        model.addAttribute("message", "Đặt hàng thành công!");
        return "order-success";
    }

    @GetMapping("/my-orders")
    public String viewMyOrders(HttpSession session, Model model) {
        Accounts user = (Accounts) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        List<Orders> orders = orderService.findByAccountIdOrderByOrderDateDesc(user);
        List<OrderDTO> dtos = orders.stream().map(OrderDTO::new).toList();
        model.addAttribute("orders", dtos);
        return "profile-orders";
    }
}

