package sum25.hsf302.exercise2_se184546.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, RedirectAttributes redirectAttributes) {
        Accounts account = (Accounts) session.getAttribute("loggedInUser");

        if (account == null || account.getRole() .getRoleId()!= 1) {
            redirectAttributes.addFlashAttribute("error", "Bạn không có quyền truy cập!");
            return "redirect:/login";
        }

        return "admin_dashboard"; // Trả về trang quản trị
    }

}
