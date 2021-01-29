package com.mecury.final_project_server.security.handler;

import com.mecury.final_project_server.bean.User;
import com.mecury.final_project_server.security.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SecurityUtils.sendAuthenticationSuccessResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null, (User)authentication.getPrincipal());
	}

}
