package pl.sda.reservations.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MemoryService {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> dodaj (int a){
        list.add(a);
        return list;
    }

    public List<Integer> show(){

        return list;
    }

    public List<Integer> erase(){
            list=new ArrayList<>();
            return list;
    }

    public int lowest(){
        int number=list.get(0);
        for (int i=1; i<list.size(); i++){
            if (list.get(i)<number){

                number=list.get(i);

            }
        }
        return number;
    }

    public int highest(){
        int number=list.get(0);
        for (int i=1; i<list.size(); i++){
            if (list.get(i)>number){

                number=list.get(i);

            }
        }
        return number;

    }
}
