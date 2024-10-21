//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.Exceptions;

/**
 * Esta excepción se usa para indicar que se encontraron dos Usuarios con el mismo identificador, lo cual nunca debería ocurrir.
 */

//====================================================================================
//Definicion de 
//====================================================================================

@SuppressWarnings("serial")
public class UsuarioDuplicadoException extends Exception
{
	//----------------------------------------------------------------------
	// Definicion de atributos
	
    private String usuarioDuplicado;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public UsuarioDuplicadoException( String nombreUsuario )
    {
        super( );
        this.usuarioDuplicado = nombreUsuario;
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    
    @Override
    public String getMessage( )
    {
        return "El Usuario '" + usuarioDuplicado + "' ya existe.";
    }
}
