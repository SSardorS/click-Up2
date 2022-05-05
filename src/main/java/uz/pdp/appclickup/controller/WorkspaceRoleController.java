package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspaceRoleDtp;
import uz.pdp.appclickup.service.WorkspaceRoleService;

@RestController
@RequestMapping("/api/workspacerole")
public class WorkspaceRoleController {

    @Autowired
    WorkspaceRoleService workspaceRoleService;

    @PostMapping
    public HttpEntity<?> add(WorkspaceRoleDtp workspaceRoleDtp){
        ApiResponse apiResponse = workspaceRoleService.addRoleForWorkspace(workspaceRoleDtp);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }



}
