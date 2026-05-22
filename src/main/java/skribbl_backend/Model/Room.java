package skribbl_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import skribbl_backend.enums.GamePhase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Room {
    @Id
    private String roomId;

    private List<Player> players = new ArrayList<>();

    private String currentDrawerId;

    private String currentWord;

    private int currentRound = 1;

    private GamePhase phase = GamePhase.WAITING;

    private RoomSetting settings = new RoomSetting();

    private List<Stroke> strokes = new ArrayList<>();
    private String CurrentWord;

    private String currentDrawer;

    private int CurrentRound;

    private boolean gameStarted;

    private long roundEndTime;
    private List<String> Players;





    private int maxRounds;



    private long RoundEndTime;

    private Map<String, Integer> scores;
}
