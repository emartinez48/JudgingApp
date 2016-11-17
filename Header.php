<html>
        <head>
                <title>Judging App</title>
        </head>
        <body>

          <?php echo form_open('JudgingApp/index'); ?>
                <div style="position:relative;left:1250px;top:0px;">
                  <input id="btn_logout" name="btn_logout" type="Submit" value="Logout" /></div>
                  <h1><?php echo ("Hello, "); ?><?php echo $this->session->userdata['JudgeName']; ?></p></h1>
