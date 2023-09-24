package pe.edu.cibertec.appwebforms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appwebforms.Model.Imcmodel;

@Controller
public class FormimoController {
    @GetMapping("/calcularimc")
    public String index(Model model){
        model.addAttribute("imcmodel", new Imcmodel());
        model.addAttribute("verresultado", false);
        return "formImc";
    }

    @PostMapping("/calcularimc")
public String calcularim(@ModelAttribute("imcmodel") Imcmodel imcmodel, Model model){

        Double tallam = imcmodel.getAltura() / 100;
        Double valorimc = imcmodel.getPeso() / (tallam * tallam);
        String resultadoimc = "";
        String coloralert = "alert-danger";

        if(valorimc <= 18.5){
            resultadoimc = "Por debajo del peso";
            coloralert = "alert-dark";
        }else if(valorimc <= 25){
            resultadoimc = "Con peso normal";
            coloralert = "alert-primary";
        }else if(valorimc <= 30){
            resultadoimc = "Con sobrepeso";
            coloralert = "alert-warning";
        }else if(valorimc <= 35){
            resultadoimc = "Con obesidad leve";
        }else if(valorimc <= 39){
            resultadoimc = "Con obesidad media";
        }else{
            resultadoimc = "Con obesidad mórbida";
        }
        model.addAttribute("verresultado", true);
        model.addAttribute("resultado",
                "Su valor de IMC es:" + String.format("%.2f", valorimc)
        + ", usted se encuentra: " + resultadoimc);
        model.addAttribute("coloralert", coloralert);
        return "formimc";
}
}
