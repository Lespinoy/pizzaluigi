package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.PizzaRepository;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/pizzas.htm")
public class PizzasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
	private static final String PIZZA_REQUEST = "pizzaRequests";
	private final PizzaRepository pizzaRepository = new PizzaRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		((AtomicInteger) this.getServletContext().getAttribute(PIZZA_REQUEST)).incrementAndGet();
		request.setAttribute("pizzas", pizzaRepository.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	public void init() throws ServletException{
		this.getServletContext().setAttribute(PIZZA_REQUEST, new AtomicInteger());
	}
}
