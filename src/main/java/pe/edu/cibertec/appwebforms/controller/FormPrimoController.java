package pe.edu.cibertec.appwebforms.controller;

import com.sun.source.tree.ReturnTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appwebforms.Model.PrimoModel;

@Controller
public class FormPrimoController {
    @GetMapping("/numeroprimo")
    public String index(Model model){
        model.addAttribute("primomodel", new PrimoModel());
        model.addAttribute("verresultado", false);
        return "formPrimo";
    }
@PostMapping("/numeroprimo")
    public String validarNumeroPrimo(@ModelAttribute("primomodel")PrimoModel primoModel, Model model){

        String resultado = esPrimo(primoModel.getNumero())
                ? "El número" + primoModel.getNumero()
                + " es PRIMO"
                : "El número " + primoModel.getNumero()
                + " NO ES PRIMO";

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", resultado);
        return "formPrimo";
    }
    private Boolean esPrimo(Integer numero){
        Integer contador = 1;
        for(int i = 1; i <= numero; i++){
            if((numero % i) == 0){
                contador++;
            }
        }
        return contador <=2;
    }
}
