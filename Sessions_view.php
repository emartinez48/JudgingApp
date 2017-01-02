<html>
<head>
<title>Sessions</title>
</head>
<body>

<h3>Set Session</h3>


<?php echo validation_errors(); ?>

<?php echo form_open('JudgingApp/sessions'); ?>



<form action="" method="post">
<input type="radio" name="radio" value="A">A
<input type="radio" name="radio" value="B">B
<input type="submit" name="submit" value="Select Session" />
</form>
<?php
if (isset($_POST['submit'])) {
if(isset($_POST['radio']))
{
echo "You have selected: ".$_POST['radio'];  //  Displaying Selected Value
}
else{ echo "<span>Please choose any radio button.</span>";
}
}
?>
