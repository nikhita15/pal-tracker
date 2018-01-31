package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by e052988 on 1/31/18.
 */
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntries.size() + 1);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }


    @Override
    public TimeEntry find(long id) {
        TimeEntry timeEntry = timeEntries.get(id);
        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntries.replace(id, timeEntry);
        timeEntry.setId(id);
        return timeEntry;
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);

    }
}
