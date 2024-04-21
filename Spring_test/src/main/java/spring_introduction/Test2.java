package spring_introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        Pet pet = context.getBean("myAnimal", Pet.class);
        pet.say();
        context.close();
    }
}
