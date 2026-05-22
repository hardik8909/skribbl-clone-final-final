package skribbl_backend.Dto;

import lombok.Data;

import java.util.Map;

@Data
public class GameState {

    private String currentDrawer;

    private String maskedWord;

    private int currentRound;

    private long roundEndTime;

    private Map<String, Integer> scores;
}