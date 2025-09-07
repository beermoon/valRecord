package kr.co.choi.valrecord_backend.match.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchSummaryDto {
    private String matchId;
    private String map;
    private String queue;
    private String result;  // WIN/LOSE
    private String agent;
    private String startedAt;

}
