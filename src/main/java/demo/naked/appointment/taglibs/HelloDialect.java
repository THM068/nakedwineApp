package demo.naked.appointment.taglibs;

import demo.naked.appointment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tm1c14 on 24/07/2015.
 */
public class HelloDialect extends AbstractDialect {
    @Autowired
    private AppointmentService appointmentService;

    @Override
    public String getPrefix() {
        return "hello";
    }

    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new SayToAttrProcessor());
        SayToPlanetAttrProcessor sayToPlanetAttrProcessor = new SayToPlanetAttrProcessor();
        sayToPlanetAttrProcessor.setAppointmentService(appointmentService);
        processors.add(sayToPlanetAttrProcessor);
        return processors;
    }

}
