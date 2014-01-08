<%@ page import="com.orangelit.stocktracker.web.views.AccountAdminView" %>
<%@ page import="com.orangelit.stocktracker.accounting.models.Account" %>
<%@ page import="com.orangelit.stocktracker.accounting.models.AccountType" %>
<% AccountAdminView model = (AccountAdminView)request.getAttribute("model"); %>
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
      <div class="col-lg-10"><h2 style="margin-top: 6px; margin-bottom: 24px;">Accounts</h2></div>
      <div class="col-lg-2" style="text-align: right"><button type="button" class="btn btn-success create-btn">Create New</button></div>
    </div>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean id commodo quam, quis venenatis quam. Mauris
      placerat rutrum sem in auctor. Suspendisse potenti. Mauris sed leo pharetra, luctus velit non, venenatis dui.
      Morbi eget purus a enim pharetra placerat. Vivamus eget felis urna. Ut fermentum sollicitudin nisl vitae laoreet.
      Sed ac turpis aliquet, lobortis lacus a, condimentum arcu. Morbi congue commodo felis, eu sollicitudin odio
      consectetur eu. Proin pharetra interdum nisi quis luctus. Integer facilisis sit amet velit sed hendrerit.</p>
  </div>
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <table class="table table-striped table-bordered table-hover">
          <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Account Type</th>
            <th>User</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
          </thead>
          <tbody>
          <% if (model.accounts.isEmpty()) { %>
          <tr>
            <td colspan="6">No results</td>
          </tr>
          <% } else { %>
          <% for (Account account : model.accounts) { %>
          <tr>
            <td data-name="accountId"><%=account.getAccountId()%></td>
            <td data-name="accountName"><%=account.getAccountName()%></td>
            <td data-name="accountTypeId" data-value="<%=account.getAccountType().getAccountTypeId()%>"><%=account.getAccountType().getName()%></td>
            <td data-name="userId" data-value="<%=account.getUserId()%>"><%=account.getUserId()%></td>
            <td><a href="#" class="edit-btn">Edit</a></td>
            <td><a href="#" class="delete-btn">Delete</a></td>
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
        <h4 class="modal-title">Create Account</h4>
      </div>
      <div class="modal-body">
        <form class="bs-example form-horizontal">
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
                  <% if (!model.accountTypes.isEmpty()) { %>
                  <% for (AccountType accountType : model.accountTypes) { %>
                  <option value="<%=accountType.getAccountTypeId()%>"><%=accountType.getName()%></option>
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
                  <% if (!model.accountTypes.isEmpty()) { %>
                  <% for (AccountType accountType : model.accountTypes) { %>
                  <option value="<%=accountType.getAccountTypeId()%>"><%=accountType.getName()%></option>
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
      <input type="hidden" name="accountId" />
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Delete Account</h4>
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
    $("#createModal .btn-primary").on('click', function() {
      $.ajax({
        url: "/api/accounts",
        method: "POST",
        data: {
          accountName: $('#createModal [name="accountName"]').val(),
          accountTypeId: $('#createModal [name="accountTypeId"]').val()
        },
        success: function() {
          $("#createModal").modal('hide');
          $("#createModal").find('input[name]').val('');
          location.reload();
        },
        error: function(error) {
          $('.alert').removeClass('hidden');
          $("#editModal").modal('hide');
          $("#errorMessage").text(error.responseText || "Error creating account");
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
    $(".delete-btn").on('click', function() {
      var row = $(this).closest('tr');
      var id = row.find('[data-name="accountId"]').text();
      $('#deleteModal').find('[name="accountId"]').val(id);
      $("#deleteModal").modal();
    });
    $("#deleteModal .btn-primary").on('click', function() {
      $.ajax({
        url: "/api/accounts/delete",
        method: "GET",
        data: {
          accountId: $('#deleteModal [name="accountId"]').val()
        },
        success: function() {
          $("#deleteModal").modal('hide');
          $("#deleteModal").find('input[name]').val('');
          location.reload();
        },
        error: function(error) {
          $('.alert').removeClass('hidden');
          $("#deleteModal").modal('hide');
          $("#errorMessage").text(error.responseText || "Error deleting account");
          $("#deleteModal").find('input[name]').val('');
        }
      });
    });
  });
</script>
</body>
</html>