package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.model.domain.Usuario;

@Service
public class UsuarioService {
      private Map<String, Usuario> mapaUsuarios = new HashMap<String, Usuario>();

      public void add(Usuario usuario) {
            mapaUsuarios.put(usuario.getEmail(), usuario);
      }

      public ArrayList<Usuario> list() {
            return new ArrayList<Usuario>(mapaUsuarios.values());
      }
}
