<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
      <title>StockTracker | Login</title>
    </head>
    <body>
        <div class="navbar navbar-default navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
                <a href="/" class="navbar-brand">Stock Tracker</a>
            </div>
            <div class="navbar-collapse collapse" id="navbar-main">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="/api/auth/register">Register</a></li>
                <li><a href="#">Login</a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="container" style="margin-top: 60px">
          <div class="page-header">
            <h2>Login</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean id commodo quam, quis venenatis quam. Mauris placerat rutrum sem in auctor. Suspendisse potenti. Sed ac turpis aliquet, lobortis lacus a, condimentum arcu. Morbi congue commodo felis, eu sollicitudin odio consectetur eu. Proin pharetra interdum nisi quis luctus. Integer facilisis sit amet velit sed hendrerit.</p>
          </div>
          <div class="bs-docs-section">
            <div class="row">
                <div class="col-lg-6">
                    <div class="well">
                      <form class="bs-example form-horizontal" method="POST" action="/api/auth/login">
                        <fieldset>
                          <legend>Login</legend>
                          <div class="form-group">
                            <label for="username" class="col-lg-2 control-label">Username</label>
                            <div class="col-lg-10">
                              <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="password" class="col-lg-2 control-label">Password</label>
                            <div class="col-lg-10">
                              <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                              <button class="btn btn-default">Cancel</button>
                              <input type="submit" class="btn btn-primary" value="Login" />
                            </div>
                          </div>
                        </fieldset>
                      </form>
                    </div>
                  </div>
            </div>
          <div>
          <footer style="margin: 2em 0">Copyright &copy; 2014. All Rights Reserved.</footer>
        </div>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    </body>
</html>