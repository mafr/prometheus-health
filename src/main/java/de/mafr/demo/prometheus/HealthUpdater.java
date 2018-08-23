package de.mafr.demo.prometheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthUpdater {
    
    @Autowired
    private CustomHealthIndicator indicator;

    @PostMapping("/up")
    public void up() {
        indicator.setUp();
    }
    
    @PostMapping("/down")
    public void down() {
        indicator.setDown();
    }
}
