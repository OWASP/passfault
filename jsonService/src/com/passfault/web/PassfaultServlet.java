package com.passfault.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.passfault.ParallelFinder;
import com.passfault.PasswordAnalysis;
import com.passfault.PathCost;
import com.passfault.SecureString;
import com.passfault.io.JsonWriter;

/**
 * Servlet implementation class PassfaultServlet
 */
public class PassfaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PROTECTION_TYPE = "PROTECTION_TYPE";
	public static final String ATTACK_PROFILE = "ATTACK_PROFILE";
	private ParallelFinder finders;
	private String defaultAttackProfile;
	private String defaultProtectionType;
	private JsonWriter jsonWriter = new JsonWriter();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassfaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			finders = BuildFinders.build(config.getServletContext());
			defaultAttackProfile = config.getInitParameter(ATTACK_PROFILE);
			defaultProtectionType = config.getInitParameter(PROTECTION_TYPE);
		} catch (IOException e) {
			throw new ServletException("Could not configure password finders", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getContentLength()<=0){
			printUsage(response);
		}
		SecureString password = getPassword(request.getReader(), request.getContentLength());
		String protectionType = request.getParameter(PROTECTION_TYPE);
		String attackProfile = request.getParameter(ATTACK_PROFILE);
		try{
			PasswordAnalysis analysis = new PasswordAnalysis(password);
			try {
				finders.analyze(analysis);
				finders.waitForAnalysis(analysis);
			} catch (Exception e) {
				// TODO LOG exception
				throw new ServletException(e); 
			}
			writeJSON(analysis, response.getWriter());
		} finally{
			password.clear();
			response.getWriter().flush();
		}
	}

	private void printUsage(HttpServletResponse response) {
		//todo
	}

	/**
	 * @throws ServletException if a non-printable character is found
	 */
	private SecureString getPassword(BufferedReader reader, int length) throws IOException, ServletException {
		char[] chars = new char[length];
		int i;
		for(i=0; i<length; i++){
			char ch = (char) reader.read();
			if (Character.isISOControl(ch)){
				throw new ServletException("A non-printable character found in the supplied password.");
			} else {
				chars[i]=ch;
			}
		}
		if(i==0){
			throw new ServletException("No password found");
		}	
		SecureString password = new SecureString(chars, 0, i);
		Arrays.fill(chars, '0');
		return password;
	}

	public void writeJSON(PasswordAnalysis analysis, PrintWriter writer) throws IOException {
		jsonWriter.write(writer, analysis.calculateHighestProbablePatterns());
	}

	public void writeXML(PasswordAnalysis analysis, PrintWriter writer) {
		
	}

}
