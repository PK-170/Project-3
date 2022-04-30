package nz.ac.wgtn.swen301.assignment2;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.json.JSONObject;

public class JsonLayout extends Layout {

    @Override
    public String format(LoggingEvent event) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loggerName", event.getLogger().getName());
        jsonObject.put("logLevel", event.getLogger().getLevel());
        jsonObject.put("startTime", event.getTimeStamp());
        jsonObject.put("thread", event.getThreadName());
        jsonObject.put("message", event.getMessage());

        return jsonObject.toString();
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {

    }
}
