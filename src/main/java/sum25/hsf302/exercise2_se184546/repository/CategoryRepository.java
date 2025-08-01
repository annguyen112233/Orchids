package sum25.hsf302.exercise2_se184546.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.hsf302.exercise2_se184546.pojo.Categories;
@Repository

public interface CategoryRepository extends JpaRepository<Categories, Integer> {
}
