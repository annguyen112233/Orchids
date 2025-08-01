package sum25.hsf302.exercise2_se184546.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    // Đường dẫn lưu ảnh vào thư mục static/images
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Override
    public String save(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        // Lấy tên gốc và tạo tên duy nhất tránh trùng
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

        try {
            // Tạo thư mục nếu chưa có
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Lưu file
            Path filePath = uploadPath.resolve(uniqueFileName);
            file.transferTo(filePath.toFile());

            return uniqueFileName; // Trả về tên file đã lưu
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
