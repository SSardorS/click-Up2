package uz.pdp.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category extends AbsUUIDEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Project project;

    @Column
    private boolean archived = false;

    @Transient
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Status> statuses;

}
