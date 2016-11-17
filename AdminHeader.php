<html>
        <head>
                <title>Judging App</title>
        </head>
        <body>

          <?php echo form_open('JudgingApp/AdminIndex'); ?>
                <div style="position:relative;left:1250px;top:0px;">
                  <input id="btn_logoutA" name="btn_logoutA" type="Submit" value="Admin Logout" /></div>
                  <h1><?php echo ("Hello, "); ?><?php echo $this->session->userdata['AdminName']; ?></p></h1>
