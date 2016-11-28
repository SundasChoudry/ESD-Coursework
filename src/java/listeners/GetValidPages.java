package listeners;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 * @author Nate
 */
public class GetValidPages implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        ServletContext context = event.getServletContext();
        String fileName = "resources/ValidPages.txt";
        String line;
        HashMap<String, String> validPages = new HashMap<>();
        
        //Get file as input stream
        InputStream inputStream = event.getServletContext().getResourceAsStream(fileName);
 
        try {
            //Read file at specified path
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine()) != null) {
                
                //Get the request and the resource to forward to and add to the list
                validPages.put(line.split(",")[0], line.split(",")[1]);            
            }

            //Close
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        
        //Set to a context attribute
        context.setAttribute("ValidPages", validPages);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
