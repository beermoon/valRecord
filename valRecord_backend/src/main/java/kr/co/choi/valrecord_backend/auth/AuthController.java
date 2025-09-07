package kr.co.choi.valrecord_backend.auth;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.nio.file.Files.setAttribute;

@RestController
public class AuthController {

    @PostMapping("/auth/login")
    public Map<String,Object> login(@RequestParam String email,
                                    @RequestParam String password,
                                    HttpSession session) {
        session.setAttribute("userId", email);
        session.setAttribute("puuid", "STUB_PUUID");
        return Map.of("ok",true);
    }

    @GetMapping("/auth/me")
    public Map<String,Object> me(HttpSession session) {
        return Map.of("userId",session.getAttribute("userId"),
                "puuid",session.getAttribute("puuid"));
    }


}
