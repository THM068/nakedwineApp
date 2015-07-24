package demo.naked.appointment.config;

import demo.naked.appointment.taglibs.HelloDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;

/**
 * Created by tm1c14 on 24/07/2015.
 */
@Configuration
public class TagLibConfig {

    @Bean
    public IDialect helloDialect() {
        return new HelloDialect();
    }
}
