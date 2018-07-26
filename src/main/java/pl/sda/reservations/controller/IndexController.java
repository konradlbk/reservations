package pl.sda.reservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.reservations.model.EquationDeltaOnly;
import pl.sda.reservations.model.EquationObject;
import pl.sda.reservations.model.EquationOneResult;
import pl.sda.reservations.model.MessageObject;
import pl.sda.reservations.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(path= "/index", method= RequestMethod.GET)
    public ResponseEntity index(){

        return ResponseEntity.ok(new MessageObject("Hello!"));
    }

    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public ResponseEntity count(){

        return ResponseEntity.ok(messageService.getCounter());
    }

    @GetMapping(path = "/parametrized")
    public ResponseEntity parametrized(@RequestParam(name = "who") String who){
        return ResponseEntity.ok(new MessageObject("Hello " + who +"!"));
    }

    @GetMapping(path = "/delta")
    public ResponseEntity count(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b,
                                @RequestParam(name = "c") int c){
        int x1=0;
        int x2=0;
        int delta=(b*b)-4*a*c;
        if (delta<0){
            return ResponseEntity.ok(new EquationDeltaOnly(delta));
        }
        if (delta>0){
            x1=(-b-(int)Math.sqrt(delta))/2*a;
            x2=(-b+(int)Math.sqrt(delta))/2*a;
            return ResponseEntity.ok(new EquationObject(x1,x2,delta));
        }
        if (delta==0){
            x1=(-b/2*a);
            return ResponseEntity.ok(new EquationOneResult(x1, delta));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "/fibo")
    public ResponseEntity fibo(@RequestParam(name = "amount") int amount){

        List<Integer> lista = new ArrayList<>();
        for (int i=0; i<amount; i++){
            if (i==0) {
                lista.add(i);
            }
                if (i==1){
                    lista.add(i);
                }
                if (i>1){
                    lista.add(lista.get(i-1)+lista.get(i-2));
                }
            }
        return ResponseEntity.ok(lista);
        }


        @GetMapping(path = "/zakres")
        public ResponseEntity zakresy(@RequestParam(name = "from")  int from, @RequestParam(name = "to")  int to,
                                      @RequestParam(name = "dzielnik") int dzielnik){
            if (from<to){

                List<Integer> list = new ArrayList<>();
                for (int i=from; i<=to; i++){

                    if (i%dzielnik==0){
                    list.add(i);

                    }
                }
                    return ResponseEntity.ok(list);
            }
            return ResponseEntity.badRequest().build();
        }

        @GetMapping(path="/teksty")
    public ResponseEntity teksty(@RequestParam(name = "tekst") String tekst){

        int wynik=0;
        for (int i=0; i<tekst.length(); i++)
            if (Character.isDigit(tekst.charAt(i))){
            wynik+=tekst.charAt(i)-48;
            }
            return ResponseEntity.ok(wynik);
        }
    }

