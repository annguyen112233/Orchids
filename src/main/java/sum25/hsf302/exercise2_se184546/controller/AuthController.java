package sum25.hsf302.exercise2_se184546.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.hsf302.exercise2_se184546.DTO.AccountDTO;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.service.AccountService;

import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        Optional<Accounts> userOpt = accountService.findByEmailAndPassword(email, password);

        if (userOpt.isPresent()) {
            Accounts account = userOpt.get();
            session.setAttribute("loggedInUser", account);

            // ✅ Nếu là Admin, chuyển về trang quản trị
            if (account.getRole().getRoleId() == 1) {
                return "redirect:/admin/dashboard";
            }

            // ✅ Nếu là người dùng thường, chuyển về trang người dùng
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu sai");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("accountDTO", new AccountDTO());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("accountDTO") AccountDTO dto, Model model) {
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            model.addAttribute("error", "Mật khẩu không khớp");
            return "register";
        }

        boolean exists = accountService.existsByEmail(dto.getEmail());
        if (exists) {
            model.addAttribute("error", "Email đã tồn tại");
            return "register";
        }

        accountService.createCustomerAccount(dto);
        return "redirect:/login?registerSuccess=true";
    }

    //===============Admin=========================

}


