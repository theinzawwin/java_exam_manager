package com.best.exam_manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.best.exam_manager.dao.ExamDao;
import com.best.exam_manager.model.Question;

/**
 * Servlet implementation class QuestionServlet
 */
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	final private ExamDao examDao;
    public QuestionServlet() {
        // TODO Auto-generated constructor stub
    	this.examDao= new ExamDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action")!=null) {
			if(request.getParameter("action").equalsIgnoreCase("save")) {
				Question question=new Question();
				question.setName(request.getParameter("name"));
				examDao.saveQuestion(question);
				List<Question> qList=examDao.getQuestionList();
				RequestDispatcher rd=request.getRequestDispatcher("question_list.jsp");
				request.setAttribute("questions", qList);
				rd.forward(request, response);
				
			}else if(request.getParameter("action").equalsIgnoreCase("new")){
				RequestDispatcher rd=request.getRequestDispatcher("new_question.jsp");
				rd.forward(request, response);
			}
		}
		else {
			List<Question> qList=examDao.getQuestionList();
			RequestDispatcher rd=request.getRequestDispatcher("question_list.jsp");
			request.setAttribute("questions", qList);
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
