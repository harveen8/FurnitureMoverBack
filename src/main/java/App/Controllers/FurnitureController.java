package App.Controllers;

import App.Models.Furniture;
import App.Services.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FurnitureController {
    FurnitureService fs;
    @Autowired
    public FurnitureController(FurnitureService fs){
        this.fs=fs;
    }

    @GetMapping("furniture/{name}")
    public int furnitureName(@PathVariable("name") String name){
        return fs.FurnitireTypeNumber(name);
    }

    @PostMapping("furniture/{id}")
    public Furniture addFurniture(@PathVariable("id") int id,
                                  @RequestBody Furniture f){
        return fs.add(f, id);
    }


}
