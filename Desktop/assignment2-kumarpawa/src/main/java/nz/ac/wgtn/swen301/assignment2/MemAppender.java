package nz.ac.wgtn.swen301.assignment2;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemAppender extends AppenderSkeleton {

    public static List<LoggingEvent> loggingEventList = new ArrayList<LoggingEvent>();
    public static String name = "";
    public static long maxSize = 1000;
    public static int discardedLogCount = 0;

    public MemAppender(){

   }

    /**
     *
     * @return A list of logging events
     */
    public static List<LoggingEvent> getCurrentLogs(){
        List <LoggingEvent>  unModifiableList = new ArrayList<>();
        unModifiableList =  Collections.unmodifiableList(loggingEventList);
        return unModifiableList;
    }

    /**
     *
     * @return the count of discardedlogs
     */
    public static long getDiscardedLogCount(){
        return discardedLogCount;
    }

    /**
     * ExportToJson method
     * @param fileName
     * @throws IOException
     */
    public static void exportToJSON(String fileName) throws IOException {

        int counter = 0;
        BufferedWriter buffer = new BufferedWriter(new FileWriter("jsonFile.json"));
        JsonLayout jsonLayout = new JsonLayout();
        String logEventString = "";
        buffer.write("[");
        buffer.newLine();

        for(int i=0; i< loggingEventList.size(); i++) {
            LoggingEvent loggingEvent1 = loggingEventList.get(i);
            logEventString = jsonLayout.format(loggingEvent1);
            if(counter <= loggingEventList.size() - 2){
                buffer.write(logEventString);
                buffer.write(",");
                buffer.newLine();
            }else{
                buffer.write(logEventString);
            }
            counter++;
        }
        buffer.newLine();
        buffer.write("]");
        buffer.close();
    }

    @Override
    protected void append(LoggingEvent event) {

        if (loggingEventList.size() >= maxSize) {
            loggingEventList.remove(0);
            discardedLogCount++;
        }
        loggingEventList.add(event);
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
