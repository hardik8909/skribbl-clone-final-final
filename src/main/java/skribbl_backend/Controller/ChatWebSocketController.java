package skribbl_backend.Controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import skribbl_backend.Dto.ChatMessage;

@Controller
public class ChatWebSocketController {
    private final SimpMessagingTemplate messagingTemplate;

    public ChatWebSocketController(
            SimpMessagingTemplate messagingTemplate
    ) {

        this.messagingTemplate = messagingTemplate;
    }
    @MessageMapping("/chat/{roomId}")
    public void sendMessage(
            @DestinationVariable String roomId,
            @Payload ChatMessage message
    ) {

        messagingTemplate.convertAndSend(

                "/topic/messages/" + roomId,

                message
        );
    }



}
