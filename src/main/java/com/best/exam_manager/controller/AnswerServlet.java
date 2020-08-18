package com.best.exam_manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.best.exam_manager.dao.ExamDao;
import com.best.exam_manager.model.Answer;
import com.best.exam_manager.model.Question;

/**
 * Servlet implementation class AnswerServlet
 */
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	final private ExamDao examDao;
    public AnswerServlet() {
        super();
        this.examDao= new ExamDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action")!=null) {
			String action=request.getParameter("action");
			if(action.equalsIgnoreCase("new")) {
				RequestDispatcher rd=request.getRequestDispatcher("new_answer.jsp");
				request.setAttribute("questions",examDao.getQuestionList());
				rd.forward(request, response);
			}else if(action.equalsIgnoreCase("save")) {
				String name=request.getParameter("name");
				
				Integer question_id=Integer.parseInt(request.getParameter("question_id"));
				int mark=Integer.parseInt(request.getParameter("mark"));
				Answer ans=new Answer();
				ans.setName(name);
				Question q=examDao.getQuestionById(question_id);
				ans.setQuestion(q);
				ans.setMark(mark);
				examDao.saveAnswer(ans);
				RequestDispatcher rd=request.getRequestDispatcher("new_answer.jsp");
				request.setAttribute("answers",examDao.getAnswerList());
				rd.forward(request, response);
			}
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("answer_list.jsp");
			request.setAttribute("answers",examDao.getAnswerList());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
