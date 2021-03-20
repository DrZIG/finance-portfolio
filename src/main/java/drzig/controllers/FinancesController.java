package drzig.controllers;

import drzig.dao.UserDAO;
import drzig.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Dr.ZIG
 */
@Controller
@RequestMapping("/finances")
public class FinancesController {
    private final UserDAO userDAO;

    public FinancesController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        return portfolio(model);
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        return "portfolio";
    }

    @GetMapping("/operations")
    public String operations(Model model) {
        return "processes/operations";
    }

    @GetMapping("/companies")
    public String companies(Model model) {
        return "objects/companies";
    }

    @GetMapping("/tickers")
    public String tickers(Model model) {
        return "objects/tickers";
    }

    @GetMapping("/bonds")
    public String bonds(Model model) {
        return "objects/bonds";
    }

    @GetMapping("/currencies")
    public String currencies(Model model) {
        return "objects/currencies";
    }

    @GetMapping("/etfs")
    public String etfs(Model model) {
        return "objects/etfs";
    }

    @GetMapping("/shares")
    public String shares(Model model) {
        return "objects/shares";
    }

    @GetMapping("/stocks")
    public String stocks(Model model) {
        return "objects/stocks";
    }

//    @GetMapping("/users")
//    public String users(Model model) {
//        return "objects/users";
//    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "control/sign_up";
    }

    @PostMapping("/users/new")
    public String sighUp(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "control/sign_up";

        userDAO.add(user);
        return "redirect:/finances/portfolio";
    }
}
