package uz.pdp.appclickup.payload;

import lombok.Data;
import uz.pdp.appclickup.enums.AccessType;


import java.util.UUID;

@Data
public class SpaceDto {

    private String name;

    private String color;

    private Long workspaceId;

    private String initialLetter;

    private Long iconId;

    private UUID avatarId;

    private UUID userId;

    private AccessType accessType;
}
