package uz.pdp.appclickup.payload;

import lombok.Data;
import uz.pdp.appclickup.enums.WorkspaceRoleName;

@Data
public class WorkspaceRoleDtp {
    private Long workspaceId;
    private String name;
    private WorkspaceRoleName extendRole;
}
