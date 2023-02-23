package de.dacomb.sample;

import static de.dacomb.sample.cucumber.CucumberAssertions.*;

import org.springframework.http.HttpStatus;

import io.cucumber.java.en.Then;

public class HttpSteps {

  @Then("I should be forbidden")
  public void shouldBeForbidden() {
    assertThatLastResponse().hasHttpStatus(HttpStatus.FORBIDDEN);
  }
}
