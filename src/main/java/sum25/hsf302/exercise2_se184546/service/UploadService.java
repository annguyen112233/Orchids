package sum25.hsf302.exercise2_se184546.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String save(MultipartFile file);

}
