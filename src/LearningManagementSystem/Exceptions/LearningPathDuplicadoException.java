//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.Exceptions;

/**
 * Esta excepción se usa para indicar que se encontraron dos LearningPaths con el mismo identificador, lo cual nunca debería ocurrir.
 */

//====================================================================================
//Definicion de 
//====================================================================================

@SuppressWarnings("serial")
public class LearningPathDuplicadoException extends Exception
{
	//----------------------------------------------------------------------
	// Definicion de atributos
	
    private String learningPathDuplicado;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public LearningPathDuplicadoException( String nombreLearningPath )
    {
        super( );
        this.learningPathDuplicado = nombreLearningPath;
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    
    @Override
    public String getMessage( )
    {
        return "El LearningPath '" + learningPathDuplicado + "' está repetido";
    }
}
