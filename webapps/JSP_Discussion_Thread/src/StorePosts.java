

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StorePosts
 */
@WebServlet("/StorePosts")
public class StorePosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorePosts() {
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
		String post = request.getParameter("post"); 
		String username = request.getParameter("username"); 
		
		if(!post.isEmpty()){
			BufferedWriter writer = new BufferedWriter(new FileWriter("posts.txt", true));
			writer.write("<strong>Name: </strong>" + username + ", <strong>Date: </strong>" + new java.util.Date() + 
					", <strong>Post: </strong>" + post + "\n");
			writer.close();
		}
		
		BufferedReader posts_reader = new BufferedReader(new FileReader("posts.txt"));
		List<String> posts = new ArrayList<String>();
		String line;
		
		while ((line = posts_reader.readLine()) != null) {
			posts.add(line);
		}
		
		posts_reader.close();
        
		request.setAttribute("posts", posts);
		request.setAttribute("username", username);
		request.getRequestDispatcher("/view_posts.jsp").forward(request, response);
	}

}
