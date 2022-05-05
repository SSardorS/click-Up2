package uz.pdp.appclickup.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class IconDto {

    private String name;

    private String color;

    private String initialLetter;

    private UUID attachmentId;
}
