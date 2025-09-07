package kr.co.choi.valrecord_backend.match.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import kr.co.choi.valrecord_backend.match.dto.MatchDetailDto;
import kr.co.choi.valrecord_backend.match.dto.MatchSummaryDto;
import kr.co.choi.valrecord_backend.match.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService services;

    @GetMapping("/me/matches")
    public List<MatchSummaryDto> myMatches(HttpSession s , @RequestParam(defaultValue = "5") int size) {
        String puuid = (String) s.getAttribute("puuid");
        if (puuid == null) puuid = "STUB_PUUID";
        return services.recent(puuid,size);
    }


    public MatchDetailDto match(@PathVariable String id) {
        return services.one(id);
    }

}
