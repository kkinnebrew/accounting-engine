<%@ page import="com.orangelit.stocktracker.web.views.TransactionAdminView" %>
<%@ page import="com.orangelit.stocktracker.web.dtos.AccountTransactionDTO" %>
<%@ page import="com.orangelit.stocktracker.accounting.models.TransactionType" %>
<%@ page import="com.orangelit.stocktracker.accounting.models.Account" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="freemarker.template.SimpleDate" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% TransactionAdminView model = (TransactionAdminView)request.getAttribute("model"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>StockTracker | Accounting</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
  <style type="text/css">
    .hidden {
      display: none;
    }
    .text-center {
      text-align: center;
    }
    .text-right {
      text-align: right;
    }
  </style>
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
        <li><a
            href="#"><%=model.user.firstName%> <%=model.user.lastName%>
        </a></li>
        <li><a href="/api/auth/logout">Logout</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="container" style="margin-top: 60px">
  <div class="page-header">
    <div class="alert alert-dismissable alert-danger hidden">
      <button type="button" class="close" data-dismiss="alert">x</button>
      <h4>Error!</h4>
      <p id="errorMessage"></p>
    </div>
    <div class="row">
      <div class="col-lg-10"><h2 style="margin-top: 6px; margin-bottom: 24px;">Transactions - <%=model.account.getAccountName()%></h2></div>
      <div class="col-lg-2" style="text-align: right"><button type="button" class="btn btn-success create-btn">Create New</button></div>
    </div>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean id commodo quam, quis venenatis quam. Mauris
      placerat rutrum sem in auctor. Suspendisse potenti. Mauris sed leo pharetra, luctus velit non, venenatis dui.
      Morbi eget purus a enim pharetra placerat. Vivamus eget felis urna. Ut fermentum sollicitudin nisl vitae laoreet.
      Sed ac turpis aliquet, lobortis lacus a, condimentum arcu. Morbi congue commodo felis, eu sollicitudin odio
      consectetur eu. Proin pharetra interdum nisi quis luctus. Integer facilisis sit amet velit sed hendrerit.</p>
    <select class="accountChooser">
      <% if (!model.accounts.isEmpty()) { %>
      <% for (Account account : model.accounts) { %>
      <% if (account.getAccountId().equals(model.account.getAccountId())) { %>
      <option selected="selected" value="<%=account.getAccountId()%>"><%=account.getAccountName()%></option>
      <% } else { %>
      <option value="<%=account.getAccountId()%>"><%=account.getAccountName()%></option>
      <% } %>
      <% } %>
      <% } %>
    </select>
  </div>
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <table class="table table-striped table-bordered table-hover">
          <thead>
          <tr>
            <th>Date</th>
            <th>Transaction Type</th>
            <th>Account</th>
            <th class="text-right">Amount</th>
            <th class="text-right">Balance</th>
            <%--<th>Edit</th>--%>
            <th class="text-center">Remove</th>
          </tr>
          </thead>
          <tbody>
          <% if (model.transactions.isEmpty()) { %>
          <tr>
            <td colspan="6">No results</td>
          </tr>
          <% } else { %>
          <% DecimalFormat df = new DecimalFormat("#,##0.00"); %>
          <% SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, y"); %>
          <% for (AccountTransactionDTO transaction : model.transactions) { %>
          <tr>
            <td><%=dateFormat.format(transaction.getTransactionDate())%></td>
            <td><%=transaction.getTransactionType().getName()%></td>
            <td><%=transaction.getAccount().getAccountName()%></td>
            <td class="text-right"><%=df.format(transaction.getAmount().setScale(2))%></td>
            <td class="text-right"><%=df.format(transaction.getBalance().setScale(2))%></td>
            <%--<td><a href="#" class="edit-btn">Edit</a></td>--%>
            <td class="text-center"><a href="#" class="delete-btn" itemid="<%=transaction.getTransactionId()%>">Delete</a></td>
          </tr
          <% } %>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <footer style="margin: 2em 0">Copyright &copy; 2014. All Rights Reserved.</footer>
</div>
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Create Transfer</h4>
      </div>
      <div class="modal-body">
        <form class="bs-example form-horizontal">
          <fieldset>
            <div class="form-group">
              <label class="col-lg-4 control-label">Transfer To Account</label>
              <div class="col-lg-8">
                <select class="form-control" name="accountId">
                  <% if (!model.accounts.isEmpty()) { %>
                  <% for (Account account : model.accounts) { %>
                  <option value="<%=account.getAccountId()%>"><%=account.getAccountName()%></option>
                  <% } %>
                  <% } %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-4 control-label">Transaction Type</label>
              <div class="col-lg-8">
                <select class="form-control" name="transactionTypeId">
                  <% if (!model.transactionTypes.isEmpty()) { %>
                  <% for (TransactionType transactionType : model.transactionTypes) { %>
                  <option value="<%=transactionType.getTransactionTypeId()%>"><%=transactionType.getName()%></option>
                  <% } %>
                  <% } %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-4 control-label">Transaction Date</label>
              <div class="col-lg-8">
                <input type="text" class="form-control" name="transactionDate" placeholder="Transaction Date">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-4 control-label">Amount</label>
              <div class="col-lg-8">
                <input type="text" class="form-control" name="amount" placeholder="Amount">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-4 control-label">Description</label>
              <div class="col-lg-8">
                <input type="text" class="form-control" name="description" placeholder="Description">
              </div>
            </div>
          </fieldset>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary">Create</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Edit Account</h4>
      </div>
      <div class="modal-body">
        <form class="bs-example form-horizontal">
          <input type="hidden" name="accountId" />
          <fieldset>
            <div class="form-group">
              <label class="col-lg-4 control-label">Account Name</label>
              <div class="col-lg-8">
                <input type="text" class="form-control" name="accountName" placeholder="Account Name">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-4 control-label">Account Type</label>
              <div class="col-lg-8">
                <select class="form-control" name="accountTypeId">
                  <% if (!model.accounts.isEmpty()) { %>
                  <% for (Account account : model.accounts) { %>
                  <option value="<%=account.getAccountId()%>"><%=account.getAccountName()%></option>
                  <% } %>
                  <% } %>
                </select>
              </div>
            </div>
          </fieldset>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <input type="hidden" name="transactionId" />
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Delete Transaction</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure you want to delete this item?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary">Delete Item</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $(".create-btn").on('click', function() {
      $("#createModal").modal();
    });
    $(".accountChooser").on('change', function() {
      location.href = "/api/transactions?accountId=" + $(".accountChooser").val();
    });
    $("#createModal .btn-primary").on('click', function() {
      $.ajax({
        url: "/api/transactions/transfer",
        method: "POST",
        data: {
          fromAccountId: $(".accountChooser").val(),
          toAccountId: $('#createModal [name="accountId"]').val(),
          transactionTypeId: $('#createModal [name="transactionTypeId"]').val(),
          transactionDate: $('#createModal [name="transactionDate"]').val(),
          amount: $('#createModal [name="amount"]').val(),
          description: $('#createModal [name="description"]').val()
        },
        success: function() {
          $("#createModal").modal('hide');
          $("#createModal").find('input[name]').val('');
          location.reload();
        },
        error: function(error) {
          $('.alert').removeClass('hidden');
          $("#editModal").modal('hide');
          $("#errorMessage").text(error.responseText || "Error creating transfer");
          $("#createModal").find('input[name]').val('');
        }
      });
    });
    $(".edit-btn").on('click', function() {
      $("#editModal").modal();
      var row = $(this).closest('tr');
      $(row).find('[data-name]').each(function() {
        var attr = $(this).attr('data-value');
        if (typeof attr !== 'undefined' && attr !== false) {
          $("#editModal").find('[name="' + $(this).attr('data-name') + '"]').val(attr);
        } else {
          $("#editModal").find('[name="' + $(this).attr('data-name') + '"]').val($(this).text());
        }
      });
    });
    $("#editModal .btn-primary").on('click', function() {
      $.ajax({
        url: "/api/accounts",
        method: "PUT",
        data: {
          accountId: $('#editModal [name="accountId"]').val(),
          accountName: $('#editModal [name="accountName"]').val(),
          accountTypeId: $('#editModal [name="accountTypeId"]').val()
        },
        success: function() {
          $("#editModal").modal('hide');
          location.reload();
        },
        error: function(error) {
          $('.alert').removeClass('hidden');
          $("#editModal").modal('hide');
          $("#errorMessage").text(error.responseText || "Error editing account");
        }
      });
    });
    $(".delete-btn").on('click', function(e) {
      var id = $(e.currentTarget).attr('itemid');
      $('#deleteModal').find('[name="transactionId"]').val(id);
      $("#deleteModal").modal();
    });
    $("#deleteModal .btn-primary").on('click', function() {
      $.ajax({
        url: "/api/transactions/delete",
        method: "GET",
        data: {
          transactionId: $('#deleteModal [name="transactionId"]').val()
        },
        success: function() {
          $("#deleteModal").modal('hide');
          $("#deleteModal").find('input[name]').val('');
          location.reload();
        },
        error: function(error) {
          $('.alert').removeClass('hidden');
          $("#deleteModal").modal('hide');
          $("#errorMessage").text(error.responseText || "Error deleting transaction");
          $("#deleteModal").find('input[name]').val('');
        }
      });
    });
  });
</script>
</body>
</html>