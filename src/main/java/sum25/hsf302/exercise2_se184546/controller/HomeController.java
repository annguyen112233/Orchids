package sum25.hsf302.exercise2_se184546.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.service.OrchidService;

@Controller
public class HomeController {
    @Autowired
    private OrchidService orchidService;

    @GetMapping({"/", "/home"})
    public String home(
            HttpSession session,
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Accounts accounts = (Accounts) session.getAttribute("loggedInUser"); // có thể null

        Pageable pageable = PageRequest.of(page, size);
        Page<Orchids> orchidPage = orchidService.findAllOrchids(pageable);

        model.addAttribute("accounts", accounts); // truyền vào, thymeleaf có thể dùng để hiển thị nút đăng nhập/đăng ký/mua hàng
        model.addAttribute("orchids", orchidPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", orchidPage.getTotalPages());

        return "home"; // trang này hiển thị hoa lan
    }

}
