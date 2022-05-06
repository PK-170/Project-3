package nz.ac.wgtn.swen301.assignment2;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MemAppenderTest {
    /**
     * Testing the getCurrentLogs method
     */
    @Test
    public void test01() {
        MemAppender memAppender = new MemAppender();
        Logger logger = Logger.getLogger(MemAppender.class);
        assertNotNull(logger);
        LoggingEvent loggingEvent1 = new LoggingEvent("foo", logger, logger.getLevel(), "This is the Fatal Level", new Throwable());
        assertNotNull(loggingEvent1);
        LoggingEvent loggingEvent2 = new LoggingEvent("foo2", logger, logger.getLevel(), "This is the Error Level", new Throwable());
        assertNotNull(loggingEvent2);
        LoggingEvent loggingEvent3 = new LoggingEvent("foo2", logger, logger.getLevel(), "This is the Error Level", new Throwable());
        assertNotNull(loggingEvent3);
        memAppender.append(loggingEvent1);
        memAppender.append(loggingEvent2);
        memAppender.append(loggingEvent3);
        System.out.println(memAppender.getCurrentLogs());
}

    /**
     * Testing the getDiscardedLogCount
     */
    @Test
    public void test02() {
        MemAppender memAppender = new MemAppender();

        Logger logger = Logger.getLogger(MemAppender.class);
        assertNotNull(logger);
        LoggingEvent loggingEvent1 = new LoggingEvent("foo", logger, logger.getLevel(), "This is the Fatal Level", new Throwable());
        assertNotNull(loggingEvent1);
        LoggingEvent loggingEvent2 = new LoggingEvent("foo2", logger, logger.getLevel(), "This is the Error Level", new Throwable());
        assertNotNull(loggingEvent2);
        LoggingEvent loggingEvent3 = new LoggingEvent("foo2", logger, logger.getLevel(), "This is the Error Level", new Throwable());
        assertNotNull(loggingEvent3);
        memAppender.append(loggingEvent1);
        memAppender.append(loggingEvent2);
        memAppender.append(loggingEvent3);
        System.out.println(memAppender.getDiscardedLogCount());
    }

    /**
     * testing the exportToJson method
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        MemAppender memAppender = new MemAppender();
        Logger logger = Logger.getLogger(MemAppender.class);
        assertNotNull(logger);
        LoggingEvent loggingEvent1 = new LoggingEvent("foo", logger, logger.getLevel(), "This is the Fatal Level", new Throwable());
        assertNotNull(loggingEvent1);
        LoggingEvent loggingEvent2 = new LoggingEvent("foo2", logger, logger.getLevel(), "This is the Error Level", new Throwable());
        assertNotNull(loggingEvent2);
        LoggingEvent loggingEvent3 = new LoggingEvent("foo3", logger, logger.getLevel(), "This is the Info Level", new Throwable());
        assertNotNull(loggingEvent3);
        memAppender.append(loggingEvent1);
        memAppender.append(loggingEvent2);
        memAppender.append(loggingEvent3);

        memAppender.exportToJSON("jsonFile.json");
    }

}
