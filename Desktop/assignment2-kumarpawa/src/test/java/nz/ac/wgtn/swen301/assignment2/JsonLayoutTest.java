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

 @Test
 public void test01(){
     JSONObject jsonObject = new JSONObject("{level:FATAL,logger:nz.ac.wgtn.swen301.assignment2.JSONLayout,start time:1619145259278, thread:main, message:This is the Fatal Level}");
     assertNotNull(jsonObject);
     System.out.println(jsonObject.get("level"));
     assertEquals("FATAL",jsonObject.get("level"));

 }

 @Test
 public void test02(){
     JSONObject jsonObject = new JSONObject("{level:WARN,logger:nz.ac.wgtn.swen301.assignment2.JSONLayout,start time:1619145259278, thread:main, message:This is the Warn Level}");
     assertNotNull(jsonObject);
     System.out.println(jsonObject.get("start time"));
 }

 @Test
 public void test03(){
     JSONObject jsonObject = new JSONObject("{level:ERROR,logger:nz.ac.wgtn.swen301.assignment2.JSONLayout,start time:1619145259278, thread:main, message:This is the Error Level}");
     assertNotNull(jsonObject);
     System.out.println(jsonObject.get("logger"));
     assertEquals("nz.ac.wgtn.swen301.assignment2.JSONLayout", jsonObject.get("logger"));
 }

 @Test
 public void test04(){
     JSONObject jsonObject = new JSONObject("{level:FATAL,logger:nz.ac.wgtn.swen301.assignment2.JSONLayout,start time:1619145259278, thread:main, message:This is the Info Level}");
     assertNotNull(jsonObject);
     System.out.println(jsonObject.get("thread"));
     assertEquals("main", jsonObject.get("thread"));
 }

 @Test
 public void test05(){
     JSONObject jsonObject = new JSONObject("{level:FATAL,logger:nz.ac.wgtn.swen301.assignment2.JSONLayout,start time:1619145259278, thread:main, message:This is the FATAL Level}");
     assertNotNull(jsonObject);
     System.out.println(jsonObject.get("message"));
     assertEquals("This is the FATAL Level", jsonObject.get("message"));
 }

}
