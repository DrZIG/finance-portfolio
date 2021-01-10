package drzig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dr.ZIG
 */
@Controller
@RequestMapping("/finances")
public class FinancesController {

    @GetMapping()
    public String index(Model model) {
        return shares(model);
    }

    @GetMapping("/portfolio")
    public String portfolio() {
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

    @GetMapping("users")
    public String users(Model model) {
        return "objects/users";
    }
}
