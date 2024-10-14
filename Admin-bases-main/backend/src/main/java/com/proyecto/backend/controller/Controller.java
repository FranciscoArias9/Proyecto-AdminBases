package com.proyecto.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.backend.dto.LoginRequest;
import com.proyecto.backend.model.Cliente;
import com.proyecto.backend.model.Curso;
import com.proyecto.backend.model.Empleado;
import com.proyecto.backend.model.Maquina;
import com.proyecto.backend.model.Rutina;
import com.proyecto.backend.repository.ClienteRepository;
import com.proyecto.backend.repository.CursoRepository;
import com.proyecto.backend.repository.EmpleadoRepository;
import com.proyecto.backend.repository.MaquinaRepository;
import com.proyecto.backend.repository.RutinaRepository;
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository; 


    // Empleados - Login
    @PostMapping("/empleados/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<Empleado> empleado = empleadoRepository.findById(loginRequest.getCedula());
        if (empleado.isPresent() && empleado.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }


    // Empleados - Obtener todos los empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll(); // Devuelve la lista de empleados
    }

    // Empleados - Obtener un empleado por cédula
    @GetMapping("/empleados/{cedula}")
    public Optional<Empleado> obtenerEmpleado(@PathVariable int cedula) {
        return empleadoRepository.findById(cedula); // Devuelve un empleado por cédula
    }

    // Empleados - Agregar un nuevo empleado
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado); // Guarda un nuevo empleado
    }

    // Empleados - Actualizar un empleado por cédula
    @PutMapping("/empleados/{cedula}")
    public Empleado actualizarEmpleado(@PathVariable int cedula, @RequestBody Empleado empleadoActualizado) {
        return empleadoRepository.findById(cedula)
                .map(empleado -> {
                    empleado.setNombre(empleadoActualizado.getNombre());
                    empleado.setApellido1(empleadoActualizado.getApellido1());
                    empleado.setApellido2(empleadoActualizado.getApellido2());
                    empleado.setDireccion(empleadoActualizado.getDireccion());
                    empleado.setE_mail(empleadoActualizado.getE_mail());
                    empleado.setTel_cel(empleadoActualizado.getTel_cel());
                    empleado.setTel_habitacion(empleadoActualizado.getTel_habitacion());
                    empleado.setPassword(empleadoActualizado.getPassword());
                    return empleadoRepository.save(empleado);
                }).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    
    // Obtener todas las rutinas
    @GetMapping("/rutinas")
    public List<Rutina> obtenerRutinas() {
        return rutinaRepository.findAll();
    }

    // Obtener una rutina por ID
    @GetMapping("/rutinas/{id}")
    public ResponseEntity<Rutina> obtenerRutina(@PathVariable int id) {
        Optional<Rutina> rutina = rutinaRepository.findById(id);
        return rutina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva rutina
    @PostMapping("/rutinas")
    public Rutina agregarRutina(@RequestBody Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    // Actualizar una rutina existente
    @PutMapping("/rutinas/{id}")
    public ResponseEntity<Rutina> actualizarRutina(@PathVariable int id, @RequestBody Rutina rutinaActualizada) {
        return rutinaRepository.findById(id)
                .map(rutina -> {
                    rutina.setCliente(rutinaActualizada.getCliente());
                    rutina.setInstructor(rutinaActualizada.getInstructor());
                    rutina.setMaquina(rutinaActualizada.getMaquina());
                    rutina.setFecha(rutinaActualizada.getFecha());
                    rutina.setHoras(rutinaActualizada.getHoras());
                    rutina.setNombre(rutinaActualizada.getNombre());
                    return ResponseEntity.ok(rutinaRepository.save(rutina));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/rutinas/{id}")
    public void eliminarRutina(@PathVariable int id) {
        rutinaRepository.deleteById(id); // Elimina una rutina por ID
    }

    // Máquinas
    @GetMapping("/maquinas")
    public List<Maquina> obtenerMaquinas() {
        return maquinaRepository.findAll(); // Devuelve la lista de máquinas
    }

    @PostMapping("/maquinas")
    public Maquina agregarMaquina(@RequestBody Maquina maquina) {
        return maquinaRepository.save(maquina); // Guarda una nueva máquina
    }

    @PutMapping("/maquinas/{id}")
    public Maquina actualizarMaquina(@PathVariable int id, @RequestBody Maquina maquinaActualizada) {
        return maquinaRepository.findById(id)
                .map(maquina -> {
                    maquina.setDescripcion(maquinaActualizada.getDescripcion());
                    maquina.setEstado(maquinaActualizada.getEstado());
                    return maquinaRepository.save(maquina);
                }).orElseThrow(() -> new RuntimeException("Máquina no encontrada"));
    }

    @DeleteMapping("/maquinas/{id}")
    public void eliminarMaquina(@PathVariable int id) {
        maquinaRepository.deleteById(id); // Elimina una máquina por ID
    }

    // Clientes
    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll(); // Devuelve la lista de clientes
    }

    /* 
    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
    return clienteRepository.findAll();
     }*/


    @GetMapping("/clientes/{cedula}")
    public Optional<Cliente> obtenerCliente(@PathVariable long cedula) {
        return clienteRepository.findById(cedula); // Devuelve un cliente por cédula
    }

    @PostMapping("/clientes")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente); // Guarda un nuevo cliente
    }

    @PutMapping("/clientes/{cedula}")
    public Cliente actualizarCliente(@PathVariable long cedula, @RequestBody Cliente clienteActualizado) {
        return clienteRepository.findById(cedula)
                .map(cliente -> {
                    cliente.setNombre(clienteActualizado.getNombre());
                    cliente.setApellido1(clienteActualizado.getApellido1());
                    cliente.setDireccion(clienteActualizado.getDireccion());
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @DeleteMapping("/clientes/{cedula}")
    public void eliminarCliente(@PathVariable long cedula) {
        clienteRepository.deleteById(cedula); // Elimina un cliente por cédula
    }

    // Cursos - Obtener todos los cursos
@GetMapping("/cursos")
public List<Curso> obtenerCursos() {
    return cursoRepository.findAll(); // Devuelve la lista de cursos desde la base de datos
}

// Cursos - Crear un nuevo curso
@PostMapping("/cursos")
public Curso agregarCurso(@RequestBody Curso curso) {
    return cursoRepository.save(curso); // Guarda un curso nuevo
}

// Cursos - Actualizar un curso por ID
@PutMapping("/cursos/{id}")
public ResponseEntity<Curso> actualizarCurso(@PathVariable int id, @RequestBody Curso cursoDetalles) {
    Optional<Curso> curso = cursoRepository.findById(id);

    if (curso.isPresent()) {
        Curso cursoActualizado = curso.get();
        cursoActualizado.setDescripcion(cursoDetalles.getDescripcion());
        cursoActualizado.setNombre(cursoDetalles.getNombre());
        cursoActualizado.setHorario(cursoDetalles.getHorario());
        return ResponseEntity.ok(cursoRepository.save(cursoActualizado));
    } else {
        return ResponseEntity.notFound().build();
    }
}

// Cursos - Eliminar un curso por ID
@DeleteMapping("/cursos/{id}")
public ResponseEntity<Void> eliminarCurso(@PathVariable int id) {
    if (cursoRepository.existsById(id)) {
        cursoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}



/*package com.proyecto.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.backend.model.Curso;
import com.proyecto.backend.repository.CursoRepository;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hola, mundo!";
    }

    @GetMapping("/cursos")
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll(); // Devuelve la lista de cursos desde la base de datos
    }

    @PostMapping("/cursos")
public Curso agregarCurso(@RequestBody Curso curso) {
    Curso cursoGuardado = cursoRepository.save(curso);
    System.out.println("Curso guardado: " + cursoGuardado); // Esto mostrará el curso guardado en la consola
    return cursoGuardado;
}

    

    
}*/
