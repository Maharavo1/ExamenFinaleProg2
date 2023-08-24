package ExamenProg2.com.Prog2.Service;

import ExamenProg2.com.Prog2.Repository.RoomDAO;
import ExamenProg2.com.Prog2.model.room;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomService {
    private RoomDAO roomDAO;


    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public List<room> getAllRooms() {
       return roomDAO.getAllRoom();
    }
    public List<room> getAvailableRooms(LocalDateTime dateTime){
        return roomDAO.getAvailableRoom(dateTime);
    }

    public void insertRooms(room toInsert) {
       roomDAO.insertRoom(toInsert);
    }

    public room getIdRooms(int id) {
      return roomDAO.getIdRoom(id);
    }

    public room updateRooms(int id, room toUpdate) {
        return roomDAO.updateRoom(id , toUpdate);
    }

    public List<room> deleteRooms(int id) {
       return roomDAO.deleteRoom(id);
    }
}
