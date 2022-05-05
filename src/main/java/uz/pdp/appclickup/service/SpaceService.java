package uz.pdp.appclickup.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.SpaceDto;

public interface SpaceService {

    ApiResponse add(SpaceDto spaceDto);
}
