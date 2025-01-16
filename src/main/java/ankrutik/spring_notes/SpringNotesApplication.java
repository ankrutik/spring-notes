package ankrutik.spring_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ankrutik.spring_notes.config.Config1;
import ankrutik.spring_notes.play.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNotesApplication.class, args);

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class)) {
			System.out.println(context.getBean("TuesdayPlan"));
			System.out.println(context.getBean("mondayPlan"));
			System.out.println(context.getBean("WednesdayPlan"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
