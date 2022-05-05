package uz.pdp.appclickup.service;

import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspaceRoleDtp;

public interface WorkspaceRoleService {

    ApiResponse addRoleForWorkspace(WorkspaceRoleDtp roleDtp);
}
