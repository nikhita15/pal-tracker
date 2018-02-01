package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * Created by e052988 on 2/1/18.
 */

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

   private TimeEntryRepository timeEntryRepository;
   private int MAX_ENTRIES = 5;

   public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository =  timeEntryRepository;
   }

    @Override
    public Health health() {
       Health.Builder builder = new Health.Builder();
        if (timeEntryRepository.list().size() < MAX_ENTRIES) {
            builder.up();
        } else {
            builder.down();
        }

        return builder.build();
    }

}
