<%@page import="com.orangelit.stocktracker.authentication.models.User" %>
<%@page import="com.orangelit.stocktracker.accounting.models.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>StockTracker | Accounting</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
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
            <li><a tabindex="-1" href="#">Accounts</a></li>
            <li><a tabindex="-1" href="#">Account Types</a></li>
            <li><a tabindex="-1" href="#">Transaction Types</a></li>
            <li><a tabindex="-1" href="#">Transactions</a></li>
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
    <h2>Accounting</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean id commodo quam, quis venenatis quam. Mauris placerat rutrum sem in auctor. Suspendisse potenti. Mauris sed leo pharetra, luctus velit non, venenatis dui. Morbi eget purus a enim pharetra placerat. Vivamus eget felis urna. Ut fermentum sollicitudin nisl vitae laoreet. Sed ac turpis aliquet, lobortis lacus a, condimentum arcu. Morbi congue commodo felis, eu sollicitudin odio consectetur eu. Proin pharetra interdum nisi quis luctus. Integer facilisis sit amet velit sed hendrerit.</p>
  </div>
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="well">
          <form class="bs-example form-horizontal" method="POST" action="/api/dashboard/createAccountType">
            <fieldset>
              <legend>Create Account Type</legend>
              <div class="form-group">
                <label for="accountTypeName" class="col-lg-2 control-label">Account Type Name</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="accountTypeName" name="accountTypeName" placeholder="Account Type Name">
                </div>
              </div>
              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <input type="submit" class="btn btn-primary" value="Save" />
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="well">
          <form class="bs-example form-horizontal" method="POST" action="/api/dashboard/createAccount">
            <fieldset>
              <legend>Create Account</legend>
              <div class="form-group">
                <label for="accountName" class="col-lg-2 control-label">Account Name</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="accountName" name="accountName" placeholder="Account Name">
                </div>
              </div>
              <div class="form-group">
                <label for="accountType" class="col-lg-2 control-label">Account Type</label>
                <div class="col-lg-10">
                  <select class="form-control" id="accountType" name="accountType" placeholder="Account Type">
                    <option value="1">Asset</option>
                    <option value="2">Liability</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="balance" class="col-lg-2 control-label">Balance</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="balance" name="balance" placeholder="Balance">
                </div>
              </div>
              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <input type="submit" class="btn btn-primary" value="Save" />
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="well">
          <form class="bs-example form-horizontal" method="POST" action="/api/dashboard/createTransactionType">
            <fieldset>
              <legend>Create Transaction Type</legend>
              <div class="form-group">
                <label for="transactionTypeName" class="col-lg-2 control-label">Type Name</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="transactionTypeName" name="transactionTypeName" placeholder="Type Name">
                </div>
              </div>
              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <input type="submit" class="btn btn-primary" value="Save" />
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="well">
          <form class="bs-example form-horizontal" method="POST" action="/api/dashboard/createTransaction">
            <fieldset>
              <legend>Transfer</legend>
              <div class="form-group">
                <label for="fromAccount" class="col-lg-2 control-label">From Account</label>
                <div class="col-lg-10">
                  <select class="form-control" id="fromAccount" name="fromAccount" placeholder="From Account">
                    <option value="1">Cash</option>
                    <option value="2">Payable</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="toAccount" class="col-lg-2 control-label">To Account</label>
                <div class="col-lg-10">
                  <select class="form-control" id="toAccount" name="toAccount" placeholder="To Account">
                    <option value="1">Cash</option>
                    <option value="2">Payable</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="transactionType" class="col-lg-2 control-label">Transaction Type</label>
                <div class="col-lg-10">
                  <select class="form-control" id="transactionType" name="transactionType" placeholder="Transaction Type">
                    <option value="1">Bill Payment</option>
                    <option value="2">Direct Deposit</option>
                    <option value="2">Transfer</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="date" class="col-lg-2 control-label">Date</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="date" name="date" placeholder="Date">
                </div>
              </div>
              <div class="form-group">
                <label for="amount" class="col-lg-2 control-label">Amount</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="amount" name="amount" placeholder="Amount">
                </div>
              </div>
              <div class="form-group">
                <label for="description" class="col-lg-2 control-label">Description</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="description" name="description" placeholder="Description">
                </div>
              </div>
              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <input type="submit" class="btn btn-primary" value="Save" />
                </div>
              </div>
            </fieldset>
          </form>
        </div>
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