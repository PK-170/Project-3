package nz.ac.wgtn.swen301.assignment2;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.json.JSONObject;
import org.junit.Test;

import org.apache.log4j.Logger;
import static org.junit.Assert.*;

public class JsonLayoutTest {

 @Test
 public void testFormat(){
     JsonLayout layout = new JsonLayout();
     Logger logger = Logger.getLogger(layout.getClass());
     assertNotNull(logger);
     logger.setLevel(Level.WARN);
     LoggingEvent loggingEvent = new LoggingEvent("dimsim", logger, logger.getLevel(), "this is warn level", new Throwable());
     assertNotNull(loggingEvent);
     String string = layout.format(loggingEvent);
     System.out.println(string);
 }

}
