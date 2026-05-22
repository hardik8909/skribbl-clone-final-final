package skribbl_backend.Controller;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import skribbl_backend.Dto.DrawData;

@Controller
public class DrawingWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public DrawingWebSocketController(
            SimpMessagingTemplate messagingTemplate
    ) {

        this.messagingTemplate = messagingTemplate;
    }
    @MessageMapping("/draw/{roomId}")
    public void draw(
            @DestinationVariable String roomId,
            DrawData drawData
    ) {

        messagingTemplate.convertAndSend(

                "/topic/draw/" + roomId,

                drawData
        );
    }


}
