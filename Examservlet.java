package exam;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExamServlet")
public class Examservlet extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get student name
        String studentName =
                request.getParameter("studentName");
        
        // Get answers for all 25 questions
        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");
        String q3 = request.getParameter("q3");
        String q4 = request.getParameter("q4");
        String q5 = request.getParameter("q5");
        String q6 = request.getParameter("q6");
        String q7 = request.getParameter("q7");
        String q8 = request.getParameter("q8");
        String q9 = request.getParameter("q9");
        String q10 = request.getParameter("q10");
        String q11 = request.getParameter("q11");
        String q12 = request.getParameter("q12");
        String q13 = request.getParameter("q13");
        String q14 = request.getParameter("q14");
        String q15 = request.getParameter("q15");
        String q16 = request.getParameter("q16");
        String q17 = request.getParameter("q17");
        String q18 = request.getParameter("q18");
        String q19 = request.getParameter("q19");
        String q20 = request.getParameter("q20");
        String q21 = request.getParameter("q21");
        String q22 = request.getParameter("q22");
        String q23 = request.getParameter("q23");
        String q24 = request.getParameter("q24");
        String q25 = request.getParameter("q25");
        
        // Calculate score
        int score = 0;
        if ("B".equals(q1)) score++;
        if ("C".equals(q2)) score++;
        if ("A".equals(q3)) score++;
        if ("B".equals(q4)) score++;
        if ("A".equals(q5)) score++;
        if ("C".equals(q6)) score++;
        if ("B".equals(q7)) score++;
        if ("B".equals(q8)) score++;
        if ("A".equals(q9)) score++;
        if ("C".equals(q10)) score++;
        if ("B".equals(q11)) score++;
        if ("B".equals(q12)) score++;
        if ("C".equals(q13)) score++;
        if ("D".equals(q14)) score++;
        if ("B".equals(q15)) score++;
        if ("B".equals(q16)) score++;
        if ("B".equals(q17)) score++;
        if ("B".equals(q18)) score++;
        if ("B".equals(q19)) score++;
        if ("B".equals(q20)) score++;
        if ("A".equals(q21)) score++;
        if ("B".equals(q22)) score++;
        if ("D".equals(q23)) score++;
        if ("C".equals(q24)) score++;
        if ("B".equals(q25)) score++;
        
        // Calculate percentage
        double percentage =
                (score / 25.0) * 100;
        
        // Determine grade
        String grade;
        if (score >= 23) {
            grade = "A+";
        } else if (score >= 20) {
            grade = "A";
        } else if (score >= 18) {
            grade = "B+";
        } else if (score >= 15) {
            grade = "B";
        } else if (score >= 13) {
            grade = "C+";
        } else if (score >= 10) {
            grade = "C";
        } else if (score >= 8) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Save result into MySQL
        saveResult(
                studentName,
                score,
                percentage,
                grade
        );
        
        // Display result
        response.setContentType("text/html");
        PrintWriter out =
                response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Exam Result</title>");
        out.println("<style>");
        out.println(
            "* { margin: 0; padding: 0; box-sizing: border-box; } " +
            "body{" +
            "margin:0;" +
            "font-family:Arial, sans-serif;" +
            "background:linear-gradient(135deg,#4f46e5,#7c3aed);" +
            "display:flex;" +
            "justify-content:center;" +
            "align-items:center;" +
            "min-height:100vh;" +
            "padding: 20px;" +
            "}"
        );
        out.println(
            ".card{" +
            "background:white;" +
            "width:100%;" +
            "max-width:600px;" +
            "padding:40px;" +
            "border-radius:25px;" +
            "text-align:center;" +
            "box-shadow:0 20px 50px rgba(0,0,0,.25);" +
            "}"
        );
        out.println(
            ".icon{" +
            "font-size:80px;" +
            "margin-bottom: 20px;" +
            "}"
        );
        out.println(
            "h1{" +
            "color:#312e81;" +
            "margin-bottom: 10px;" +
            "}"
        );
        out.println(
            ".student-name{" +
            "color:#6366f1;" +
            "font-size: 20px;" +
            "margin-bottom: 30px;" +
            "}"
        );
        out.println(
            ".score{" +
            "font-size:60px;" +
            "font-weight:bold;" +
            "color:#6366f1;" +
            "margin:20px;" +
            "}"
        );
        out.println(
            ".score-label{" +
            "font-size: 14px;" +
            "color: #6b7280;" +
            "margin-bottom: 30px;" +
            "}"
        );
        out.println(
            ".box{" +
            "background:#f5f3ff;" +
            "padding:20px;" +
            "border-radius:15px;" +
            "margin:15px 0;" +
            "display: flex;" +
            "justify-content: space-between;" +
            "align-items: center;" +
            "}"
        );
        out.println(
            ".box-label{" +
            "font-weight: bold;" +
            "color: #4338ca;" +
            "}"
        );
        out.println(
            ".box-value{" +
            "font-size: 20px;" +
            "font-weight: bold;" +
            "color: #6366f1;" +
            "}"
        );
        out.println(
            ".grade-badge{" +
            "display: inline-block;" +
            "background: linear-gradient(135deg,#4f46e5,#7c3aed);" +
            "color: white;" +
            "padding: 10px 25px;" +
            "border-radius: 50px;" +
            "font-size: 20px;" +
            "font-weight: bold;" +
            "margin: 20px 0;" +
            "}"
        );
        out.println(
            ".btn{" +
            "display:inline-block;" +
            "padding:14px 30px;" +
            "background:#4f46e5;" +
            "color:white;" +
            "text-decoration:none;" +
            "border-radius:30px;" +
            "margin-top:30px;" +
            "border: none;" +
            "cursor: pointer;" +
            "font-size: 16px;" +
            "font-weight: bold;" +
            "transition: 0.3s;" +
            "}" +
            ".btn:hover{" +
            "background:#3b3ace;" +
            "transform: translateY(-2px);" +
            "}"
        );
        out.println(
            ".footer-text{" +
            "color: #9ca3af;" +
            "font-size: 12px;" +
            "margin-top: 30px;" +
            "}"
        );
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='card'>");
        
        // Display appropriate icon based on performance
        if (score >= 20) {
            out.println("<div class='icon'>🏆</div>");
        } else if (score >= 15) {
            out.println("<div class='icon'>⭐</div>");
        } else if (score >= 10) {
            out.println("<div class='icon'>👍</div>");
        } else {
            out.println("<div class='icon'>📚</div>");
        }
        
        out.println("<h1>Examination Completed!</h1>");
        out.println("<div class='student-name'>Candidate: " + studentName + "</div>");
        out.println("<div class='score'>" + score + " / 25</div>");
        out.println("<div class='score-label'>Questions Answered Correctly</div>");
        
        out.println("<div class='box'>");
        out.println("<span class='box-label'>Percentage:</span>");
        out.println("<span class='box-value'>" + String.format("%.2f", percentage) + "%</span>");
        out.println("</div>");
        
        out.println("<div class='box'>");
        out.println("<span class='box-label'>Grade:</span>");
        out.println("<span class='box-value'>" + grade + "</span>");
        out.println("</div>");
        
        out.println("<div class='grade-badge'>" + grade + "</div>");
        
        if (score >= 20) {
            out.println("<p style='color: #10b981; font-weight: bold;'>Excellent Performance! Keep it up! 🎉</p>");
        } else if (score >= 15) {
            out.println("<p style='color: #3b82f6; font-weight: bold;'>Good Job! You can do better next time!</p>");
        } else if (score >= 10) {
            out.println("<p style='color: #f59e0b; font-weight: bold;'>Average Performance. Practice more!</p>");
        } else {
            out.println("<p style='color: #ef4444; font-weight: bold;'>Poor Performance. Review the concepts!</p>");
        }
        
        out.println("<button class='btn' onclick=\"location.href='index.html'\">Take Exam Again 🔄</button>");
        out.println("<div class='footer-text'>© 2026 CodeMaster Online Examination</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    // DATABASE FUNCTION - Save exam result to MySQL
    private void saveResult(
            String studentName,
            int score,
            double percentage,
            String grade) {
        String sql =
            "INSERT INTO results " +
            "(student_name, score, percentage, grade, total_questions, attempt_date) " +
            "VALUES (?, ?, ?, ?, ?, NOW())";
        try {
            Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ps.setString(1, studentName);
            ps.setInt(2, score);
            ps.setDouble(3, percentage);
            ps.setString(4, grade);
            ps.setInt(5, 25);
            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println(
                "Result Saved Successfully!"
            );
        } catch (Exception e) {
            System.out.println(
                "Result Saving Failed!"
            );
            e.printStackTrace();
        }
    }
}
