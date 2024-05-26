import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // установить MIME-type и кодировку ответа
        response.setContentType("text/html; charset=UTF8");
        PrintWriter out = response.getWriter();

        // Отправка веб-страницы
        try {

            // считываю GET параметры из строки запроса
            String header = request.getParameter("header");
            int rows = Integer.parseInt(request.getParameter("rows"));
            int columns = Integer.parseInt(request.getParameter("columns"));
            String color = request.getParameter("color");

            out.println("<html>");
            out.println("<head><title>"+header+"</title></head>");
            out.println("<body>");
            out.println("<h1>" + header + "</h1>");

            // генерирую HTML таблицу
            out.println("<table style='background-color:"+color+";'>");
            for (int i=0; i < rows; i++) {
                out.println("<tr>");
                for (int j=0; j < columns; j++) {
                    out.println("<td>"+i+"/"+j+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");

            out.println("</body></html>");
        } finally {
            out.close();  // Всегда закрывать Writer
        }
    }
}