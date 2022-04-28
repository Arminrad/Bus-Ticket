import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.CustomerService;

import java.io.IOException;

@WebServlet("/register")
public class BusTicketServlet extends HttpServlet {
    CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register(request,response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String fullName = request.getParameter("fullName");
        String nationalCode = request.getParameter("nationalCode");
        String password = request.getParameter("password");
        String gender = request.getParameter("customerGender");

        Customer customer = new Customer();
        customer.setCustomerGender(gender);
        customer.setFullName(fullName);
        customer.setNationalCode(nationalCode);
        customer.setPassword (password);
        customerService.add(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Search.jsp");
        dispatcher.forward(request, response);
    }

}