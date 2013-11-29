<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Sign</title>
    <meta content="width=device-width, initial-scale=1.0">
    <link href="resources/styles/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="resources/scripts/jquery.js"></script>
    <script src="resources/scripts/jquery.validate.min.js"></script>
    <script src="resources/scripts/bootstrap.min.js"></script>
    <link href="resources/styles/login.css" rel="stylesheet" media="screen">
    <script>

$(function(){

$("#signInForm").validate({
   //submitHandler: function(form){
    //alert(form['user'].value);
    //}  
});

$("#signUpForm").validate({
    rules: {
      userName: {
        required: true,
      },
      passWord: {
        required: true,
        //minlength: 5
      },
      confirmPassword: {
        required: true,
        //minlength: 5,
        equalTo: "#password"
      },
      email: {
        required: true,
        email: true
      },
    },
    messages: {
      username: {
        required: "Please enter a username",
        //minlength: "Your username must consist of at least 2 characters"
      },
      password: {
        required: "Please provide a password",
        //minlength: "Your password must be at least 5 characters long"
      },
      confirm_password: {
        required: "Please provide a password",
        //minlength: "Your password must be at least 5 characters long",
        equalTo: "Please enter the same password as above"
      },
      email: "Please enter a valid email address"
    },
   //submitHandler: function(form){  
    //form.submit();
    //} 
  });
});
</script>

  </head>
  
  <body>

    <div class="container">
      <c:if test="${error}">
    	<div class="alert alert-error">
  			<button type="button" class="close" data-dismiss="alert">&times;</button>
  			<strong>Try again</strong> Your login attempt was not successful
		</div>
  	 </c:if>
       <ul id="tab"class="nav nav-tabs">
          <li class="active"><a href="#signIn" data-toggle="tab">Sign in</a></li>
          <li><a href="#signUp" data-toggle="tab">Sign up</a></li>
      </ul>
      <div id="tabContent" class="tab-content">
          <div class="tab-pane fade in active" id="signIn">
          <form class="form" id="signInForm" action="<c:url value='j_spring_security_check'/>"  method="post">
          <fieldset>
            <input type="text" class="form-control" placeholder="User name or Email" name="j_username" id="user" required>
            <input type="password" class="form-control" placeholder="Password" id="password" name="j_password" required>
            <!--<label class="checkbox">
              <input type="checkbox" value="remember-me"> Remember me
            </label>-->
            <label><a href="">Forgot password?</a></label>
            <button class="btn btn-large btn-primary" type="submit" id="btnSignIn">Sign in</button>
          </fieldset>
         </form>
        </div>

          <div class="tab-pane fade" id="signUp">
            <form class="form" id="signUpForm" action="register"  method="post">
             <fieldset>
                <input type="text" class="form-control" placeholder="User name" name="userName" id="userName" required>
                <input type="text" class="form-control" placeholder="Email" name="email" id="email" required>
                <input type="password" class="form-control" placeholder="Password" name="password" id="password" required>
                <input type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword" required>
                <button id="btnSignUp" class="btn btn-large btn-primary" type="submit">Sign up</button>
             </fieldset>
            </form>
          </div>
      </div>
    </div>
</body>
</html>