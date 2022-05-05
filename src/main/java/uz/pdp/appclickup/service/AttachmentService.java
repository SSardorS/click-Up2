package uz.pdp.appclickup.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appclickup.payload.ApiResponse;

import java.io.IOException;

public interface AttachmentService {
    ApiResponse add(MultipartHttpServletRequest request) throws IOException;
}
