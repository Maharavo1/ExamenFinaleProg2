package ExamenProg2.com.Prog2.Repository;

import ExamenProg2.com.Prog2.model.room;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public abstract class RoomDAO {
    public abstract List<room> getAllRoom();

    public abstract List<room> getAvailableRoom(LocalDateTime dateTime);
    public abstract  void insertRoom(room toInsert);
    public abstract room getIdRoom(int id);
    public abstract room updateRoom(int id,  room toUpdate);
    public abstract List<room> deleteRoom(int id);
}
