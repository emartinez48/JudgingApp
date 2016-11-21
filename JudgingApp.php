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
      if ($this->input->post('btn_loginAdmin') == "Admin")
      {
        redirect('JudgingApp/AdminIndex');
      }
     $this->form_validation->set_rules('username', 'Username', 'required');
     $this->form_validation->set_rules('password', 'Password', 'required', array('required' => 'You must provide a %s.'));
     $username = $this->input->post("username");
     $password = $this->input->post("password");
     $data['JudgeID'] = $this->Judge_Model->Get_JudgeID();


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
        //Query to retrive ID

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
      $data['Poster'] = $this->Judge_Model->get_Posters();

      if (isset($this->session->userdata['JudgeName']))
      {
        $this->load->view('JudgingApp/MainMenu',$data);
      }
      else
      {
        redirect('JudgingApp/index');
      }
    }
  public function AdminIndex()
  {
    $this->form_validation->set_rules('usernameA', 'UsernameA', 'required');
    $this->form_validation->set_rules('passwordA', 'PasswordA', 'required', array('required' => 'You must provide a %s.'));
    $usernameA = $this->input->post("usernameA");
    $passwordA = $this->input->post("passwordA");
    if ($this->form_validation->run() == FALSE)
    {
      $this->load->view('JudgingApp/Admin/Adminform');

    }
    else
    {
      //validation succeeds
      if ($this->input->post('btn_loginA') == "Login")
      {
        //check if username and password is correct
        $usr_result = $this->Judge_Model->get_Admin($usernameA, $passwordA);
        if ($usr_result > 0)
        {
          //set the session variables
          $sessiondata = array('login' => TRUE,'AdminName' => $usernameA,'uid' => $uresult[0]->AdminID);
          $sessiondata = array($this->session->set_userdata($sessiondata));
          redirect('JudgingApp/AdminMenu');
          }
          else
          {
           redirect('JudgingApp/AdminIndex');
          }
        }
        else
        {
          redirect('Index');
        }
      }
    }
  public function AdminMenu()
    {
      $this->load->view('Templates/AdminHeader');
      $this->load->view('JudgingApp/Admin/AdminMenu');

      if ($this->input->post('nJudge') == "Create new Judge")
      {
        redirect('JudgingApp/Admin/success');

      }

      if ($this->input->post('btn_logoutA') == "Logout")
      {
        session_destroy();
      }
    }

    public function ScorePoster($PosterID = NULL)
    {

      $this->load->helper('form');
      $this->load->library('form_validation');

    //  $this->form_validation->set_rules('title', 'Title', 'required');
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

      if ($this->form_validation->run() === FALSE && isset($this->session->userdata['JudgeName']))
      {
          $this->load->view('JudgingApp/ScorePoster',$data);
      }
      else
      {
        $this->Judge_Model->Post_Score();
          redirect('JudgingApp/MainMenu');
      }



    }





}
  ?>
