package skribbl_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skribbl_backend.Dto.CreateRoomRequest;
import skribbl_backend.Dto.JoinRoomRequest;
import skribbl_backend.Model.Room;
import skribbl_backend.Service.RoomService;

@RestController
@RequestMapping("api/rooms")
@CrossOrigin("*")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room createRoom(
            @RequestBody CreateRoomRequest request
    ) {

        return roomService.createRoom(request);
    }

    @PostMapping("/{roomId}/join")
    public Room joinRoom(
            @PathVariable String roomId,
            @RequestBody JoinRoomRequest request
    ) {

        return roomService.joinRoom(
                roomId,
                request.getPlayerName()
        );
    }

    @GetMapping("/{roomId}")
    public Room getRoom(
            @PathVariable String roomId
    ) {

        return roomService.getRoom(roomId);
    }
}
