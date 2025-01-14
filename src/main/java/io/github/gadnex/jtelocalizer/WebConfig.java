package io.github.gadnex.jtelocalizer;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

  private final ModelLocalizationInterceptor modelLocalizationInterceptor;

  public WebConfig(ModelLocalizationInterceptor modelLocalizationInterceptor) {
    this.modelLocalizationInterceptor = modelLocalizationInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(modelLocalizationInterceptor);
  }
}
