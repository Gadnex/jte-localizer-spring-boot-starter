package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

/** Spring Boot AutoConfiguration class */
@AutoConfiguration
@EnableConfigurationProperties(JteProperties.class)
public class JteLocalizerAutoConfiguration {

  private final JteProperties jteProperties;
  private final MessageSource messageSource;

  /**
   * Constructor
   *
   * @param jteProperties JTE properties configuration class
   * @param messageSource Spring Boot MessageSource for localization
   */
  public JteLocalizerAutoConfiguration(JteProperties jteProperties, MessageSource messageSource) {
    this.jteProperties = jteProperties;
    this.messageSource = messageSource;
  }

  /**
   * WebMvcConfigurer bean to register ModelLocalizationInterceptor
   *
   * @return WebConfig
   */
  @Bean
  @ConditionalOnMissingBean
  public WebConfig webConfig() {
    if (jteProperties.isInject()) {
      return new WebConfig(modelLocalizationInterceptor());
    }
    return null;
  }

  private ModelLocalizationInterceptor modelLocalizationInterceptor() {
    if (jteProperties.isInject()) {
      return new ModelLocalizationInterceptor(localizationSupport());
    }
    return null;
  }

  private LocalizationSupport localizationSupport() {
    if (jteProperties.isInject()) {
      return new SpringLocalizationSupport(messageSource);
    }
    return null;
  }
}
