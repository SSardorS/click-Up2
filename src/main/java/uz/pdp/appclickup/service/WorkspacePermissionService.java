package uz.pdp.appclickup.service;

import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspacePermissionDto;

import java.util.UUID;

public interface WorkspacePermissionService {

    ApiResponse addOrDeletePermission(UUID id,WorkspacePermissionDto permissionDto);
}
