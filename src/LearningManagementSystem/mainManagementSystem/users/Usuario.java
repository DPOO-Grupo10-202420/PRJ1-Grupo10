//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.users;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// import Usuario;


//====================================================================================
// Definicion de la clase Usuario
//====================================================================================

public abstract class Usuario  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
	
    String username;
    String password;
    String email;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public Usuario(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;

    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    

    // Getters

    public String getUsername (){
        return this.username;

    }

    public String getPassword (){
        return this.password;

    }

    public String getEmail (){
        return this.email;

    }

    // Metodos

    public void viewReviews (){

    }

    public void addRatingToActivity(){

    }

    public void addReviewToActivity(){

    }


    public void logIn(String username, String password){


    }

    public void signUp(String username, String password){


    }
    






}