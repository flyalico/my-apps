package org.jrichardsz.examples.exportarfileweb.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileExport
 */
public class FileExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int BYTES_DOWNLOAD = 1024;

	/**
	 * Default constructor.
	 */
	public FileExport() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition",
				"attachment;filename=downloadname.txt");

		InputStream is = null;
		OutputStream os = null;
		try {

			is = new FileInputStream("R:\\TEMP\\filetoexport.txt");

			int read = 0;
			byte[] bytes = new byte[BYTES_DOWNLOAD];
			os = response.getOutputStream();

			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}

		} catch (Exception e) {
			
			PrintWriter out = response.getWriter();
			out.append("Lo sentimos, el documento no se ha podido generar. Por favor vuelva a intentar.");
			out.close();
			
		} finally {
			os.flush();
			os.close();
			is.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
