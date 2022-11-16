package App.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Furniture {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="identifier")
    int furnitureId;
    int squareFeet;
    String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "house")
    House house;
}
