package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/** Class implementing the LocalizationSupport interface provided by JTE */
public class SpringLocalizationSupport implements LocalizationSupport {

  private final MessageSource messageSource;

  /**
   * Constructor
   *
   * @param messageSource The Spring Boot MessageSource
   */
  public SpringLocalizationSupport(final MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @Override
  public String lookup(String key) {
    return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
  }
}
