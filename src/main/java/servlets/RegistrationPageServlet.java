package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("registration")
public class RegistrationPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = new User();
        String email = req.getParameter("email");
//        user.setEmail(email);

        String rawPassword = req.getParameter("password");
        // TODO: RegistrationPageServlet includes UserService
        // TODO: UserService includes EncryptionService & UserRepository
//        byte[] password = user.getPassword().getBytes(StandardCharsets.UTF_8);
//        byte[] encryptedPassword = encryptor.encrypt(password);

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String country = req.getParameter("country");

        // TODO: response as JSP
    }
}
