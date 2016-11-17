<html>
<head>
<title>Create New Judge</title>
</head>
<body>

<h3>Create New Judge</h3>


<?php echo validation_errors(); ?>

<?php echo form_open('JudgingApp/Admin/create'); ?>

    <label for="JudgeName">Judge Name</label>
    <input type="input" name="JudgeName" /><br />

    <label for="JudgePass">Judge Password</label>
    <input type="input" name="JudgePass" /><br />


    <input type="submit" name="nJudge" value="Create New Judge" />

    <h3>Radio Buttons</h3>

  <input type="radio" name="gender" value="male" checked> A<br>
  <input type="radio" name="gender" value="female"> B<br>
  <input type="submit" name="submit" value="Submit" />
</form>
