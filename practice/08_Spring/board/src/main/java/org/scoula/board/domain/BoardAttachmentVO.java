package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.common.util.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardAttachmentVO {
    private Long no;
    private Long bno;
    private String filename;
    private String path;
    private String contentType;
    private Long size;
    private Date regDate;

    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) {
        return BoardAttachmentVO.builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .path(path)
                .contentType(part.getContentType())
                .size(part.getSize())
                .build();
    }

    // 해당 메소드가 getter처럼 사용돼서 fileSize는 읽기전용 프로퍼티로 제공
    public String getFileSize() {
        return UploadFiles.getFormatSize(size);
    }
}
