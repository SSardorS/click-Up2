package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.SpaceDto;
import uz.pdp.appclickup.service.SpaceService;

@RestController
@RequestMapping("/api/space")
public class SpaceController {

    @Autowired
    SpaceService spaceService;

    @PostMapping
    public HttpEntity<?> add(SpaceDto spaceDto){
        ApiResponse add = spaceService.add(spaceDto);
        return ResponseEntity.status(add.isSuccess()?200:409).body(add);
    }

}
