package demo.naked.appointment.taglibs;

import demo.naked.appointment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.Configuration;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

/**
 * Created by tm1c14 on 24/07/2015.
 */

public class SayToPlanetAttrProcessor extends AbstractTextChildModifierAttrProcessor {


    private AppointmentService appointmentService;

    public SayToPlanetAttrProcessor() {
        super("saytoplanet");
    }

    @Override
    protected String getText(Arguments arguments, Element element, String attributeName) {
        final Configuration configuration = arguments.getConfiguration();

        final IStandardExpressionParser parser =
                StandardExpressions.getExpressionParser(configuration);

        final String attributeValue = element.getAttributeValue(attributeName);

        final IStandardExpression expression =
                parser.parseExpression(configuration, arguments, attributeValue);

        final String planet = (String) expression.execute(configuration, arguments);
        appointmentService.helloService();
        return String.format("Hello, planet %s ",planet);
    }

    @Override
    public int getPrecedence() {
        return 11000;
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
