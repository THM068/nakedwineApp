package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"demo.naked.appointment"})

public class NakedAppintmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(NakedAppintmentApplication.class, args);
    }
}
