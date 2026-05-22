package skribbl_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skribbl_backend.Dto.CreateRoomRequest;
import skribbl_backend.Model.Player;
import skribbl_backend.Model.Room;
import skribbl_backend.Repository.RoomRepository;

import java.util.UUID;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public Room createRoom(CreateRoomRequest request){
        Room room = new Room();

        room.setRoomId(generateRoomCode());

        room.setSettings(request.getSettings());

        Player host = new Player();

        host.setPlayerId(UUID.randomUUID().toString());

        host.setName(request.getHostName());

        host.setHost(true);

        room.getPlayers().add(host);

        return roomRepository.save(room);
    }
    private String generateRoomCode() {

        return UUID.randomUUID()
                .toString()
                .substring(0, 6)
                .toUpperCase();
    }
    public Room joinRoom(String roomId, String playerName) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Player player = new Player();

        player.setPlayerId(UUID.randomUUID().toString());

        player.setName(playerName);

        room.getPlayers().add(player);

        return roomRepository.save(room);
    }

    public Room getRoom(String roomId) {

        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

}
