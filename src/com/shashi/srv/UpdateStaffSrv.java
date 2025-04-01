package com.shashi.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shashi.service.*;
import com.shashi.service.impl.*;
import com.shashi.beans.UserBean;

/**
 * Servlet implementation class UpdateStaff
 */
@WebServlet("/UpdateStaffSrv")
public class UpdateStaffSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffSrv() {
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
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve parameters from the form
	        String email = request.getParameter("email");
	        String name = request.getParameter("name");
	        String mobileStr = request.getParameter("mobile");
	        String address = request.getParameter("address");
	        String pincodeStr = request.getParameter("pincode");
	        String password = request.getParameter("password");
	        String position = request.getParameter("position");

	        // Validate and parse inputs
	        long mobile = 0;
	        int pincode = 0;
	        try {
	            mobile = Long.parseLong(mobileStr);
	            pincode = Integer.parseInt(pincodeStr);
	        } catch (NumberFormatException e) {
	            request.setAttribute("error", "Invalid input for mobile or pincode.");
	            request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
	            return;
	        }

	        // Create UserBean object
	        UserBean user = new UserBean();
	        user.setEmail(email);
	        user.setName(name);
	        user.setMobile(mobile);
	        user.setAddress(address);
	        user.setPinCode(pincode);
	        user.setPassword(password);
	        user.setPosition(position);
	        user.setRole("staff"); // Ensuring role is 'staff'

	        // Update user using UserService
	        UserService userService = new UserServiceImpl();
	        boolean isUpdated = userService.updateStaff(user);

	        if (isUpdated) {
	            // Redirect to staff list with success message
	            request.setAttribute("success", "Staff information updated successfully.");
	            request.getRequestDispatcher("lstStaffToUpdate.jsp").forward(request, response);
	        } else {
	            // Show error message
	            request.setAttribute("error", "Failed to update staff information.");
	            request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
	        }
	    }

}
