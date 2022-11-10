package my.first.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

@Getter
@Setter
public class Person implements InitializingBean, DisposableBean, ApplicationContextAware {

    private String name;
    private String secondName;
    private AbstractAddress homeAddress;
    private Map<Integer, Person> children;

    public Person() {
        System.out.println("call Person() " + name + " " + secondName);
    }

    public void init(){
        System.out.println("Call init() " + name + " " + secondName);
    }

    public void destroy(){
        System.out.println("Call destroy()");
    }

    public void destroy2(){
        System.out.println("Call destroy2()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Call afterPropertiesSet() " + name + " " + secondName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Call setApplicationContext " + name + " " + secondName);
    }
}
