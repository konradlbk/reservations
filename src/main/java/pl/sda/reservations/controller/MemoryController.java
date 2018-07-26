package pl.sda.reservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.reservations.service.MemoryService;

@RestController
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping(path = "/dodawanie")
    public ResponseEntity dodajLiczbe(@RequestParam(name = "number") int number){

        return ResponseEntity.ok(memoryService.dodaj(number));

    }

    @GetMapping(path = "/show")
    public ResponseEntity podajLiczby(){

        return ResponseEntity.ok(memoryService.show());
    }

    @GetMapping(path = "/erase")
        public ResponseEntity usun(){
        return ResponseEntity.ok(memoryService.erase());

        }

        @GetMapping(path = "/najmniejsza")
    public ResponseEntity podajNajmniejsza(){

        return ResponseEntity.ok(memoryService.lowest());
        }
    @GetMapping(path = "/najwieksza")
    public ResponseEntity podajNajwieksza(){

        return ResponseEntity.ok(memoryService.highest());
    }

}
