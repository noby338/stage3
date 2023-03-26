package priv.noby.springboot4.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件的上传
 *
 * @author Noby
 * @since 2022/10/23
 */
@RestController
@RequestMapping("/dep")
public class DepController {
    @Value("${upload.resourceHandLocations}")
    private String resourceHandLocations;
    @PostMapping("/selectById")
    public void selectById(MultipartFile uploadFile) {
        System.out.println("DepController.selectById");
        try {
            uploadFile.transferTo(new File(resourceHandLocations, uploadFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





