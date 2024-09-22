package pe.edu.cibertec.patitas_backend_a.service;

import pe.edu.cibertec.patitas_backend_a.dto.LoginResquestDTO;

import javax.imageio.IIOException;
import java.io.IOException;

public interface AutenticacionService {

    String[] validarUsuario(LoginResquestDTO loginResquestDTO) throws IOException;
}
