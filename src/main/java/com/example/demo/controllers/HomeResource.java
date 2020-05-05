package com.example.demo.controllers;

import com.example.demo.models.Currency;
import com.example.demo.models.CurrencyCode;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeResource
{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/loggedIn")
    public String user(Model model)
    {
        model.addAttribute("currencyCode", new CurrencyCode());
        return "currencyExchange";
    }

    @GetMapping("/check")
    public String checkCurrency(Model model, CurrencyCode currencyCode)
    {
        Currency currency = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/a/" +
                currencyCode.getCode(), Currency.class);

        model.addAttribute("currency", currency);
        return "currencyRate";
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registered")
    public String registered(User user)
    {
        int id = 1;
        User addUser = new User();
        addUser.setId(++id);
        addUser.setUserName(user.getUserName());
        addUser.setPassword(user.getPassword());
        addUser.setRoles("ROLE_USER");
        userRepository.save(addUser);
        return "successfullyRegistered";
    }
}
