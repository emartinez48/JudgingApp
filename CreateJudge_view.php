<html>
<head>
<title>Create New Judge</title>
</head>
<body>

<h3>Create New Judge</h3>


<?php echo validation_errors(); ?>

<?php echo form_open('JudgingApp/AdminMenu'); ?>


<?php if (isset($message)) { ?>
<CENTER><h3 style="color:green;">Data inserted successfully</h3></CENTER><br>
<?php } ?>
<?php echo form_label('Judge Name :'); ?> <?php echo form_error('jname'); ?><br />
<?php echo form_input(array('id' => 'jname', 'name' => 'jname')); ?><br />

<?php echo form_label('Judge Password :'); ?> <?php echo form_error('jpass'); ?><br />
<?php echo form_input(array('id' => 'jpass', 'name' => 'jpass')); ?><br />

<?php echo form_submit(array('id' => 'submit', 'value' => 'Submit')); ?>
<?php echo form_close(); ?><br/>
<div id="fugo">
