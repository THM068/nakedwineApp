package demo.naked.appointment.utils;

import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

/**
 * Created by tm1c14 on 24/07/2015.
 */
public class TagUtility {

    public static IStandardExpression getExpression(final Arguments arguments, final Element element, String  attributeName) {
        final Configuration configuration = arguments.getConfiguration();
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        final String attributeValue = element.getAttributeValue(attributeName);
        final IStandardExpression expression = parser.parseExpression(configuration, arguments, attributeValue);

        return expression;
    }
}
