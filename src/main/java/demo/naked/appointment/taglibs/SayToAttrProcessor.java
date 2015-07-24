package demo.naked.appointment.taglibs;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;

/**
 * Created by tm1c14 on 24/07/2015.
 */
public class SayToAttrProcessor extends AbstractTextChildModifierAttrProcessor {

    private static final String TAGNAME = "sayto";
    protected SayToAttrProcessor() {
        super(TAGNAME);
    }

    @Override
    protected String getText(Arguments arguments, Element element, String attributeName) {
        String val = element.getAttributeValue(attributeName);

        return String.format("Hello %s !", val);
    }

    @Override
    public int getPrecedence() {
        return 1000;
    }
}
