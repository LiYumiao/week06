package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, String> userHobby;
    @Override
    public void init() {
       userHobby = new HashMap<>();
       userHobby.put("Bob", "skiing knitting scuba dating");
       userHobby.put("Jim", "skiing knitting dating");
       userHobby.put("James", "knitting skiing scuba");
       userHobby.put("Tom", "knitting");
       userHobby.put("Fei", "scuba");
       userHobby.put("Jone", "scuba");
       userHobby.put("Fred", "dating");
       userHobby.put("Pradeep", "dating");
       userHobby.put("Philippe", "dating");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.forEach((k, v) -> {
           String[] s = v.split("\\s");
           int i;
           for (i = 0; i < s.length; i++){
               if (s[i].equals(hobby)){
                   names.add(k);
               }
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
         request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       //request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
