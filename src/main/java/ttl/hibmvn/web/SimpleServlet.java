package ttl.hibmvn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ttl.hibmvn.domain.User;
import ttl.hibmvn.utils.HibernateUtils;

@WebServlet("/users")
public class SimpleServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		PrintWriter out = response.getWriter();
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		try {
			int id = -1;
			if (idStr != null) {
				try {
					id = Integer.parseInt(idStr);
				} catch (NumberFormatException nfe) {
					out.println("Bad id:" + id);
					return;
				}

				User user = (User) session.get(User.class, id);
				if (user == null) {
					out.println("No user with id: " + id);
					return;
				}
				out.println(user);
				return;
			} else {
				Query<User> query = session.createQuery("from User", User.class);
				List<User> users = query.getResultList();
				out.println(users);

			}
		} finally {
			session.getTransaction().commit();
			out.close();
			session.close();
		}
	}

}
