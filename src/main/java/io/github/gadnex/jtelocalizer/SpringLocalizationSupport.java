package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import java.util.Locale;
import org.springframework.context.MessageSource;

/** Class implementing the LocalizationSupport interface provided by JTE */
public class SpringLocalizationSupport implements LocalizationSupport {

  private final MessageSource messageSource;
  private final Locale locale;

  /**
   * Constructor
   *
   * @param messageSource The Spring Boot MessageSource
   * @param locale The locale
   */
  public SpringLocalizationSupport(final MessageSource messageSource, final Locale locale) {
    this.messageSource = messageSource;
    this.locale = locale;
  }

  @Override
  public String lookup(String key) {
    return messageSource.getMessage(key, null, locale);
  }
}
