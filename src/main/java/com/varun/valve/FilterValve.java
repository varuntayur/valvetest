package com.varun.valve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

public class FilterValve extends ValveBase {

	private static final String GOOG_URL = "https://google.com";

	@Override
	public void invoke(Request request, Response response) throws IOException,
			ServletException {

		System.out.print(String.format("Request %s Response %s", request,
				response));

		if (GOOG_URL.equals(request.getContextPath())) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("https://india.google.com");
			dispatcher.forward(request, response);
		}
		getNext().invoke(request, response);
	}
}