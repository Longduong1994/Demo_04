package demo_04.model.service.impl.upload_file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IStorageService {
    String uploadFile(MultipartFile file);
    File convertMultiPartFileToFile(MultipartFile file);
}
