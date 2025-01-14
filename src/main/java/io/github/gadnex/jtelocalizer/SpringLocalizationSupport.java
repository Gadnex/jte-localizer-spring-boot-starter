package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import java.util.Locale;
import org.springframework.context.MessageSource;

public class SpringLocalizationSupport implements LocalizationSupport {

  private final MessageSource messageSource;
  private final Locale locale;

  public SpringLocalizationSupport(final MessageSource messageSource, final Locale locale) {
    this.messageSource = messageSource;
    this.locale = locale;
  }

  @Override
  public String lookup(String key) {
    return messageSource.getMessage(key, null, locale);
  }
}
