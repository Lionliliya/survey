package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lionliliya on 01.09.15.
 */
@WebServlet(name = "Survey", urlPatterns = "{/survey}")
public class Mainpage extends HttpServlet {


    private static SurveyData surveyInfo = new SurveyData();
    private Statistics statistics = Statistics.getInstance();


        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setCharacterEncoding("UTF-8");

            String temp = req.getParameter("name");
                if (temp!=null) {
                    surveyInfo.setName(temp);
                } else surveyInfo.setName("Без имени");
                temp=req.getParameter("age");
                if (temp!=null) {
                    surveyInfo.setAge(temp);
                } else surveyInfo.setName("0");
                temp=req.getParameter("gender");
                surveyInfo.setGender(temp);
                temp=req.getParameter("expert");
                surveyInfo.setExpert(temp);


            statistics.addData(surveyInfo);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Calculate.jsp");
            dispatcher.forward(req, resp);


        }


    }

