package com.desarrollo_samary.desarrollo_samary.Controller;

import com.desarrollo_samary.desarrollo_samary.Entity.Usuario;
import com.desarrollo_samary.desarrollo_samary.Service.UsuarioService;
import com.desarrollo_samary.desarrollo_samary.Controller.Util.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Usuario>>> listarUsuarios() {
        List<Usuario> lista = service.obtenerTodos();
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de usuarios", lista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Usuario>> obtenerPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = service.obtenerPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Usuario encontrado", usuario.get()));
        } else {
            return new ResponseEntity<>(new ApiResponse<>(false, "Usuario no encontrado", null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Usuario>> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = service.guardar(usuario);
        return new ResponseEntity<>(new ApiResponse<>(true, "Usuario creado exitosamente", nuevo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Usuario>> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario actualizado = service.guardar(usuario);
        return ResponseEntity.ok(new ApiResponse<>(true, "Usuario actualizado", actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Usuario eliminado", null));
    }
}

