package de.dacomb.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import de.dacomb.sample.common.domain.Generated;

@SpringBootApplication
@Generated(reason = "Not testing logs")
public class SampleApplicationApp {

  private static final Logger log = LoggerFactory.getLogger(SampleApplicationApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(SampleApplicationApp.class, args).getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}
