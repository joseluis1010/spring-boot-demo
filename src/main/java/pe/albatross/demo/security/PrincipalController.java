package pe.albatross.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pe.albatross.demo.dao.RazaDAO;
import pe.albatross.demo.model.Persona;

@Controller
public class PrincipalController {

    @Autowired
    RazaDAO razaDAO;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("titulo", "Bienvenido a la APP");
        return "security/index";
    }

    @RequestMapping("bienvenidaDos")
    public ModelAndView bienvenidaDos() {

        ModelAndView mv = new ModelAndView("security/index");
        mv.addObject("titulo", "Bienvenido a la APP");
        return mv;
    }

    @RequestMapping("save")
    public String save(String nombre, String apellido, Model model) {

        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        return "security/datos";
    }

    @RequestMapping("saveDos")
    public String saveDos(Persona persona, Model model) {

        model.addAttribute("persona", persona);
        return "security/datos";
    }

    @ResponseBody
    @RequestMapping("response-body")
    public String responseBody() {

        return "Hola mundo!";
    }

    @RequestMapping("razas")
    public String razas(Model model) {

        model.addAttribute("razas", razaDAO.findAll());

        return "security/raza";
    }

}
