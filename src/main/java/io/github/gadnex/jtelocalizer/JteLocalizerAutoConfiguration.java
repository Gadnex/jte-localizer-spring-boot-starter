package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
   * Request scoped LocalizationSupport bean
   *
   * @return LocalizationSupport
   */
  @Bean
  @ConditionalOnProperty(prefix = "gg.jte.localizer", name = "inject", havingValue = "true")
  public LocalizationSupport localizationSupport() {
    return new SpringLocalizationSupport(messageSource);
  }

  /**
   * HandlerInterceptor bean
   *
   * @return ModelLocalizationInterceptor
   */
  @Bean
  @ConditionalOnProperty(prefix = "gg.jte.localizer", name = "inject", havingValue = "true")
  public ModelLocalizationInterceptor modelLocalizationInterceptor() {
    return new ModelLocalizationInterceptor(localizationSupport());
  }

  /**
   * WebMvcConfigurer bean to register ModelLocalizationInterceptor
   *
   * @return WebConfig
   */
  @Bean
  @ConditionalOnProperty(prefix = "gg.jte.localizer", name = "inject", havingValue = "true")
  public WebConfig webConfig() {
    return new WebConfig(modelLocalizationInterceptor());
  }
}
