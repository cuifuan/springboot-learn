package store.zabbix.springbootupfile.service.impl;

import store.zabbix.springbootupfile.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${file.path}")
    private String path;

    @Override
    public Map<Object, Object> uploadFile(MultipartFile file) throws IOException {
        Map<Object, Object> resultMap = new HashMap<>(4);

        if (file.isEmpty()) {
            resultMap.put("code", -1);
            resultMap.put("msg", "文件不能为空");
        }

        // 得到上传时的文件名
        String fileName = file.getOriginalFilename();
        // 获取文件输入流
        InputStream is = file.getInputStream();

        /*
         * 使用 Files.copy 命令将文件从输入流源复制到目标目录
         * StandardCopyOption.REPLACE_EXISTING 覆盖已有的目标路径
         */
        Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);

        resultMap.put("code", 0);
        resultMap.put("msg", "success");
        return resultMap;
    }
}
