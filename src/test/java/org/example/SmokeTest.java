package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Smoke Tests")
class SmokeTest {

  @Test
  @DisplayName("Application compiles successfully")
  void applicationCompiles() {
    assertThat(true).isTrue();
  }
}
