package uz.pdp.appclickup.service;

import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.entity.WorkspaceUser;

import java.util.List;
import java.util.UUID;

public interface WorkspaceUserService {

    List<User> getWorkspaceMembers(Long workspaceId);
}
