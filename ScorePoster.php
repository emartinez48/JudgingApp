<?php echo validation_errors(); ?>
<?php echo form_open('JudgingApp/ScorePoster/'.$PosterID);

echo form_radio('Criteria1', '1'). " 1";
echo form_radio('Criteria1', '2'). " 2";
echo form_radio('Criteria1', '3'). " 3";
echo form_radio('Criteria1', '4'). " 4";
echo br(1);
echo form_radio('Criteria2', '1'). " 1";
echo form_radio('Criteria2', '2'). " 2";
echo form_radio('Criteria2', '3'). " 3";
echo form_radio('Criteria2', '4'). " 4";
echo br(1);
echo form_radio('Criteria3', '1'). " 1";
echo form_radio('Criteria3', '2'). " 2";
echo form_radio('Criteria3', '3'). " 3";
echo form_radio('Criteria3', '4'). " 4";
echo br(1);
echo form_radio('Criteria4', '1'). " 1";
echo form_radio('Criteria4', '2'). " 2";
echo form_radio('Criteria4', '3'). " 3";
echo form_radio('Criteria4', '4'). " 4";
echo br(1);
echo form_radio('Criteria5', '1'). " 1";
echo form_radio('Criteria5', '2'). " 2";
echo form_radio('Criteria5', '3'). " 3";
echo form_radio('Criteria5', '4'). " 4";
echo br(1);
echo form_radio('Criteria6', '1'). " 1";
echo form_radio('Criteria6', '2'). " 2";
echo form_radio('Criteria6', '3'). " 3";
echo form_radio('Criteria6', '4'). " 4";
echo br(1);
echo form_radio('Criteria7', '1'). " 1";
echo form_radio('Criteria7', '2'). " 2";
echo form_radio('Criteria7', '3'). " 3";
echo form_radio('Criteria7', '4'). " 4";
echo br(1);
echo form_radio('Criteria8', '1'). " 1";
echo form_radio('Criteria8', '2'). " 2";
echo form_radio('Criteria8', '3'). " 3";
echo form_radio('Criteria8', '4'). " 4";
echo br(1);
echo form_radio('Criteria9', '1'). " 1";
echo form_radio('Criteria9', '2'). " 2";
echo form_radio('Criteria9', '3'). " 3";
echo form_radio('Criteria9', '4'). " 4";
echo br(1);
echo form_radio('Criteria10', '1'). " 1";
echo form_radio('Criteria10', '2'). " 2";
echo form_radio('Criteria10', '3'). " 3";
echo form_radio('Criteria10', '4'). " 4";
echo br(1);
      echo form_hidden('PosterID', $PosterID);
      echo form_hidden('JudgeID', $this->session->userdata['uid']);
      ?>
    <input type="input" name="Comments" /><br />
    <input type="submit" name="submit" value="Submit" />




</form>
