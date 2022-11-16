package App.Services;

import App.Models.House;
import App.Repositories.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class HouseService {
    HouseRepo hr;
    @Autowired
    public HouseService(HouseRepo hr){
        this.hr=hr;
    }

    public List<House> allHouses(){
        return hr.findAll();
    }
    /**
     * Adds a House to Database
     * @param h House
     * @return the House
     */
    public House addHouse(House h){
        h.setName(camelCase(h.getName()));
        return hr.save(h);
    }
    /**
     * Gets House by its id
     * @param id house id
     * @return House
     */
    public House getHouseById(int id){
        return hr.getReferenceById(id);
    }
    /**
     * Gets max furniture size by its id
     * @param id house id
     * @return max furniture space
     */
    public int maxSizeForHouse(int id){
        return hr.getReferenceById(id).getHouseId()/2;
    }

    /**
     * Converts a string to Camel Case
     * @param str string not in camel case
     * @return converted string
     */
    public String camelCase(String str){
        //first create an array of lowercase strings split by spaces
        String[] strArray= str.toLowerCase().split(" ");
        String ans="";
        for(int i =0;i< strArray.length; i++){
            if(i!=0){
                //changes the 1st letter to uppercase if not the first word
                ans+=Character.toUpperCase(strArray[i].charAt(0))
                        +strArray[i].substring(1,strArray[i].length());
            }else{
                ans+=strArray[i];
            }
        }
        return ans;
    }

}
