package com.room.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.room.sample.view.Customer;
import com.room.sample.view.ValidateInput;

public class InsertCustomerServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;


    public void doPost(HttpServletRequest request, HttpServletResponse response){

        System.out.println("----- InsertCustomerServlet -----");

        try {

        // Get the customer value submitted from Customer.jsp page through HttpServletRequest object
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            String mobile=request.getParameter("mobile");
            String emailid=request.getParameter("emailid");
            
            ValidateInput objValidatInput = new ValidateInput();
            
            String status = objValidatInput.ValidatePage(emailid,mobile);
            
            //Set the Customer values into Customer Bean or POJO(Plain Old Java Object) class
            Customer customer=new Customer();
            customer.setName(name);
            customer.setAddress(address);
            customer.setMobile(Long.valueOf(mobile));
            customer.setEmailid(emailid);
            
            if (status.equals("Success"))
            {
            RequestDispatcher dispatcher=request.getRequestDispatcher("/Welcome.jsp");

            //Set the customer instance into request.Then only the customer object 

            //will be available in the Welcome.jsp page

            request.setAttribute("cust",customer);
            dispatcher.forward(request, response);
            }
            else
            {
            	PrintWriter out = response.getWriter(); 
            	out.println("<html><body onload=\"alert('Check Your Inputs and submit again')\"></body></html>");
            }

        } catch (ServletException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}






