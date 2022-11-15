package my.first.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope
public class PersonService {

    public void print(Person person) {
        System.out.println(person);
    }

}
