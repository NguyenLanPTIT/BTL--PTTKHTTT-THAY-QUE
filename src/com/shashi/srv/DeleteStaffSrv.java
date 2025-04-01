package com.shashi.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shashi.service.UserService;
import com.shashi.service.impl.UserServiceImpl;
/**
 * Servlet implementation class DeleteStaffSrv
 */
@WebServlet("/DeleteStaffSrv")
public class DeleteStaffSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStaffSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy tham số email từ form
        String email = request.getParameter("email");

        // Tạo một đối tượng của UserService
        UserService userService = new UserServiceImpl();

        // Thực hiện xóa nhân viên
        boolean isDeleted = userService.deleteStaff(email);

        if (isDeleted) {
            // Xóa thành công - Chuyển hướng về trang danh sách nhân viên
            response.sendRedirect("lstStaffToDelete.jsp?status=success");
        } else {
            // Xóa thất bại - Chuyển hướng về trang danh sách nhân viên với thông báo lỗi
            response.sendRedirect("lstStaffToDelete.jsp?status=failed");
        }
    }

}
