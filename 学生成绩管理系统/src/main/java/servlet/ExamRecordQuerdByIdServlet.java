package servlet;

import dao.ExamRecordDAO;
import model.ExamRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/queryById")
public class ExamRecordQuerdByIdServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        ExamRecord record = ExamRecordDAO.queryById(Integer.parseInt(id));
        return record;
    }
}
