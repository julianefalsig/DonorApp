package launch;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main  {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = System.getenv("DonorApp2");
        port = port != null ? port : "8080";

        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector();
       // tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());

        // Tilføj webapp-mappen
        Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());

        // Tilføj Jersey ServletContainer
        Wrapper jerseyServlet = tomcat.addServlet("", "jersey-container-servlet", "org.glassfish.jersey.servlet.ServletContainer");
        jerseyServlet.addInitParameter("jersey.config.server.provider.packages", "service");  // Pakke hvor dine ressourcer findes
        jerseyServlet.setLoadOnStartup(1);
        jerseyServlet.addMapping("/api/*");  // Map REST endpoints til /api/


        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}

