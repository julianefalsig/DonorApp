package launch;
import business.services.DonorService;
import business.services.LoginService;
import data.HibernateController;
import data.entities.User;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.File;
import java.util.List;

public class Main  {
    public static void main(String[] args) {


        //Testing that the donorService is working
        DonorService donorService = new DonorService();
        LoginService ls = new LoginService();
        User user = new User();

        List<String> donorFirstNames = donorService.getAllDonors();
        if (donorFirstNames != null && !donorFirstNames.isEmpty()) {
            donorFirstNames.forEach(System.out::println);  // This will print to the terminal
        } else {
            System.out.println("No donors found or donor service returned null.");
        }


        System.out.println(user = ls.validateUser("niko", "kodeord"));



    /*
        //Testing result of query
        SubStepService subStepService = new SubStepService();
        List<DonorQualificationSubStepDTO> ldqssDTO;
        ldqssDTO = subStepService.getSubStepsOnId(303);
        for (DonorQualificationSubStepDTO d :ldqssDTO){
            System.out.println(d.toString());
        }
    */
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

