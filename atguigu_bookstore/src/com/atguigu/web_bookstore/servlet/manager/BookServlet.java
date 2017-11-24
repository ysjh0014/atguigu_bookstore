package com.atguigu.web_bookstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web_bookstore.bean.Book;
import com.atguigu.web_bookstore.bean.Category;
import com.atguigu.web_bookstore.factory.BeanFactory;
import com.atguigu.web_bookstore.service.BookService;
import com.atguigu.web_bookstore.service.CategoryService;
import com.atguigu.web_bookstore.servlet.BaseServlet;
import com.atguigu.web_bookstore.util.TransacationProxyUtils;
import com.atguigu.web_bookstore.util.WebUtils;

/**
 * 后台图书相关操作
 * 0. 进入图书添加页面 
 * 1. 添加图书 
 * 2. 查看所有图书列表 
 * 3. 查看某本图书详情 
 * 4. 删除某本图书 
 * 5. 进入更新界面 
 * 6. 更新某本图书
 * 
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = TransacationProxyUtils.getProxy(BeanFactory.get(BookService.class));
	private CategoryService categoryService = TransacationProxyUtils.getProxy(BeanFactory.get(CategoryService.class));

	public void toAddUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("BookServlet toAddUI()");

		List<Category> allCategorys = categoryService.getAllCategorys();
		WebUtils.forword(req, resp, "/manager/book/add.jsp", "allCategorys", allCategorys);
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookServlet add()");

		Book book = WebUtils.uploadBook(req);
	
		bookService.addBook(book);
		
		WebUtils.forwordMessageUI(req, resp, "添加图书成功!");
	}

	public void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("BookServlet listAll()");

		List<Book> list = bookService.getAllBooks();
		WebUtils.forword(req, resp, "/manager/book/list.jsp", "list", list);
	}

	public void showBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("BookServlet showBook()");

		String id = req.getParameter("bookid");
		Book book = bookService.getBookById(id);
		WebUtils.forword(req, resp, "/manager/book/book.jsp", "book", book);
	}

	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookServlet delete()");

		String id = req.getParameter("bookid");
		bookService.deleteBookById(id);
		WebUtils.forwordMessageUI(req, resp, "删除图书成功!");
	}

	public void toUpdateUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("BookServlet toUpdateUI()");

		String bookid = req.getParameter("bookid");

		List<Category> allCategorys = categoryService.getAllCategorys();
		Book book = bookService.getBookById(bookid);

		req.setAttribute("allCategorys", allCategorys);
		req.setAttribute("book", book);
		req.getRequestDispatcher("/manager/book/update.jsp").forward(req, resp);
		;

	}

	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookServlet update()");

		Book book = WebUtils.request2Bean(req, Book.class);
		bookService.updateBook(book);
		WebUtils.forwordMessageUI(req, resp, "更新图书成功!");
	}
}
