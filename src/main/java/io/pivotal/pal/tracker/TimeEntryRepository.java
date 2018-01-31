package io.pivotal.pal.tracker;

import java.util.List;

/**
 * Created by e052988 on 1/31/18.
 */
public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long id);
    List<TimeEntry> list();
    TimeEntry update(long id, TimeEntry timeEntry);
    void delete(long id);
}
