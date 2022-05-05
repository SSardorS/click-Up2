package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.*;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.SpaceDto;
import uz.pdp.appclickup.repository.*;

import java.util.Optional;

@Service
public class SpaceServiceImpl implements SpaceService{
    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    IconRepository iconRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse add(SpaceDto spaceDto) {
        Optional<Icon> iconBy = iconRepository.findById(spaceDto.getIconId());
        Optional<Workspace> workspaceBy = workspaceRepository.findById(spaceDto.getWorkspaceId());
        Optional<User> userBy = userRepository.findById(spaceDto.getUserId());
        Optional<Attachment> attachmentBy = attachmentRepository.findById(spaceDto.getAvatarId());

        if (!iconBy.isPresent() || !workspaceBy.isPresent() || !userBy.isPresent() || !attachmentBy.isPresent())
            return new ApiResponse("Malumotlar topilmadi", false);

        Space space = new Space(spaceDto.getName(), spaceDto.getColor(), workspaceBy.get(), spaceDto.getInitialLetter(), iconBy.get(), attachmentBy.get(), userBy.get(), spaceDto.getAccessType());
        spaceRepository.save(space);
        return new ApiResponse("Added", true);
    }
}
