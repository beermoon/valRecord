package kr.co.choi.valrecord_backend.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchDetailDto {
    private String matchId;
    private String map;
    private String queue;
    private String result;
    private MyStats my;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyStats{
        private int k;
        private int d;
        private int a;
        private double acs;
    }
}
