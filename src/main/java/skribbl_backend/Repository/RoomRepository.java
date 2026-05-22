package skribbl_backend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import skribbl_backend.Model.Room;

public interface RoomRepository extends MongoRepository<Room,String> {
}
