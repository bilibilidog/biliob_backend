package com.jannchie.biliob.authority;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jannchie
 */
public class MyRolesAuthorizationFilter extends RolesAuthorizationFilter {
  /**
   * 在访问过来的时候检测是否为OPTIONS请求，如果是就直接返回true
   */
  @Override
  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    return httpRequest.getMethod().equals(RequestMethod.OPTIONS.name()) || super.preHandle(request, response);
  }
}