package skribbl_backend.Controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import skribbl_backend.Dto.GameState;
import skribbl_backend.Service.GameService;

import java.util.List;

@Controller
public class GameWebSocketController {

    private final SimpMessagingTemplate
            messagingTemplate;

    private final GameService
            gameService;

    public GameWebSocketController(

            SimpMessagingTemplate
                    messagingTemplate,

            GameService gameService
    ) {

        this.messagingTemplate =
                messagingTemplate;

        this.gameService =
                gameService;
    }

    @MessageMapping("/game/{roomId}/start")
    public void startGame(

            @DestinationVariable
            String roomId
    ) {

        List<String> players =
                List.of(
                        "Hardik",
                        "Alex",
                        "John"
                );

        GameState state =
                gameService.startGame(
                        players
                );

        messagingTemplate.convertAndSend(

                "/topic/game/" + roomId,

                state
        );
    }
}