package io.github.gadnex.jtelocalizer;

import gg.jte.support.LocalizationSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** HandlerInterceptor to insert localizer into modelAndView */
public class ModelLocalizationInterceptor implements HandlerInterceptor {

  private final LocalizationSupport localizer;

  /**
   * Constructor
   *
   * @param localizer The localizer
   */
  public ModelLocalizationInterceptor(final LocalizationSupport localizer) {
    this.localizer = localizer;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    if (modelAndView != null) {
      modelAndView.addObject("localizer", localizer);
    }
  }
}
