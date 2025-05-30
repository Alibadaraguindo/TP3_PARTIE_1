package net.ali.tp3_partie1.web;


import lombok.AllArgsConstructor;
import net.ali.tp3_partie1.entities.Patient;
import net.ali.tp3_partie1.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index (Model model,
                         @RequestParam(name="page", defaultValue = "0") int page,
                         @RequestParam(name="size", defaultValue = "4") int size,
                         @RequestParam(name="keyword", defaultValue = "") String keyword) {

        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listpatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";

    }
    @GetMapping("/delete")
    public String delete(Long id , String keyword , int page) {
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page+"&keyword=" + keyword;
    }
}
