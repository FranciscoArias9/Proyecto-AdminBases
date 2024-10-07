<template>
      <nav class="navbar navbar-expand-lg bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand text-white">Gimnasio</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link to="/" class="nav-link">Inicio</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/contactos" class="nav-link">Contactos</router-link>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Servicios
              </a>
              <ul class="dropdown-menu bg-dark">
                <li><router-link to="/servicios/inscripcion" class="dropdown-item">Inscripción</router-link></li>
                <li><router-link to="/servicios/cursos" class="dropdown-item">Cursos</router-link></li>
                <li><router-link to="/servicios/maquinas" class="dropdown-item">Máquinas</router-link></li>
                <li><router-link to="/servicios/instructores" class="dropdown-item">Instructores</router-link></li>
              </ul>
            </li>
            <!--opciones de entrenadores-->
              <li class="nav-item" v-if="isAuthenticated && userRole=='entrenador'">
                <router-link to="/instructores/mantenimiento" class="nav-link">Mantenimiento</router-link>
              </li>
              <li class="nav-item" v-if="isAuthenticated && userRole=='entrenador'">
                <router-link to="/instructores/cliente" class="nav-link">Cliente</router-link>
              </li>
              <li class="nav-item" v-if="isAuthenticated && userRole=='entrenador'">
                <router-link to="/instructores/cursos" class="nav-link">Cursos</router-link>
              </li>
              <li class="nav-item" v-if="isAuthenticated && userRole=='entrenador'">
                <router-link to="/instructores/rutinas" class="nav-link">Rutinas</router-link>
              </li>
            <!--opciones para cliente-->
            <li class="nav-item" v-if="isAuthenticated && userRole == 'cliente'">
              <router-link to="/clientes/inscribirse" class="nav-link">Inscribirse</router-link>
            </li>
            <li class="nav-item" v-if="isAuthenticated && userRole == 'cliente'">
              <router-link to="/clientes/desinscribirse" class="nav-link">Desinscribirse</router-link>
            </li>
            <!--sesion-->
            <li class="nav-item" v-if="isAuthenticated">
              <a href="#" to="/logout" @click.prevent="logout" class="nav-link">Cerrar sesión</a>
            </li>
            <li class="nav-item" v-else>
              <router-link to="/ingreso" class="nav-link">Ingreso</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
</template>

<script>
export default{
  name: 'NavBar',
  props: {},
  data(){
    return{
      isAuthenticated: true,
      userRole: 'entrenador'
    };
  },
  methods:{
    logout() {
      localStorage.removeItem('authToken')
      this.isAuthenticated=false;
      this.userRole= null;
      this.$router.push('/ingreso');
    }
  }
}
</script>

<style scoped>
.navbar-nav .nav-link,
.navbar-nav .dropdown-item {
  color: white !important;
}

.navbar-nav .dropdown-menu .dropdown-item:hover,
.navbar-nav .dropdown-menu .dropdown-item:focus {
  background-color: rgb(6, 6, 6);
}

.navbar-nav .dropdown-toggle::after {
  color: white;
}
.navbar-toggler {
  border-color: rgba(255, 255, 255, 0.5);
}

.navbar-toggler-icon {
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3E%3Cpath stroke='rgba%28255, 255, 255, 1%29' stroke-linecap='round' stroke-miterlimit='10' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
}
</style>