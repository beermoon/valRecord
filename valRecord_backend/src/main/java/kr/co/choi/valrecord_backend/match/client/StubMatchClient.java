package kr.co.choi.valrecord_backend.match.client;

import kr.co.choi.valrecord_backend.match.dto.MatchDetailDto;
import kr.co.choi.valrecord_backend.match.dto.MatchSummaryDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("stub")
@Component
public class StubMatchClient implements MatchClient {


    @Override
    public List<MatchSummaryDto> listRecentMatches(String puuid, int size) {
        return List.of(
                new MatchSummaryDto("m1","Ascent","competitive","WIN","Jett","2025-09-03T21:10:00"),
                new MatchSummaryDto("m2","Haven","unrated","LOSE","Sova","2025-09-03T20:30:00")
        );
    }

    @Override
    public MatchDetailDto getMatch(String matchId) {
        return new MatchDetailDto(matchId,"Ascent","competitive","WIN",
                new MatchDetailDto.MyStats(24,15,6,245.3));
    }
}
