package App.Repositories;

import App.Models.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepo extends JpaRepository<Furniture, Integer> {
}
