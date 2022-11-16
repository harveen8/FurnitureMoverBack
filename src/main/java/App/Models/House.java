package App.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class House {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    int houseId;
    int squareFeet;
    String name;

    @OneToMany(mappedBy = "house")
    @JsonIgnore
    List<Furniture> furnitureList;

}
