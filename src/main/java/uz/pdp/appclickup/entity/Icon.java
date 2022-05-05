package uz.pdp.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Icon extends AbsLongEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @Column
    private String initialLetter;

    @OneToOne
    private Attachment attachment;
}
