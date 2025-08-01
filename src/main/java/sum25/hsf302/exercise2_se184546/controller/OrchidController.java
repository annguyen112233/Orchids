package sum25.hsf302.exercise2_se184546.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.service.OrchidService;

@Controller
@RequestMapping("/orchid")
public class OrchidController {

    @Autowired
    private OrchidService orchidService;

    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        Orchids orchid = orchidService.findById(id);
        if (orchid == null) {
            return "redirect:/home";
        }
        model.addAttribute("orchid", orchid);
        return "orchid-detail"; // thymeleaf sẽ tìm templates/orchid-detail.html
    }
}

