import { createRouter, createWebHistory } from 'vue-router';
import AppIngreso from './components/AppIngreso.vue';
import AppContactos from './components/AppContactos.vue';
import ServicioInscripcion from './components/servicios/ServicioInscripcion.vue';
import AppInicio from './components/AppInicio.vue';
import ServicioCurso from './components/servicios/ServicioCurso.vue';
import AgregarCurso from './components/servicios/AgregarCurso.vue';

const routes = [
  { path: '/', component: AppInicio },
  { path: '/contactos', component: AppContactos},
  { path: '/ingreso', component: AppIngreso},
  { path: '/servicios/inscripcion', component:ServicioInscripcion},
  {path: '/servicios/cursos', component: ServicioCurso},
  { path: '/servicios/agregar-curso', component: AgregarCurso }, // Nueva ruta para agregar curso
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
