import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Event Class
 * Object that contains unique event code and name.
 * Created by an organizer for other helpers to join.
 *
 * @author ianlo
 * @version 1/25/2020
 */

public class Event {
    private Random eventCodeGenerator = new Random();
    private int eventCode;
    private String eventName;
    private String organizerPassword;
    private String staffPassword;
    private ArrayList<Event> eventList = new ArrayList<>();

    //constructor dedicated to first-time creation of event
    public Event(String name, String organizerPassword, String staffPassword) {
        eventName = name;
        this.organizerPassword = organizerPassword;
        this.staffPassword = staffPassword;
        do {
            eventCode = eventCodeGenerator.nextInt(1000000);
        } while (eventCode < 99999);
    }

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void removeEvent(Event event) {
        eventList.remove(event);
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventCode() {
        return eventCode;
    }

    public String getOrganizerPassword() {
        return organizerPassword;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public void setOrganizerPassword(String organizerPassword) {
        this.organizerPassword = organizerPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Event) {
            return ((Event) obj).getEventName().equals(this.getEventName()) &&
            ((Event) obj).getEventCode() == this.getEventCode();
        } else {
            return false;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("Event[%s, %d]", this.getEventName(), this.getEventCode());
    }
}
