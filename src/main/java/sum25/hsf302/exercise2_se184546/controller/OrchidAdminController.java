package sum25.hsf302.exercise2_se184546.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.service.CategoryService;
import sum25.hsf302.exercise2_se184546.service.OrchidService;
import sum25.hsf302.exercise2_se184546.service.UploadService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class OrchidAdminController {
    @Autowired
    private OrchidService orchidService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UploadService uploadService;

    @GetMapping("/admin/orchids")
    public String showOrchidList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes) {

        Accounts account = (Accounts) session.getAttribute("loggedInUser");
        if (account == null || account.getRole().getRoleId() != 1) {
            redirectAttributes.addFlashAttribute("error", "Bạn không có quyền truy cập!");
            return "redirect:/login";
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by("orchidId").descending());
        Page<Orchids> orchidPage = orchidService.findAllOrchids(pageable); // ✅ truyền vào Pageable

        model.addAttribute("orchidPage", orchidPage);          // để hiển thị danh sách
        model.addAttribute("currentPage", page);               // số trang hiện tại
        model.addAttribute("totalPages", orchidPage.getTotalPages()); // tổng số trang

        return "admin_orchids";
    }

    // GET: Hiển thị form chỉnh sửa
    @GetMapping("/admin/orchids/edit/{id}")
    public String editOrchid(@PathVariable("id") int id, Model model) {
        Orchids orchid = orchidService.findById(id);
        if (orchid == null) {
            return "redirect:/admin_orchids";
        }
        model.addAttribute("orchid", orchid);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "admin_orchid_edit"; // tên file .html của form chỉnh sửa
    }

    @PostMapping("/admin/orchids/edit")
    public String updateOrchid(@ModelAttribute("orchid") Orchids orchid,
                               RedirectAttributes redirectAttributes) {
        Orchids updatedOrchid = orchidService.save(orchid);
        if (updatedOrchid != null) {
            redirectAttributes.addFlashAttribute("success", "Cập nhật hoa lan thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Cập nhật hoa lan thất bại!");
        }
        return "redirect:/admin/orchids";
    }

    @GetMapping("/admin/orchids/create")
    public String showCreateForm(Model model) {
        model.addAttribute("orchid", new Orchids());
        model.addAttribute("categories", categoryService.findAllCategories());
        return "admin_orchid_create"; // Tên file HTML ở mục trên
    }

    @PostMapping("/admin/orchids/create")
    public String saveOrchid(@ModelAttribute Orchids orchid,
                             @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

            // Lưu vào static/orchid
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/orchid";
            Path filePath = Paths.get(uploadDir, fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            orchid.setOrchidUrl("/orchid/" + fileName); // để hiển thị đúng trên web
        }

        orchidService.save(orchid);
        return "redirect:/admin/orchids";
    }


}
