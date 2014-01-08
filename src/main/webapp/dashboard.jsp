<%@page import="com.orangelit.stocktracker.authentication.models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
  <title>StockTracker | Dashboard</title>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="/api/dashboard" class="navbar-brand">Stock Tracker</a>
    </div>
    <div class="navbar-collapse collapse" id="navbar-main">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Accounting <span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="themes">
            <li><a tabindex="-1" href="/api/accounts">Accounts</a></li>
            <li><a tabindex="-1" href="/api/accountTypes">Account Types</a></li>
            <li><a tabindex="-1" href="/api/transactionTypes">Transaction Types</a></li>
            <li><a tabindex="-1" href="/api/transactions">Transactions</a></li>
            <li><a tabindex="-1" href="/api/dashboard/accounting">Manage</a></li>
          </ul>
        </li>
        <li>
          <a href="#">Holdings</a>
        </li>
        <li>
          <a href="#">Transactions</a>
        </li>
        <li>
          <a href="#">Performance</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><%=((User)request.getAttribute("model")).firstName %> <%=((User)request.getAttribute("model")).lastName %></a></li>
        <li><a href="/api/auth/logout">Logout</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="container" style="margin-top: 60px">
  <div class="page-header">
    <h2>Dashboard</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean id commodo quam, quis venenatis quam. Mauris placerat rutrum sem in auctor. Suspendisse potenti. Mauris sed leo pharetra, luctus velit non, venenatis dui. Morbi eget purus a enim pharetra placerat. Vivamus eget felis urna. Ut fermentum sollicitudin nisl vitae laoreet. Sed ac turpis aliquet, lobortis lacus a, condimentum arcu. Morbi congue commodo felis, eu sollicitudin odio consectetur eu. Proin pharetra interdum nisi quis luctus. Integer facilisis sit amet velit sed hendrerit.</p>
  </div>
  <footer style="margin: 2em 0">Copyright &copy; 2014. All Rights Reserved.</footer>
</div>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>