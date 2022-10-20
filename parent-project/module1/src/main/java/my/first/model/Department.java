package my.first.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_department")
@Data
public class Department {

    @Id
    @Column(name = "F_DEPARTMENTID")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private long id;

    @Column(name = "F_DEPARTMENTNAME")
    private String departmentName;

}
