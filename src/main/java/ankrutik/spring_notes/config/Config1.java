package ankrutik.spring_notes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import ankrutik.spring_notes.play.*;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration 
public class Config1 {

    @Bean
    public Person rushil(){
        return new Person("Rushil");
    }

    @Bean
    public SandwichShop buildShop(){
        return new SandwichShop("Veronica's");
    }

    @Bean
    @Primary
    public SandwichShop buildShop1(){
        return new SandwichShop("Mogo");
    }

    @Bean
    @Qualifier("Santa Maria")
    public SandwichShop buildShop2(){
        return new SandwichShop("Santa Maria");
    }

    @Bean(name = "ArtWich")
    public SandwichShop buildShop3(){
        return new SandwichShop("ArtWich");
    }

    @Bean
    public Plan mondayPlan(Person person, SandwichShop shop){
        return new Plan(person, shop);
    }

    // Name bean with @Qualifier, Autowiring with @Qualifier
    @Bean (name = "TuesdayPlan")
    public Plan tuesdayPlan(Person person, @Qualifier("Santa Maria") SandwichShop shop){
        return new Plan(person, shop);
    }

    // Name bean with @Bean(name = ""), Autowiring with @Qualifier
    @Bean (name = "WednesdayPlan")
    public Plan wednesdayPlan(Person person, @Qualifier("ArtWich")SandwichShop artwich){
        return new Plan(person, artwich);
    }
    
}
