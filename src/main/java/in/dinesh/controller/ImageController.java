package in.dinesh.controller;

import in.dinesh.dto.ImageDTO;
import in.dinesh.response.ApiResponse;
import in.dinesh.service.image.IImageService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/images")
@Builder
public class ImageController {

    private final IImageService iImageService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> saveImages(List<MultipartFile> files, @RequestParam Long productId) {
        try {
            List<ImageDTO> imageDTOS =iImageService.saveImages(files, productId);
            return ResponseEntity.ok(new ApiResponse("upload Success!",imageDTOS));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(new ApiResponse("Upload Failed", e.getMessage()));
        }
    }


}
