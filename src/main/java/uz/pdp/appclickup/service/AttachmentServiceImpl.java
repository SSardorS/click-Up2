package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appclickup.entity.Attachment;
import uz.pdp.appclickup.entity.AttachmentContent;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.repository.AttachmentContentRepository;
import uz.pdp.appclickup.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @Override
    public ApiResponse add(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()){
            MultipartFile file = request.getFile(fileNames.next());

            if (file!=null){
                Attachment attachment = new Attachment();
                attachment.setOriginalName(file.getOriginalFilename());
                attachment.setName(UUID.randomUUID().toString());
                attachment.setContentType(file.getContentType());
                attachment.setSize(file.getSize());
                attachmentRepository.save(attachment);

                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setAttachmentContent(file.getBytes());
                attachmentContent.setAttachment(attachment);
                attachmentContentRepository.save(attachmentContent);
                return new ApiResponse("ADDED", true);
            }
        }
        return new ApiResponse("Error", false);
    }

}
