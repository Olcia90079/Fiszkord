package pl.ug.edu.fiszkord.chats;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/{subjectId}")
    @SendTo("/topic/{subjectId}")
    public Message sendMessage(
            @DestinationVariable String subjectId,
            @Payload Message message
    ) {
        return message;
    }
}