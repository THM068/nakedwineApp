package demo.naked.appointment.config;

import demo.naked.appointment.filters.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Created by tm1c14 on 14/08/2015.
 */
@Configuration
public class WebConfig {

    @Bean
    public Filter securityFilter() {
        return new SecurityFilter();
    }
}
