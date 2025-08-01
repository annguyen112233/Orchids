package sum25.hsf302.exercise2_se184546.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.hsf302.exercise2_se184546.file_enum.RoleType;
import sum25.hsf302.exercise2_se184546.pojo.Roles;

import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(RoleType roleName);

}
