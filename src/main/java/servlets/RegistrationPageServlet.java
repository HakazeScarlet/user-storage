package servlets;

import encryptor.EncryptionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.User;
import user.UserService;

import java.io.IOException;

@WebServlet("registration")
public class RegistrationPageServlet extends HttpServlet {

    private final UserService userService;
    private final EncryptionService encryptionService;

    public RegistrationPageServlet(UserService userService, EncryptionService encryptionService) {
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String country = req.getParameter("country");
        String rawPassword = req.getParameter("password");

        String encryptedPassword = encryptionService.encrypt(rawPassword);
        User user = new User(email, name, surname, phone, country, encryptedPassword);

        userService.save(user);

        // TODO: response as JSP
    }
}
