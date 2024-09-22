package pe.edu.cibertec.patitas_backend_a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.patitas_backend_a.dto.LoginResquestDTO;
import pe.edu.cibertec.patitas_backend_a.service.AutenticacionService;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
 public class AutenticacionServiceImpl implements AutenticacionService {

     @Autowired
     ResourceLoader resourceLoader;
     @Override
     public String[] validarUsuario(LoginResquestDTO loginResquestDTO) throws IOException {

         String[] datosUsuario = null;
         Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

         try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

             //ocurre algo aqui
             String linea;
             while ((linea = br.readLine()) !=null){
                 String[] datos = linea.split(";");
                 if(loginResquestDTO.tipoDocumento().equals(datos[0]) &&
                 loginResquestDTO.numeroDocumento().equals(datos[1]) &&
                 loginResquestDTO.password().equals(datos[2])){

                     datosUsuario = new String[2];
                     datosUsuario[0] = datos[3]; //recuperar nombre
                     datosUsuario[1] = datos[4];  //recuperar correo
                     break;
                 }
             }

         }catch (IIOException e){

             datosUsuario = null;
             throw new IOException(e);
         }

         return datosUsuario;
     }
 }
