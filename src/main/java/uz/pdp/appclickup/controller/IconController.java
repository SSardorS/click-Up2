package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.IconDto;
import uz.pdp.appclickup.service.IconService;

@RestController
@RequestMapping("/api/icon")
public class IconController {

    @Autowired
    IconService iconService;

    @PostMapping
    public HttpEntity<?> add(IconDto iconDto){
        ApiResponse apiResponse = iconService.addIcon(iconDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
