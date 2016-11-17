<html>
<head>
<title>Admin Login</title>
</head>
<body>

<?php echo validation_errors(); ?>
<?php echo form_open('JudgingApp/AdminIndex'); ?>

<h5>Admin Username</h5>
<input type="text" name="usernameA" value="" size="50" />

<h5>Admin Password</h5>
<input type="text" name="passwordA" value="" size="50" />

<div><input id="btn_loginA" name="btn_loginA" type="Submit" value="Login" /></div>

</form>

</body>
</html>
