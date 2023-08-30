package ExamenProg2.com.Prog2.Controller;

import ExamenProg2.com.Prog2.Service.RoomService;
import ExamenProg2.com.Prog2.model.room;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RoomController {
    private RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room")
    public List<room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/roomInsert")
    public void insertRoom(@RequestBody room toInsert) {
        roomService.insertRooms(toInsert);
    }

    @GetMapping("/roomId/{id}")
    public room getRoomById(@PathVariable int id) {
        return roomService.getIdRooms(id);
    }
    @GetMapping("/roomAvalaible")
    public List<room> getAvailableRooms(@RequestParam("dateTime") String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        return roomService.getAvailableRooms(localDateTime);
    }
    @PutMapping("/roomUpdate/{id}")
    public room updateRoom(@PathVariable int id, @RequestBody room toUpdate) {
        return roomService.updateRooms(id, toUpdate);
    }

    @DeleteMapping("/roomDelete/{id}")
    public List<room> deleteRoom(@PathVariable int id) {
        return roomService.deleteRooms(id);
    }
}
