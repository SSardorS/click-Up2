package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.entity.WorkspaceUser;
import uz.pdp.appclickup.service.WorkspaceUserImpl;
import uz.pdp.appclickup.service.WorkspaceUserService;

import java.util.List;

@RestController
@RequestMapping("/api/worksapceUser")
public class WorkapceUserController {

    @Autowired
    WorkspaceUserService workspaceUserService;


    @GetMapping("/{id}")
    public HttpEntity<?> getMembers(@PathVariable Long id){
        List<User> workspaceMembers = workspaceUserService.getWorkspaceMembers(id);
        return ResponseEntity.status(workspaceMembers.isEmpty()?200:409).body(workspaceMembers);
    }
}
