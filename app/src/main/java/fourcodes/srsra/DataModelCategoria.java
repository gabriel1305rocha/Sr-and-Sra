package fourcodes.srsra;


/**
 * Created by Felipe on 01/04/2017.
 */

public class DataModelCategoria {

    String Categoria ="";
    int Imagen;

    public DataModelCategoria(String Categoria, int Imagen){
        this.Categoria = Categoria;
        this.Imagen = Imagen;
    }

    public int getImagen() {
        return Imagen;
    }
    public String getCategoria() {
        return Categoria;
    }
}