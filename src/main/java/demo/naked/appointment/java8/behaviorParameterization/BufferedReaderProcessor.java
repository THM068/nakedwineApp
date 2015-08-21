package demo.naked.appointment.java8.behaviorParameterization;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by tm1c14 on 18/08/2015.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;
}
