<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row text-center" style="color: tomato;">
        <h2>User Registration with JSP, Servlet and Hibernate</h2>
    </div>
    <hr>
    <div class="row col-md-10 col-md-offset-3">
        <div class="card card-body">
            <h2>Bus Ticket</h2>
            <div class="col-md-8 col-md-offset-3">
                <form action="<%=request.getContextPath()%>/register" method="POST">
                    <div class="form-group">
                        <label for="fName">Full name:</label>
                        <input type="text" class="form-control" id="fName" placeholder="Full name"
                               name="fullName" required>
                    </div>
                    <div class="form-group">
                        <label for="nc">National code:</label>
                        <input type="text" class="form-control" id="nc" placeholder="nationalCode"
                               name="nationalCode" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Password"
                               name="password" required>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <select id="gender" name="customerGender">
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>