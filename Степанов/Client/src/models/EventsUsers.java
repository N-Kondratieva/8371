package models;

public class EventsUsers {
    private int eventId;
    private int userId;

    public EventsUsers(int event_id, int user_id) {
        this.eventId = event_id;
        this.userId = user_id;
    }

    public int getEventId() {
        return eventId;
    }

    public int getUserId() {
        return userId;
    }
}
