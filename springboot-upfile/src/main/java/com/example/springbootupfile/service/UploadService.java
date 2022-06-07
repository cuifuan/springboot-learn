package store.zabbix.springbootupfile.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface UploadService {
    Map<Object, Object> uploadFile(MultipartFile file) throws IOException;
}
