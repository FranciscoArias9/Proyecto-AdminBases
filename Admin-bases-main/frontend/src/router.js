import { createRouter, createWebHistory } from 'vue-router';
import AppIngreso from './components/AppIngreso.vue';
import AppContactos from './components/AppContactos.vue';
import ServicioInscripcion from './components/servicios/ServicioInscripcion.vue';
import AppInicio from './components/AppInicio.vue';
import ServicioCurso from './components/servicios/ServicioCurso.vue';
import AgregarCurso from './components/servicios/AgregarCurso.vue';
import MantenimientoRutina from './components/servicios/MantenimientoRutina.vue'; // Importar el componente
import ServicioCliente from './components/servicios/ServicioCliente.vue'; // Importar ServicioCliente
import AgregarCliente from './components/servicios/AgregarCliente.vue';
//import AppIngreso from './components/AppIngreso.vue';
import MantenimientoClientes from './components/MantenimientoClientes.vue';
import MantenimientoMaquinas from './components/MantenimientoMaquinas.vue';
import MantenimientoCursos from './components/MantenimientoCursos.vue';
import MantenimientoRutinas from './components/MantenimientoRutinas.vue';
const routes = [
  { path: '/', component: AppInicio },
  { path: '/contactos', component: AppContactos },
  { path: '/ingreso', component: AppIngreso },
  { path: '/servicios/inscripcion', component: ServicioInscripcion },
  { path: '/servicios/cursos', component: ServicioCurso },
  { path: '/servicios/agregar-curso', component: AgregarCurso }, // Nueva ruta para agregar curso
  { path: '/servicios/rutinas', component: MantenimientoRutina }, // Nueva ruta para mantenimiento de rutinas
  { path: '/servicios/clientes', component: ServicioCliente },  // Nueva ruta para ver clientes
  { path: '/servicios/agregar-cliente', component: AgregarCliente },
  { path: '/', component: AppIngreso },
  { path: '/clientes/mantenimiento', component: MantenimientoClientes },  // Nueva ruta
  { path: '/maquinas/mantenimiento', component: MantenimientoMaquinas },
  { path: '/cursos/mantenimiento', component: MantenimientoCursos },
  { path: '/rutinas/mantenimiento', component: MantenimientoRutinas }

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
