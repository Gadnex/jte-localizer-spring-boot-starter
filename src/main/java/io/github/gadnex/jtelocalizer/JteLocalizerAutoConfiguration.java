package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.annotation.RequestScope;

/** Spring Boot AutoConfiguration class */
@AutoConfiguration
@EnableConfigurationProperties(JteProperties.class)
public class JteLocalizerAutoConfiguration {

  private final JteProperties jteProperties;
  private final MessageSource messageSource;

  /**
   * Constructor
   *
   * @param jteProperties JTe properties configuration class
   * @param messageSource Spring Boot MessageSource for localization
   */
  public JteLocalizerAutoConfiguration(JteProperties jteProperties, MessageSource messageSource) {
    this.jteProperties = jteProperties;
    this.messageSource = messageSource;
  }

  /**
   * Request scoped LocalizationSupport bean
   *
   * @return LocalizationSupport
   */
  @Bean
  @RequestScope
  public LocalizationSupport localizationSupport() {
    if (jteProperties.isInject()) {
      return new SpringLocalizationSupport(messageSource, LocaleContextHolder.getLocale());
    }
    return null;
  }

  /**
   * HandlerInterceptor bean
   *
   * @return ModelLocalizationInterceptor
   */
  @Bean
  public ModelLocalizationInterceptor modelLocalizationInterceptor() {
    if (jteProperties.isInject()) {
      return new ModelLocalizationInterceptor(localizationSupport());
    }
    return null;
  }

  /**
   * WebMvcConfigurer bean to register ModelLocalizationInterceptor
   *
   * @return WebConfig
   */
  @Bean
  public WebConfig webConfig() {
    if (jteProperties.isInject()) {
      return new WebConfig(modelLocalizationInterceptor());
    }
    return null;
  }
}
