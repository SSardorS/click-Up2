package uz.pdp.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.enums.AccessType;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project extends AbsUUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private Space space;

    @Column
    private boolean archived = false;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
    private List<Category> categories;
}
