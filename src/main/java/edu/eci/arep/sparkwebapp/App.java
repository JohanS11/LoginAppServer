package edu.eci.arep.sparkwebapp;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * This is a simple WebApplication deployed in Heroku using SparkWeb.
 * @author Johan Arias
 */
public class App 
{
    public static void main( String[] args )
    {
        port(getPort());
        secure("keystores/ecikeystore.p12", "arep123", "keystores/myTrustStore","arep123");
        get("/hello", App::inputDataPage);
    }

    /**
     * @param req This is the object that represents the HTTP request
     *            in order to retrieve a resource from the web server.
     * @param res This is the object that represents the HTTP response
     *            given by the webserver
     * @return A string with html code that will build the web page, in this case
     *          the resource located at /inputdata
     */
    private static String inputDataPage(Request req, Response res) {
        return "<h1> Hello My Friend, This is" +
                "the response from the other server <h1>";
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
