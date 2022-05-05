package uz.pdp.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.enums.AccessType;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Space extends AbsUUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private Workspace workspace;

    @Column
    private String initialLetter;


    @PrePersist
    @PreUpdate
    public void setInitialLetterMyMethod() {
        this.initialLetter = name.substring(0, 1);
    }

    @ManyToOne
    private Icon icon;

    @OneToOne
    private Attachment avatar;

    @ManyToOne
    private User owner;


    @Enumerated(EnumType.STRING)
    private AccessType accessType;

}
