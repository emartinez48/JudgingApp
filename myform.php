<html>
<head>
<title>JudgingApp</title>
</head>
<body>

<?php echo validation_errors(); ?>
<?php echo form_open('JudgingApp/index');
<div><input id="btn_loginAdmin" name="btn_loginAdmin" type="Submit" value="Admin" /></div>


<h5>Username</h5>
<input type="text" name="username" value="" size="50" />

<h5>Password</h5>
<input type="text" name="password" value="" size="50" />

<div><input id="btn_login" name="btn_login" type="Submit" value="Login" /></div>


</form>

</body>
</html>
