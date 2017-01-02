
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
  <body>

<h4>Display All Poster Records From Database</h4>
 <table>
  <tr>
   <td><strong>Poster Id</strong></td>
   <td><strong>Poster Title</strong></td>
   <td><strong>Poster Category</strong></td>
   <td><strong>First Name</strong></td>
   <td><strong>Last Name</strong></td>
   <td><strong>Mentor</strong></td>

 </tr>
  <?php foreach($Posters as $Poster){?>
  <tr>
      <td><?php echo $Poster->PosterID;?></td>
      <td><?php echo $Poster->Title;?></td>
      <td><?php echo $Poster->Category;?></td>
      <td><?php echo $Poster->PFirst;?></td>
      <td><?php echo $Poster->PLast;?></td>
      <td><?php echo $Poster->Mentor;?></td>


   </tr>
  <?php }?>
</table>
</body>
</html>
