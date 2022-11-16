package App.Controllers;

import App.Models.House;
import App.Services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HouseController {
    HouseService hs;
    @Autowired
    public HouseController(HouseService hs){
        this.hs=hs;
    }

    @GetMapping("house")
    public List<House> allHouses(){
        return hs.allHouses();
    }

    @PostMapping("house")
    public House addHouse(@RequestBody House h){
        return hs.addHouse(h);
    }

   @GetMapping("house/{id}")
    public House getHouseById(@PathVariable("id") int id){
        return hs.getHouseById(id);
   }







}
