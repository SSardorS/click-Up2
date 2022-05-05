package uz.pdp.appclickup.payload;

import lombok.Data;
import uz.pdp.appclickup.enums.AddType;

import java.util.UUID;

@Data
public class MemberDTO {
    private UUID id;

    private UUID roleId;

    private AddType addType;//ADD, EDIT, REMOVE
}
