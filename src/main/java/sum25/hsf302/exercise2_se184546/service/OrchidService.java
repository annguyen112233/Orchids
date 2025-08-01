package sum25.hsf302.exercise2_se184546.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;

public interface OrchidService {
    Orchids save(Orchids orchid);

    Orchids findById(int id);

    Page<Orchids> findAllOrchids(Pageable pageable);


}
