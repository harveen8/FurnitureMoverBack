package App.Services;

import App.Models.Furniture;
import App.Repositories.FurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Component
@CrossOrigin
public class FurnitureService {
    FurnitureRepo fr;
    HouseService hs;
    @Autowired
    public FurnitureService(FurnitureRepo fr, HouseService hs){
        this.fr=fr;
        this.hs=hs;
    }

    /**
     * Adds Furniture to House
     * @param f Furniture
     * @param houseId house id
     * @return Furniture added
     */
    public Furniture add(Furniture f, int houseId){
        f.setHouse(hs.getHouseById(houseId));
        f.setName(hs.camelCase(f.getName()));
       return fr.save(f);
    }

    /**
     * Gets all occurrences of a furniture type
     * @param name furniture name
     * @return number of occurrences
     */
    public int FurnitireTypeNumber(String name){
        int occurrences=0;
        List<Furniture> AllFurniture= fr.findAll();
        for(int i=0; i< AllFurniture.size(); i++){
            if(AllFurniture.get(i).getName().equals(name)) {
                occurrences++;
            }
        }
        return occurrences;
    }




}
