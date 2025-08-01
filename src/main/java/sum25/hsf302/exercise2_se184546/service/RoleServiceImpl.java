package sum25.hsf302.exercise2_se184546.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.hsf302.exercise2_se184546.pojo.Roles;
import sum25.hsf302.exercise2_se184546.repository.RoleRepository;

@Service

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Roles save(Roles role) {
        return roleRepository.save(role);
    }

}
