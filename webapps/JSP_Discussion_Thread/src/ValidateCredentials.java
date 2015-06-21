

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCredentials
 */
@WebServlet("/ValidateCredentials")
public class ValidateCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCredentials() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		
		//BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.txt", true));
		//writer.write("Igor\nIgor\n");
		//writer.close();
		
		BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
        String user_name = reader.readLine();
        String pass = reader.readLine();
        reader.close();
		
		if(username.equals(user_name) && password.equals(pass)) {
			BufferedReader posts_reader = new BufferedReader(new FileReader("posts.txt"));
			List<String> posts = new ArrayList<String>();
			String line;
			
			while ((line = posts_reader.readLine()) != null) {
				posts.add(line);
			}
			
			posts_reader.close();
			
			request.setAttribute("posts", posts);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/enter_new_post.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/invalid_login.jsp").forward(request, response);
		}
	}

}
