package com.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogCommand {
	void logInter(HttpServletRequest req, HttpServletResponse resp);
}
