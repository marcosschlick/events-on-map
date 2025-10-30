package event;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EventController {

    private final EventRepository repository;

    EventController(EventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/events")
    Event newEvent(@RequestBody Event newEvent) {
        return repository.save(newEvent);
    }

    @GetMapping("/events")
    List<Event> all() {
        return repository.findAll();
    }

    @GetMapping("/events/{id}")
    Event one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @PutMapping("/events/{id}")
    Event replaceEvent(@RequestBody Event newEvent, @PathVariable Long id) {

        return repository.findById(id)
                .map(event -> {
                    event.setName(newEvent.getName());
                    return repository.save(event);
                })
                .orElseGet(() -> {
                    return repository.save(newEvent);
                });
    }

    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}