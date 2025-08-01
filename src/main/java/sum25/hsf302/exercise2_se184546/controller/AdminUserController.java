package sum25.hsf302.exercise2_se184546.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.service.AccountService;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    private final AccountService accountService;

    public AdminUserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String showUserList(Model model) {
        List<Accounts> users = accountService.findAllAccounts();
        model.addAttribute("users", users);
        return "admin_users"; // thay đổi nếu file HTML bạn để ở nơi khác
    }

    @PostMapping("/update")
    public String updateAccount(@RequestParam("accountId") int id,
                                @RequestParam("accountName") String accountName,
                                @RequestParam("password") String password,
                                @RequestParam("roleName") String roleName,
                                RedirectAttributes redirectAttributes) {
        try {
            accountService.updateAccount(id, accountName, password, roleName);
            redirectAttributes.addFlashAttribute("successMessage", "Tài khoản đã được cập nhật thành công.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/admin/users"; // hoặc bất kỳ trang nào bạn dùng để hiển thị danh sách account
    }
}

