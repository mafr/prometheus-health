package de.mafr.demo.prometheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GaugeDemoApplication {
    
    @Autowired
    private HealthEndpoint healthEndpoint;

    @Bean
    MeterRegistryCustomizer prometheusHealthCheck() {
        return registry -> registry.gauge("health", healthEndpoint, ep -> healthToCode(ep));
    }

    private static int healthToCode(HealthEndpoint ep) {
        Status status = ep.health().getStatus();

        return status.equals(Status.UP) ? 1 : 0;
    }

	public static void main(String[] args) {
		SpringApplication.run(GaugeDemoApplication.class, args);
	}
}
