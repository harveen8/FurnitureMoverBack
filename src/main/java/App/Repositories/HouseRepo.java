package App.Repositories;

import App.Models.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepo extends JpaRepository<House, Integer> {
}
