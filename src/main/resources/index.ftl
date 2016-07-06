<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<title>Test</title>
<style>
.main-form input {
  margin-bottom: 20px;
}

.background-main-form {
  background-color: rgb(255, 125, 0);
}

.form-border {

  border: 10px solid black;
  padding: 100px 100px;

}

</style>
</head>
<main id="content" role="main" xmlns="http://www.w3.org/1999/html">
  <body class="background-main-form">
<h1 class="text-center text-uppercase">Hello, this page works!</h1>
<div class="col-md-6 col-md-offset-3 main-form form-border">
<div class="row">
  <div class="col-md-6 col-md-offset-3">
    <div class="thumbnail" style="margin-bottom: 40px">
      <img src="http://www.penguins.cl/penguin/chinstrap-penguins.jpg"/>
      </div>
      </div>
        </div>
<form method="post" action="login-details">
  <label for="username">Username: </label>
    <input name="username" class="form-control" id="username" placeholder="Username: ">

  <label for="password">Password: </label>
    <input name="password" type="password" class="form-control" id="password" placeholder="Password: "></input>

  <input name="submit" type="submit" class="btn btn-primary form-control"></input>
</form>
<form method="post" action="register-details">
  <input name="register" type="submit" value="Register" class="btn btn-warning form-control"></input>
</form>

<form method="post" action="changepassword-details">
  <input name="changepassword" type="submit" value="Change Password" class="btn btn-danger form-control"></input>
</form>
</div>
</body>
</main>
