package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.Workspace;
import uz.pdp.appclickup.entity.WorkspaceRole;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspaceRoleDtp;
import uz.pdp.appclickup.repository.WorkspaceRepository;
import uz.pdp.appclickup.repository.WorkspaceRoleRepository;

import java.util.Optional;

@Service
public class WorkspaceRoleServiceImpl implements WorkspaceRoleService{

    @Autowired
    WorkspaceRoleRepository workspaceRoleRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;


    @Override
    public ApiResponse addRoleForWorkspace(WorkspaceRoleDtp roleDtp) {
        Optional<Workspace> byId = workspaceRepository.findById(roleDtp.getWorkspaceId());
        if (!byId.isPresent())
            return new ApiResponse("Workspace topilmadi", false);

        WorkspaceRole workspaceRole = new WorkspaceRole(byId.get(), roleDtp.getName(), roleDtp.getExtendRole());
        workspaceRoleRepository.save(workspaceRole);
        return new ApiResponse("Added", true);
    }
}
