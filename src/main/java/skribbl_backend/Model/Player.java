package skribbl_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Player {
    @Id
    private String playerId;

    private String name;

    private int score = 0;

    private boolean host = false;

    private boolean guessed = false;
}
