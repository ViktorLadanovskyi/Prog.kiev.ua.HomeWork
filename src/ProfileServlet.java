import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
    private static AtomicInteger male = new AtomicInteger();
    private static AtomicInteger female = new AtomicInteger();
    private static AtomicInteger english = new AtomicInteger();
    private static AtomicInteger ukrainian = new AtomicInteger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("Name");
        String lastName = request.getParameter("LastName");
        String age = request.getParameter("Age");
        String gender = request.getParameter("Gender");
        String language = request.getParameter("Language");

        if(name.equals("") || lastName.equals("") || age.equals("")) {
            response.sendRedirect("index.html");
            return;
        }

        try {
            if(gender.equals("Male"))
                male.incrementAndGet();
            else if (gender.equals("Female"))
                female.incrementAndGet();

            if(language.equals("English"))
                english.incrementAndGet();
            else if(language.equals("Ukrainian"))
                ukrainian.incrementAndGet();
        }catch (NullPointerException ex){
            response.sendRedirect("index.html");
            return;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("Name", name);
        session.setAttribute("LastName", lastName);
        session.setAttribute("Age", age);

        session.setAttribute("Male", male.toString());
        session.setAttribute("Female", female.toString());
        session.setAttribute("English", english.toString());
        session.setAttribute("Ukrainian", ukrainian.toString());

        response.sendRedirect("index.jsp");
    }
}
