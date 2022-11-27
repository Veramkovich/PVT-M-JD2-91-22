package my.first.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_counter")
@Data
public class Counter {

    @Id
    private long id;

    private int count;

}
