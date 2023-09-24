package pe.edu.cibertec.appwebforms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appwebforms.Model.PromedioModel;

@Controller
public class FormSumaController {
    @GetMapping("/promedionotas")
    public String index(Model model){
        model.addAttribute("verresultado", false);
        model.addAttribute("promediomodel", new PromedioModel());
        return "formSuma";
    }

    @PostMapping("/promedionotas")
    public String calcularPromedioNotas(@ModelAttribute("promediomodel") PromedioModel promedioModel, Model model) {
        Double promedio = (promedioModel.getCl1() * 0.15) +
                (promedioModel.getCl2() * 0.2) +
                (promedioModel.getCl3() * 0.35) +
                (promedioModel.getProyfin() * 0.3);
        String estado = promedio > 10.49 ? "Aprobado" : "Desaprobado";

        model.addAttribute("resultado", "Su promedio de nota es: " + promedio +
                ", usted se encuenta: " + estado);

        model.addAttribute("verresultado", true);

        model.addAttribute(new PromedioModel());
        return "formSuma";
    }
}