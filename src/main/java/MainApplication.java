import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.LoggerFactory;

public class MainApplication {

    private static final int TOMCAT_PORT = 8080;
    private static final ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        final Tomcat tomcat = new Tomcat();
        tomcat.setPort(TOMCAT_PORT);

        tomcat.getConnector();
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            logger.error("Something went wrong during tomcat running");
        }
        tomcat.getServer().await();
    }
}