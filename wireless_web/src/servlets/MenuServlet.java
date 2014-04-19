package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import dao.MenutblDao;
import dao.UsertblDao;
import dao.impl.MenutblDaoImpl;
import entity.Menutbl;

public class MenuServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
//		name="中文乱码";
		String pic = request.getParameter("pic");
		String price_temp = request.getParameter("price");
		int price = (new java.lang.Integer(price_temp)).intValue();
//		int price=Integer.parseInt(price_temp);
		String remark = request.getParameter("remark");
		Menutbl menuer = new Menutbl();
		menuer.setName(name);
		menuer.setPic(pic);
	//	menuer.setId(15);
		menuer.setPrice(price);
		menuer.setTypeId(2);
		menuer.setRemark(remark);
		
//		user.setPassword(pwd);
// 	   user.setPermission(2);
		
		MenutblDao menutblDao = new MenutblDaoImpl();
		menutblDao.save(menuer);
		JSONObject json = null;
		
		json = new JSONObject();
		json.put("success","添加成功!");
		
		out.print(json);
	}

}
