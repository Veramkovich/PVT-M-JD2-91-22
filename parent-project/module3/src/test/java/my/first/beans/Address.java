package my.first.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Address implements AbstractAddress {

    private Long id;
    private String street;
    private Integer home;
    private List<String> phoneNumbers;

    public Address(Long id) {
        this.id = id;
    }
}
