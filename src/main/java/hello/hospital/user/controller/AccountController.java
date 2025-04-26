package hello.hospital.user.controller;

import hello.hospital.user.dto.LoginDTO;
import hello.hospital.user.dto.RegisterDTO;
import hello.hospital.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "account/login";
    }

    @PostMapping("/login")
    public String login(@Validated @RequestBody LoginDTO loginDTO, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "account/login";
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getLoginId(), loginDTO.getPassword()));
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().createEmptyContext();
        securityContext.setAuthentication(authentication);

        SecurityContextHolder.getContextHolderStrategy().setContext(securityContext);
        securityContextRepository.saveContext(securityContext, request, response);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "account/register";
    }

    @PostMapping("/register")
    public String register(@Validated @RequestBody RegisterDTO registerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "account/register";
        }

        userService.createUser(registerDTO);
        return "redirect:/account/login";
    }
}
