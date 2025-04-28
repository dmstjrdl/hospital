package hello.hospital.user.controller;

import hello.hospital.user.dto.LoginDTO;
import hello.hospital.user.dto.RegisterDTO;
import hello.hospital.user.dto.ResponseInfoUserDTO;
import hello.hospital.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getLoginId(), loginDTO.getPassword()));

            SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().createEmptyContext();
            securityContext.setAuthentication(authentication);
            SecurityContextHolder.getContextHolderStrategy().setContext(securityContext);
            securityContextRepository.saveContext(securityContext, request, response);
            return ResponseEntity.ok("로그인 성공");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseInfoUserDTO> register(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(userService.createUser(registerDTO));
    }
}
