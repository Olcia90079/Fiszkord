package pl.ug.edu.fiszkord.files;

import java.util.Objects;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private FileRepository fileRepository;

    public FileEntity store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileEntity fileEntity = FileEntity.builder()
                .name(file.getName())
                .type(file.getContentType())
                .data(file.getBytes())
                .build();
        return fileRepository.save(fileEntity);
    }

    public FileEntity getFile(Integer id) {
        return fileRepository.findById(id).get();
    }

    public Stream<FileEntity> getAllFiles(Integer subjectId) {
        return fileRepository.findAllFilesBySubjectId(subjectId).stream();
    }
}
