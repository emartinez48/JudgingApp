<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class JudgingApp extends CI_Controller
{

  public function __construct()
  {
    parent::__construct();
    $this->load->library('session');
    $this->load->library('form_validation');
    $this->load->helper('url');
    $this->load->database();
    $this->load->helper('html');
    $this->load->model('Judge_Model');
  }

public function index()
   {

     //Validate the errors and make sure a user can insert into a database
     $this->form_validation->set_rules('username', 'Username', 'required');
     $this->form_validation->set_rules('password', 'Password', 'required', array('required' => 'You must provide a %s.'));
     $username = $this->input->post("username");
     $password = $this->input->post("password");
     $data['JudgeID'] = $this->Judge_Model->Get_JudgeID();

     //Meanwhile the rules are false (Empty) the code will not Proceed
     if ($this->form_validation->run() == FALSE)
     {
       $this->load->view('JudgingApp/myform',$data);

     }
     else
     {
       //validation succeeds
       if ($this->input->post('btn_login') == "Login")
       {
         //check if username and password is correct
         $usr_result = $this->Judge_Model->get_user($username, $password);
        //Once Correct
         if ($usr_result > 0)
         {
           //Messy way to store ID
           $i=0;
           $data['JudgeID'] =  $this->Judge_Model->Get_JudgeID2($username);
           foreach ($data as $row);
           {
               $VarID=$row[$i]->JudgeID;
           }
           //Ends here

           //set the session variables
           $sessiondata = array('login' => TRUE,
                                'JudgeName' => $username,
                                'uid' => $VarID);
           $sessiondata = array($this->session->set_userdata($sessiondata));
           redirect("JudgingApp/MainMenu");
           }
           else
           {
           redirect('JudgingApp/index');
           }
        }
        // else{redirect('Index');}
      }
    }

    public function MainMenu()
    {
      $i=0;
      $data['Session'] =  $this->Judge_Model->Get_Session();
      foreach ($data as $row);
      {
          $PSess=$row[$i]->Session;
      }


      $data['Poster'] = $this->Judge_Model->get_Posters($PSess);
      if (isset($this->session->userdata['JudgeName']))
      {
        $this->load->view('templates/header');
        $this->load->view('JudgingApp/MainMenu',$data);
        if ($this->input->post('btn_logout') == "Logout")
      {
        session_destroy();
      }
      }
      else
      {
        redirect('JudgingApp/index');
      }

    }
    public function Redirect()
    {
        redirect('JudgingApp/index');
    }


    public function ScorePoster($PosterID = NULL)
    {

      $this->load->helper('form');
      $this->load->library('form_validation');
      $data['PosterID']=$PosterID;
      $this->form_validation->set_rules('Criteria1', 'Criteria1 ', 'required');
      $this->form_validation->set_rules('Criteria2', 'Criteria2 ', 'required');
      $this->form_validation->set_rules('Criteria3', 'Criteria3 ', 'required');
      $this->form_validation->set_rules('Criteria4', 'Criteria4 ', 'required');
      $this->form_validation->set_rules('Criteria5', 'Criteria5 ', 'required');
      $this->form_validation->set_rules('Criteria6', 'Criteria6 ', 'required');
      $this->form_validation->set_rules('Criteria7', 'Criteria7 ', 'required');
      $this->form_validation->set_rules('Criteria8', 'Criteria8 ', 'required');
      $this->form_validation->set_rules('Criteria9', 'Criteria9 ', 'required');
      $this->form_validation->set_rules('Criteria10', 'Criteria10 ', 'required');
                           //User must be logged in
      if ($this->form_validation->run() === FALSE && isset($this->session->userdata['JudgeName']))
      {
          $this->load->view('Templates/Header');
          $this->load->view('JudgingApp/ScorePoster',$data);
          if ($this->input->post('btn_logout') == "Logout")
          {
            session_destroy();
              redirect('JudgingApp/index');
          }
      }
      else
      { //Olonce all Criteria has been Filled
        $this->Judge_Model->Post_Score();
          redirect('JudgingApp/MainMenu');
      }
    }

}
  ?>
