package com.swufe.javaee.jsp;

import com.swufe.javaee.jsp.model.User;

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
    private Map<String, List<String>> userHobby;

    @Override
    public void init() {
       userHobby = new HashMap<>();

       List<String> bob = new ArrayList<>();
       bob.add("skiing");
       bob.add("knitting");
       userHobby.put("Bob", bob);

       List<String> jim = new ArrayList<>();
       jim.add("skiing");
       jim.add("dating");
       userHobby.put("Jim", jim);

       List<String> james = new ArrayList<>();
       james.add("knitting");
       userHobby.put("James", james);

       List<String> tom = new ArrayList<>();
       tom.add("knitting");
       userHobby.put("Tom", tom);

       List<String> fei = new ArrayList<>();
       fei.add("scuba");
       userHobby.put("Fei", fei);

       List<String> jone = new ArrayList<>();
       jone.add("scuba");
       userHobby.put("Jone", jone);

       List<String> fred = new ArrayList<>();
       fred.add("dating");
       userHobby.put("Fred", fred);

       List<String> pradeep = new ArrayList<>();
       pradeep.add("dating");
       userHobby.put("Pradeep", pradeep);

       List<String> philippe = new ArrayList<>();
       philippe.add("dating");
       userHobby.put("Philippe", philippe);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hobby = request.getParameter("hobby");
        List<String> names = new ArrayList<>();
        userHobby.forEach((k, v) -> {
            v.forEach(item -> {
                if (item.equals(hobby)) {
                    names.add(k);
                }
            });
        });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
         request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       //request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
