package skribbl_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class RoomSetting {

    private int maxPlayers = 8;

    private int rounds = 3;

    private int drawTime = 60;

    private int wordChoices = 3;
}
