
package servlet;
// Import Java Libraries
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

//Import Servlet Libraries
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "results", urlPatterns = {"/assignment8/results"} )
public class bathroomReviewResults extends HttpServlet {

// Location of servlet.
static String Domain  = "bathroomreview.herokuapp.com";

// Other strings.

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    PrintBody(out, request);
    PrintTail(out);
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
    //   RequestDispatcher view = request.getRequestDispatcher(indexpage);
    String building = request.getParameter("building");
    String cleanliness = request.getParameter("cleanliness");
    String odor = request.getParameter("odor");
    String wouldUseAgain = request.getParameter("wouldUseAgain");
    String userComments = request.getParameter("userComments");
    if(building != null) {
        try {
            File file = new File("allReviews.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            // Add the reviews here
            FileWriter myWriter = new FileWriter("allReviews.txt");
            myWriter.write(building + "," + cleanliness + "," + odor + "," + wouldUseAgain + "," + comments + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintBody(out, request);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, HttpServletRequest request)
{
    String building = request.getParameter("building");
    String cleanliness = request.getParameter("cleanliness");
    String odor = request.getParameter("odor");
    String wouldUseAgain = request.getParameter("wouldUseAgain");
    String userComments = request.getParameter("userComments");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<script src=\"https://unpkg.com/react@16.4.1/umd/react.production.min.js\"></script>");
    out.println("<script src=\"https://unpkg.com/react-dom@16.4.1/umd/react-dom.production.min.js\"></script>");
    out.println("<script src=\"https://unpkg.com/babel-standalone@6.15.0/babel.min.js\"></script>");

    out.println("<script src=\"js/react.development.min.js\"></script>");
    out.println("<script src=\"js/react-dom.development.min.js\"></script>");
    out.println("<script src=\"js/browser.min.js\"></script>");

//
    out.println("  <style type=\"text/css\">");
    out.println("  h1{");
    out.println("    text-align: center;");
    out.println("    font-size:3em;");
    out.println("  }");
    out.println("  h3{");
    out.println("  text-align: center;");
    out.println("    font-size:1.25em;");
    out.println("  }");
    out.println("  p{");
    out.println("    text-align: center;");
    out.println("    font-size:2em;");
    out.println("  }");
    out.println("  body{");
    out.println("      background-color: lightblue;");
    out.println("    padding-left: 10em;");
    out.println("    padding-right: 10em;");
    out.println("  }");
    out.println("   table, th, td {");
    out.println("       word-wrap: break-word;");
    out.println("       border: 1px solid black;");
    out.println("       padding: 10px;");
    out.println("       text-align: left;");
    out.println("       width: 100%;");
    out.println("       table-layout: fixed;");
    out.println("   }");
    out.println("   hr.rounded {");
    out.println("       border-top: 5px solid black;");
    out.println("       border-radius: 5px;");
    out.println("   }");
//    out.println("   td {");
//    out.println("       white-space:pre-line;");
//    out.println("   }");
    out.println("  </style>");
    out.println("</head>");
    out.println("");
//
    out.println("<script type=\"text/babel\">");
    out.println("const Hello = () => {");
    out.println("return (");
    out.println("<h1>GMU Bathroom Review Results</h1>");
    out.println(");");
    out.println("}");
    out.println("ReactDOM.render(<Hello/>, document.getElementById('root'));");
    out.println("</script>");
    out.println("<body>");
    out.println("");
    out.println("<div id=\"root\"></div>");
    out.println("");
    
    if(building != null) {
        out.println("<p>Review Results</p>");
        out.println("    <table text-align=\"left\" id=\"your-results\">");
        out.println("        <tr>");
        out.println("            <th>Building</th>");
        out.println("            <td>" + building + "</td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <th>Cleanliness</th>");
        out.println("            <td>" + cleanliness + "</td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <th>Odor</th>");
        out.println("            <td>" + odor + "</td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <th>Would you use this restroom again?</th>");
        out.println("            <td>" + wouldUseAgain + "</td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <th>Additional comments</th>");
        out.println("            <td>" + userComments + "</td>");
        out.println("        </tr>");
        out.println("   </table>");
        out.println("<br/><br/>");
    } else {
        out.println("<p>Click the button below to start a new review!</p>");
        out.println("<p>");
        out.println("<a href=\"https://bathroomreview.herokuapp.com/assignment8\"> <button>New review</button></a>");
        out.println("</p>");
    }
    out.println("<hr class=\"rounded\">");
    
    try {
        List<String> allLines = Files.readAllLines(Paths.get("allReviews.txt"));
        out.println("<p>Review Results</p>");
        for(String line: allLines) {
            ArrayList<String> tempList = new ArrayList<>(Arrays.asList(line.split(",")));
            out.println("    <table text-align=\"left\" id=\"your-results\">");
            out.println("        <tr>");
            out.println("            <th>Building</th>");
            out.println("            <td>" + tempList[0] + "</td>");
            out.println("        </tr>");
            out.println("        <tr>");
            out.println("            <th>Cleanliness</th>");
            out.println("            <td>" + tempList[1] + "</td>");
            out.println("        </tr>");
            out.println("        <tr>");
            out.println("            <th>Odor</th>");
            out.println("            <td>" + tempList[2] + "</td>");
            out.println("        </tr>");
            out.println("        <tr>");
            out.println("            <th>Would you use this restroom again?</th>");
            out.println("            <td>" + tempList[3] + "</td>");
            out.println("        </tr>");
            out.println("        <tr>");
            out.println("            <th>Additional comments</th>");
            out.println("            <td>" + tempList[4] + "</td>");
            out.println("        </tr>");
            out.println("   </table>");
            out.println("  <br/>");
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    out.println("  <br/><br/>");
    out.println("");
    out.println("</body>");
    out.println("</html>");

    
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
//private void PrintBody (PrintWriter out)
//{
//   PrintBody(out);
//}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End twoButtons
