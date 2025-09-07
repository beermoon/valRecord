package kr.co.choi.valrecord_backend.match.client;

import kr.co.choi.valrecord_backend.match.dto.MatchDetailDto;
import kr.co.choi.valrecord_backend.match.dto.MatchSummaryDto;

import java.util.List;

public interface MatchClient {
    List<MatchSummaryDto> listRecentMatches(String puuid, int size);
    MatchDetailDto getMatch(String matchId);
}
