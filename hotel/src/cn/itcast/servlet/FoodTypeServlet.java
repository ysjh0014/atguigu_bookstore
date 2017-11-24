package cn.itcast.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodTypeService;

/**
 * 4. ��ϵ����Servlet����
 * 
 * a. ��Ӳ�ϵ 
 * b. ��ϵ�б�չʾ
 * c. �������ҳ��
 * d. ɾ��
 * e. ����
 * 
 * @author Jie.Yuan
 * 
 */
public class FoodTypeServlet extends HttpServlet {
	
	// ���õĲ�ϵService
	private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService",IFoodTypeService.class);
	// ��ת��Դ
	private Object uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// ��ȡ����������
		String method = request.getParameter("method");
		// �ж�
		if ("addFoodType".equals(method)) {
			// ���
			addFoodType(request, response);
		}

		else if ("list".equals(method)) {
			// �б�չʾ
			list(request, response);
		}
		
		else if ("viewUpdate".equals(method)) {
			// �������ҳ��
			viewUpdate(request, response);
		}
		
		else if ("delete".equals(method)) {
			// ɾ��
			delete(request, response);
		}
		
		else if ("update".equals(method)) {
			// ����
			update(request, response);
		}
	}
	
	//a. ��Ӳ�ϵ
	public void addFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// 1. ��ȡ�������ݷ�װ
			String foodTypeName = request.getParameter("foodTypeName");
			FoodType ft = new FoodType();
			ft.setTypeName(foodTypeName);
			
			// 2. ����service����ҵ���߼�
			foodTypeService.save(ft);
			
			// 3. ��ת
			uri = request.getRequestDispatcher("/foodType?method=list");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
			
		
	}

	//b. ��ϵ�б�չʾ
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// ����Service��ѯ���е����
			List<FoodType> list = foodTypeService.getAll();
			// ����
			request.setAttribute("listFoodType", list);
			// ��ת�Ĳ�ϵ�б�ҳ��
			uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// ��ת
		goTo(request, response, uri);
	}

	//c. �������ҳ��
	public void viewUpdate(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			// 1. ��ȡ����id
			String id = request.getParameter("id");
			// 2. ����id��ѯ����
			FoodType ft = foodTypeService.findById(Integer.parseInt(id));
			// 3. ����
			request.setAttribute("foodType", ft);
			// 4. ��ת
			uri = request.getRequestDispatcher("/sys/type/foodtype_update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
	}
	
	//d. ɾ��
	public void delete(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		try {
			// 1. ��ȡ����id
			String id = request.getParameter("id");
			// 2. ����Service
			foodTypeService.delete(Integer.parseInt(id));
			// 3. ��ת
			uri = "/foodType?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
	}
	
	// e. ����
	public void update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		try {
			//1. ��ȡ�������ݷ�װ
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("foodTypeName");
			FoodType foodType = new FoodType();
			foodType.setId(id);
			foodType.setTypeName(name);
			
			//2. ����Service����
			foodTypeService.update(foodType);
			//3. ��ת
			//list(request,response);
			uri = "/foodType?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// ��ת
		goTo(request, response, uri);
	}

	/**
	 * ��ת��ͨ�÷���
	 */
	private void goTo(HttpServletRequest request, HttpServletResponse response, Object uri)
			throws ServletException, IOException {
		if (uri instanceof RequestDispatcher){
			((RequestDispatcher)uri).forward(request, response);
		} else if (uri instanceof String) {
			response.sendRedirect(request.getContextPath() + uri);
		} 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}











