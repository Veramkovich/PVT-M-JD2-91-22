package my.first.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "t_employee")
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "t_employee_seq")
    private long id;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeDetail employeeDetail;

    @ManyToOne
    @JoinColumn(name = "F_DEPARTMENTID")
    private Department department;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_employee_meeting",
            joinColumns = @JoinColumn(name = "F_EMPLOYEEID"),
            inverseJoinColumns = @JoinColumn(name = "F_MEETING_ID")
    )
    private Set<Meeting> meetings;
}
