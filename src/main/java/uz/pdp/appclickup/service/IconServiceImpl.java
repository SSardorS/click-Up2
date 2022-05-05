package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.Attachment;
import uz.pdp.appclickup.entity.Icon;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.IconDto;
import uz.pdp.appclickup.repository.AttachmentRepository;
import uz.pdp.appclickup.repository.IconRepository;

import java.util.Optional;

@Service
public class IconServiceImpl implements IconService{

    @Autowired
    IconRepository iconRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public ApiResponse addIcon(IconDto iconDto) {
        Optional<Attachment> byId = attachmentRepository.findById(iconDto.getAttachmentId());
        if (!byId.isPresent())
            return new ApiResponse("bunday iconka  qoshilmagan", false);

        Icon icon = new Icon(iconDto.getName(), iconDto.getColor(), iconDto.getInitialLetter(), byId.get());
        iconRepository.save(icon);
        return new ApiResponse("ADDED", true);
    }
}
