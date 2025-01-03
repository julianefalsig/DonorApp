package launch;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import java.io.File;

public class Main  {
    public static void main(String[] args) {
        //Testing that we have DB connections
       /*
       DonorService donorService = new DonorService();

        List<String> donorFirstNames = donorService.getAllDonors();
        if (donorFirstNames != null && !donorFirstNames.isEmpty()) {
            donorFirstNames.forEach(System.out::println);  //Printing all donornames to the DB
        } else {
            System.out.println("No donors found or donor service returned null.");
        }
        */

        //Local server setup
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = System.getenv("port");
        port = port != null ? port : "8082"; // Når vi kører lokal server kører vi på 8082

        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector();
       // tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());

        // Tilføj webapp-mappen
        Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());

        // Tilføj Jersey ServletContainer
        Wrapper jerseyServlet = tomcat.addServlet("", "jersey-container-servlet", "org.glassfish.jersey.servlet.ServletContainer");
        jerseyServlet.addInitParameter("jersey.config.server.provider.packages", "business");  // Pakke hvor dine ressourcer findes
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

