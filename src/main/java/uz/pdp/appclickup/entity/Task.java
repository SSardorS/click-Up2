package uz.pdp.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task extends AbsUUIDEntity {
    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Priority priority;

    @ManyToOne
    private Task parent;

    @Column
    private Timestamp startedDate;

    private boolean startTimeHas = false;

    private boolean dueTimeHas = false;

    @Column
    private Timestamp dueDate;

    @Column
    private Long estimateTime;

    @Column
    private Timestamp activateDate;
}
