package pe.edu.cibertec.patitas_backend_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.patitas_backend_a.dto.LoginResponseDTO;
import pe.edu.cibertec.patitas_backend_a.dto.LoginResquestDTO;
import pe.edu.cibertec.patitas_backend_a.service.AutenticacionService;

import java.io.IOException;

@RestController
@RequestMapping("/autenticacion")

public class AutenticacionController {

    @Autowired
  AutenticacionService autenticacionService;



  @PostMapping("/login")
  public LoginResponseDTO login(@RequestBody LoginResquestDTO loginResquestDTO) {

      try {
          String[] datosUsuario = autenticacionService.validarUsuario(loginResquestDTO);
          if (datosUsuario == null) {
              return new LoginResponseDTO("01", "Error: Usuario no Encontrado", "", "");
          }

          return  new LoginResponseDTO("00","",datosUsuario[0],datosUsuario[1]);
      } catch (IOException e) {
          return new LoginResponseDTO("99", "Ocurrio un Problema", "", "");
      }


  }

}
