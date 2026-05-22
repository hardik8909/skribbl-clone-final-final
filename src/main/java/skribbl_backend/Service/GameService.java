package skribbl_backend.Service;


import org.springframework.stereotype.Service;

import skribbl_backend.Dto.GameState;

import java.util.*;

@Service
public class GameService {

    private final WordService wordService;

    public GameService(
            WordService wordService
    ) {

        this.wordService = wordService;
    }

    public GameState startGame(
            List<String> players
    ) {

        GameState state =
                new GameState();

        String drawer =
                players.get(0);

        String word =
                wordService.getRandomWord();

        state.setCurrentDrawer(
                drawer
        );

        state.setMaskedWord(

                wordService.maskWord(
                        word
                )
        );

        state.setCurrentRound(1);

        state.setRoundEndTime(

                System.currentTimeMillis()

                        + 60000
        );

        Map<String, Integer>
                scores = new HashMap<>();

        for (String player
                : players) {

            scores.put(player, 0);
        }

        state.setScores(scores);

        return state;
    }
}