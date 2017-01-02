
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
  <body>

<h4>Display Judges Records From Database</h4>
 <table>
  <tr>
   <td><strong>Judge Id</strong></td>
   <td><strong>Judge Name</strong></td>
   <td><strong>Judge Password</strong></td>

 </tr>
  <?php foreach($Judges as $Judge){?>
  <tr>
      <td><?php echo $Judge->JudgeID;?></td>
      <td><?php echo $Judge->JudgeName;?></td>
      <td><?php echo $Judge->JudgePass;?></td>

   </tr>
  <?php }?>
</table>
</body>
</html>
