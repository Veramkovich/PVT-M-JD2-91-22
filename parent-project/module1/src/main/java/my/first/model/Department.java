package my.first.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_department")
@Getter
@Setter
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

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
