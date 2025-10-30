package event;

class EventNotFoundException extends RuntimeException {

    EventNotFoundException(Long id) {
        super("Could not find event " + id);
    }
}