package sum25.hsf302.exercise2_se184546.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.repository.OrchidRepository;

@Service

public class OrchidServiceImpl implements OrchidService {
    @Autowired
    private OrchidRepository orchidRepository;
    @Override
    public Orchids save(Orchids orchid) {
        return orchidRepository.save(orchid);
    }

    @Override
    public Orchids findById(int id) {
        return orchidRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Orchids> findAllOrchids(Pageable pageable) {
        return orchidRepository.findAll(pageable);
    }

}
