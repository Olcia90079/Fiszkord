package pl.ug.edu.fiszkord.files;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@RestController
@RequestMapping("/api/files")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        //

        // Przykład zwracania odpowiedzi
        return ResponseEntity.ok("Plik " + file.getOriginalFilename() + " został pomyślnie przesłany.");
    }

    // Endpoint do pobierania plików
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("fileName") String fileName) throws IOException {
        // Tutaj uzyskaj dostęp do pliku na podstawie jego nazwy

        // Przykładowa ścieżka do pliku - zamień ją na ścieżkę do rzeczywistego pliku
        String filePath = "/ścieżka/do/folderu/z/plikami/" + fileName;

        // Otwórz plik jako zasób InputStreamResource
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        // Konfiguracja nagłówków odpowiedzi
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

        // Zwróć odpowiedź z plikiem do pobrania
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
