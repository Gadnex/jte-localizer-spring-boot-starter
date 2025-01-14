package io.github.gadnex.jtelocalizer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gg.jte.localizer")
public class JteProperties {

  private boolean inject = false;

  public boolean isInject() {
    return inject;
  }

  public void setInject(boolean inject) {
    this.inject = inject;
  }
}
