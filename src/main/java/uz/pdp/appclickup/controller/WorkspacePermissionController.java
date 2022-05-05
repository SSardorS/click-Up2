package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspacePermissionDto;
import uz.pdp.appclickup.service.WorkspacePermissionService;

import java.util.UUID;

@RestController
@RequestMapping("/api/workspacepermission")
public class WorkspacePermissionController {

    @Autowired
    WorkspacePermissionService permissionService;

    @PostMapping("/{id}")
    public HttpEntity<?> addOrDelete(@PathVariable UUID id, WorkspacePermissionDto permissionDto){
        ApiResponse apiResponse = permissionService.addOrDeletePermission(id, permissionDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
