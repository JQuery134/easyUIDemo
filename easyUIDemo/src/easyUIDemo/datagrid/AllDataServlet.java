package easyUIDemo.datagrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import easyUIDemo.bean.Page;
import easyUIDemo.bean.Person;
import utils.DBUtils;


public class AllDataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		Gson son = new Gson();
		PrintWriter write = null;
		Connection conn = null;
		PreparedStatement stateMent = null;
		ResultSet resultSet = null;
		try {
			resp.setContentType("application/json; charset=UTF-8"); 
			//获取前端当前页数和每页显示的数量
			BufferedReader reader = req.getReader();
			StringBuffer jsonParams=new StringBuffer();
			String strLine=null;
			while((strLine=reader.readLine())!=null){
				jsonParams.append(strLine);
			}
			//解析jsonParams字符串
			Page pageIns=son.fromJson(jsonParams.toString(), Page.class);
			int page=pageIns.getPageindex();//当前页
			int rows=pageIns.getPageSize();//每页的数量
			int offset=(page-1)*rows;
			conn = DBUtils.getConnection();
			String query_iwelanTable = "select * from iwelan_table limit ?,?";
			stateMent = conn.prepareStatement(query_iwelanTable);
			stateMent.setInt(1, offset);
			stateMent.setInt(2, rows);
			resultSet = stateMent.executeQuery();
			Person person = null;
			ArrayList<Person> dataList = new ArrayList<Person>();
			while (resultSet.next()) {
				person = new Person();
				person.setNum(resultSet.getString(1));
				person.setName(resultSet.getString(2));
				person.setSex(resultSet.getString(3));
				person.setAge(resultSet.getString(4));
				person.setIdcard(resultSet.getString(5));
				person.setPhone(resultSet.getString(6));
				person.setAddress(resultSet.getString(7));
				person.setEmail(resultSet.getString(8));
				person.setTime(resultSet.getString(9));
				person.setImg_path(resultSet.getString(10));
				person.setFinalCode(resultSet.getString(16));
				dataList.add(person);
			}
			//将Person按num进行排序
			Comparator<Person> comparator=new Comparator<Person>() {
				@Override
				public int compare(Person p1, Person p2) {
					// TODO Auto-generated method stub
					return Integer.valueOf(p2.getNum())-Integer.valueOf(p1.getNum());
				}
				
			};
			Collections.sort(dataList, comparator);
			//数据库中数据的总数,为total赋值
			String countStr="select count(*) as result from iwelan_table";
			stateMent=conn.prepareStatement(countStr);
			resultSet=stateMent.executeQuery();
			int total=0;
			while(resultSet.next()){
				total=resultSet.getInt(1);
			}
			Map<String,Integer> totalMap=new HashMap<String,Integer>();
			Map<String,Object> resMap=new HashMap<String,Object>();
			resMap.put("total", total);
			resMap.put("rows", dataList);
			String resultStr=son.toJson(resMap);
			write = resp.getWriter();
			write.print(resultStr);
			write.flush();
			write.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stateMent.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

