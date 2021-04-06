package Dominio.Archivo;

import Dominio.Archivo.IArchivo;

import java.util.List;

public interface IDirectorio {

    List<IArchivo> getArchivos();
}
