package de.mafr.demo.prometheus;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class CustomHealthIndicator implements HealthIndicator {
    private volatile Health current = Health.up().build();

    @Override
    public Health health() {
        return current;
    }

    public void setUp() {
        current = Health.up().build();
    }

    public void setDown() {
        current = Health.down().build();
    }

}
