package sum25.hsf302.exercise2_se184546.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sum25.hsf302.exercise2_se184546.DTO.ChangePasswordDTO;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.service.AccountService;

@Controller
public class ProfileController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        Accounts account = (Accounts) session.getAttribute("loggedInUser"); // 👈 đúng tên

        if (account == null) {
            return "redirect:/login";
        }

        model.addAttribute("account", account);
        return "profile";
    }
    @GetMapping("/profile/edit")
    public String showEditProfile(Model model) {
        model.addAttribute("changePasswordDTO", new ChangePasswordDTO());
        return "edit-profile";
    }

    @PostMapping("/profile/edit")
    public String handleChangePassword(@ModelAttribute("changePasswordDTO") ChangePasswordDTO dto,
                                       Model model,
                                       HttpSession session) {
        Accounts account = (Accounts) session.getAttribute("loggedInUser"); // 👈 đúng
        if (account == null) {
            return "redirect:/login";
        }

        if (!dto.getCurrentPassword().equals(account.getPassword())) {
            model.addAttribute("error", "Mật khẩu hiện tại không đúng");
            return "edit-profile";
        }

        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            model.addAttribute("error", "Mật khẩu mới không khớp");
            return "edit-profile";
        }

        // Cập nhật mật khẩu
        account.setPassword(dto.getNewPassword());
        Accounts updatedAccount = accountService.save(account);

        // 🔁 Cập nhật lại account trong session
        session.setAttribute("loggedInUser", updatedAccount);

        model.addAttribute("success", "Cập nhật mật khẩu thành công");
        return "edit-profile";
    }


}
