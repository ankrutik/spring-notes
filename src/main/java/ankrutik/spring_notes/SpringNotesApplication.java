package ankrutik.spring_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import ankrutik.spring_notes.config.Config1;
import ankrutik.spring_notes.play.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ankrutik.spring_notes.play.ShopFinder;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "ankrutik.spring_notes.play")
public class SpringNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNotesApplication.class, args);
		testConfig1();
		testSelfConfigSpringNotesApplication();
	}

	private static void testConfig1(){
		System.out.println("Testing Config1");
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class)) {
			System.out.println(context.getBean("TuesdayPlan"));
			System.out.println(context.getBean("mondayPlan"));
			System.out.println(context.getBean("WednesdayPlan"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void testSelfConfigSpringNotesApplication(){
		System.out.println("Testing SelfConfigSpringNotesApplication");
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringNotesApplication.class)) {
			System.out.println(context.getBean(ShopFinder.class));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
