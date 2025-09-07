package kr.co.choi.valrecord_backend.match.service;


import lombok.RequiredArgsConstructor;
import kr.co.choi.valrecord_backend.match.client.MatchClient;
import kr.co.choi.valrecord_backend.match.dto.MatchDetailDto;
import kr.co.choi.valrecord_backend.match.dto.MatchSummaryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchClient client;
    public List<MatchSummaryDto> recent(String puuid, int size) {
        return client.listRecentMatches(puuid,size);
    }
    public MatchDetailDto one(String id) {
        return client.getMatch(id);
    }
}
