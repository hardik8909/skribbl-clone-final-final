package skribbl_backend.Dto;

import lombok.Data;
import skribbl_backend.Model.RoomSetting;
@Data
public class CreateRoomRequest {

    private String hostName;

    private RoomSetting settings;
}
