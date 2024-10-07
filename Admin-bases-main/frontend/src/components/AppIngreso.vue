<template>
<section class="vh-75">
  <div class="container py-4 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-4 text-center">
            <div class="mb-md-4 mt-md-3 pb-4">
              <h2 class="fw-bold mb-2 text-uppercase">Ingreso</h2>
              <p class="text-white-50 mb-5">Por favor, iniciar sesion</p>
              <div data-mdb-input-init class="form-outline form-white mb-3">
                <input type="email" id="typeEmailX" class="form-control form-control-lg" />
                <label class="form-label" for="typeEmailX">Correo</label>
              </div>
              <div data-mdb-input-init class="form-outline form-white mb-3">
                <input type="password" id="typePasswordX" class="form-control form-control-lg" />
                <label class="form-label" for="typePasswordX">Contraseña</label>
              </div>
              <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Se me olvido la contraseña</a></p>
              <button data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-light btn-lg px-4" type="submit">Iniciar sesion</button>
            </div>
            <div>
              <p class="mb-0">¿No tienes cuenta? 
                <router-link to="/servicios/inscripcion" class="text-white-50 fw-bold">Inscribirse</router-link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</template>

<script>
export default {
  name: 'AppIngreso'
}
</script>