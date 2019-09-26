<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>kanuni</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/style.css"/>
</head>
<body >
  <div class="bslf">
    <form action="" method="post">
      <h2 class="text-center">Authentification</h2>
      <div class="form-group">
        <input type="text" class="form-control" name = "log" placeholder="Username" required="required">
      </div>
      <div class="form-group">
        <input type="password" class="form-control"  name = "pwd" placeholder="Password" required="required">
      </div>
      <div class="form-group clearfix">
        <label class="checkbox-inline pull-left"><input type="checkbox"> Se souvenir</label>
        <button type="submit" class="btn btn-primary pull-right">Se connecter</button>
      </div>
    </form>
    ${request.error}
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

