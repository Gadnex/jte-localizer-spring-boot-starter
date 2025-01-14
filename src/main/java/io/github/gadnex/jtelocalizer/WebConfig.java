package io.github.gadnex.jtelocalizer;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** WebMvcConfigurer to register HandlerInterceptor */
public class WebConfig implements WebMvcConfigurer {

  private final ModelLocalizationInterceptor modelLocalizationInterceptor;

  /**
   * Constructor
   *
   * @param modelLocalizationInterceptor The HandlerInterceptor to register
   */
  public WebConfig(ModelLocalizationInterceptor modelLocalizationInterceptor) {
    this.modelLocalizationInterceptor = modelLocalizationInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(modelLocalizationInterceptor);
  }
}
