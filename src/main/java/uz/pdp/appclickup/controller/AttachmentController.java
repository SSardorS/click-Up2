package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.service.AttachmentService;

import java.io.IOException;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping
    public HttpEntity<?> add(MultipartHttpServletRequest request) throws IOException {
        ApiResponse add = attachmentService.add(request);
        return ResponseEntity.status(add.isSuccess()?200:409).body(add);
    }
}
