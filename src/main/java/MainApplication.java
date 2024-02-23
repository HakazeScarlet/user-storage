import encryptor.EncryptionService;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import servlets.RegistrationPageServlet;
import user.UserRepository;
import user.UserService;

import java.io.File;

public class MainApplication {

    private static final String REGISTRATION_PAGE_SERVLET_NAME = "RegistrationPage";

    private static final String WEBAPP_DIR_LOCATION = "src/main/webapp/";
    private static final int TOMCAT_PORT = 8080;

    public MainApplication() {
    }
//    private static final ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(TOMCAT_PORT);

        Context context = tomcat.addWebapp("", new File(WEBAPP_DIR_LOCATION).getAbsolutePath());

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        EncryptionService encryptionService = new EncryptionService();

        RegistrationPageServlet registrationPageServlet = new RegistrationPageServlet(userService, encryptionService);

        tomcat.addServlet(context.getPath(), REGISTRATION_PAGE_SERVLET_NAME, registrationPageServlet);
        context.addServletMappingDecoded("/registration", REGISTRATION_PAGE_SERVLET_NAME);

        tomcat.getConnector();
        try {
            tomcat.start();
        } catch (LifecycleException e) {
//            logger.error("Something went wrong during tomcat running");
        }
        tomcat.getServer().await();
    }
}