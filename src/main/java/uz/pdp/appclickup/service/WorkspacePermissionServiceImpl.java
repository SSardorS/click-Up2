package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.WorkspacePermission;
import uz.pdp.appclickup.entity.WorkspaceRole;
import uz.pdp.appclickup.enums.AddType;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspacePermissionDto;
import uz.pdp.appclickup.repository.WorkspacePermissionRepository;
import uz.pdp.appclickup.repository.WorkspaceRoleRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class WorkspacePermissionServiceImpl implements WorkspacePermissionService{

    @Autowired
    WorkspacePermissionRepository permissionRepository;

    @Autowired
    WorkspaceRoleRepository roleRepository;

    @Override
    public ApiResponse addOrDeletePermission(UUID id, WorkspacePermissionDto permissionDto) {
        Optional<WorkspaceRole> byId = roleRepository.findById(permissionDto.getRole());

        if (!byId.isPresent())
            return new ApiResponse("Bunday role yoq", false);


        if (permissionDto.getAddType().equals(AddType.ADD)){
            WorkspacePermission workspacePermission = new WorkspacePermission();

            workspacePermission.setWorkspaceRole(byId.get());
            workspacePermission.setPermission(permissionDto.getPermission());
            return new ApiResponse("Added", true);
        }

        if (permissionDto.getAddType().equals(AddType.REMOVE)){
            permissionRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }

        return new ApiResponse("something is wrong", false);
    }
}
