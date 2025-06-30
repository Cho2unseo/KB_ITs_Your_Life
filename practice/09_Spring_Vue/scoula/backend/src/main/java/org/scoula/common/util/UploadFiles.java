package org.scoula.common.util;

import org.scoula.board.common.util.UploadFileName;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException {
        File base = new File(baseDir);
        if (!base.exists()) {
            base.mkdirs();
        }

        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
        part.transferTo(dest);
        return dest.getPath();
    }

    public static void downloadImage(HttpServletResponse response, File file) {
        try {
            Path path = Path.of(file.getPath());
            String mimeType = Files.probeContentType(path);
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());

            try (OutputStream os = response.getOutputStream();
                 BufferedOutputStream bos = new BufferedOutputStream(os)) {
                Files.copy(path, bos);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
