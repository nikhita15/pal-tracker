package io.pivotal.pal.tracker;

import com.sun.management.jmx.TraceNotification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by e052988 on 1/31/18.
 */
@RestController
@ResponseBody
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        timeEntryRepository = this.timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(TimeEntry timeEntry) {
        TimeEntry createTimeEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(createTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry != null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List list = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(list, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable long id, TimeEntry timeEntry) {
        TimeEntry timeEntryUdated = timeEntryRepository.update(id, timeEntry);

        if (timeEntryUdated!= null) {
            return new ResponseEntity<TimeEntry>(timeEntryUdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
