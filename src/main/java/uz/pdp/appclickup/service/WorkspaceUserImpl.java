package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.entity.WorkspaceUser;
import uz.pdp.appclickup.repository.UserRepository;
import uz.pdp.appclickup.repository.WorkspaceUserRepository;

import java.util.List;
import java.util.Optional;;

@Service
public class WorkspaceUserImpl implements WorkspaceUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkspaceUserRepository workspaceUserRepository;


    @Override
    public List<User> getWorkspaceMembers(Long workspaceId) {
        List<WorkspaceUser> byWorkspace_id = workspaceUserRepository.findByWorkspace_Id(workspaceId);
        if (byWorkspace_id.isEmpty())
            return null;

        List<User> members = null;
        for (WorkspaceUser workspaceUser : byWorkspace_id) {
            User one = userRepository.getOne(workspaceUser.getUser().getId());
            members.add(one);
        }

        return members;
    }

}
