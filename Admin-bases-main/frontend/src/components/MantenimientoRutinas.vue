<template>
    <div class="mantenimiento-rutinas">
      <h1>Mantenimiento de Rutinas</h1>
      <form @submit.prevent="guardarRutina">
        <div>
          <label for="nombre">Nombre de la Rutina:</label>
          <input type="text" id="nombre" v-model="rutina.nombre" required />
        </div>
  
        <div>
          <label for="fecha">Fecha:</label>
          <input type="date" id="fecha" v-model="rutina.fecha" required />
        </div>
  
        <div>
          <label for="horas">Horas:</label>
          <input type="number" id="horas" v-model="rutina.horas" required />
        </div>
  
        <div>
          <label for="cliente">Cliente:</label>
          <select id="cliente" v-model="rutina.cliente">
            <option v-for="cliente in clientes" :key="cliente.cedula" :value="cliente.cedula">
              {{ cliente.nombre }} - {{ cliente.cedula }}
            </option>
          </select>
        </div>
  
        <div>
          <label for="instructor">Instructor:</label>
          <select id="instructor" v-model="rutina.instructor">
            <option v-for="instructor in instructores" :key="instructor.id" :value="instructor.id">
              {{ instructor.nombre }} - {{ instructor.id }}
            </option>
          </select>
        </div>
  
        <div>
          <label for="maquina">Máquina:</label>
          <select id="maquina" v-model="rutina.maquina">
            <option v-for="maquina in maquinas" :key="maquina.id_maquina" :value="maquina.id_maquina">
              {{ maquina.descripcion }} - {{ maquina.id_maquina }}
            </option>
          </select>
        </div>
  
        <button type="submit">Guardar Rutina</button>
      </form>
  
      <!-- Lista de rutinas -->
      <h2>Lista de Rutinas</h2>
      <ul>
        <li v-for="rutina in rutinas" :key="rutina.id_rutina">
          {{ rutina.nombre }} - {{ rutina.fecha }} - {{ rutina.horas }} horas
          <button @click="eliminarRutina(rutina.id_rutina)">Eliminar</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        rutina: {
          nombre: '',
          fecha: '',
          horas: 0,
          cliente: '',
          instructor: '',
          maquina: ''
        },
        clientes: [],
        instructores: [],
        maquinas: [],
        rutinas: []
      };
    },
    created() {
      this.cargarClientes();
      this.cargarInstructores();
      this.cargarMaquinas();
      this.cargarRutinas();
    },
    methods: {
      cargarClientes() {
        fetch('/api/clientes')
          .then(response => response.json())
          .then(data => {
            this.clientes = data;
          });
      },
      cargarInstructores() {
        fetch('/api/instructores')
          .then(response => response.json())
          .then(data => {
            this.instructores = data;
          });
      },
      cargarMaquinas() {
        fetch('/api/maquinas')
          .then(response => response.json())
          .then(data => {
            this.maquinas = data;
          });
      },
      cargarRutinas() {
        fetch('/api/rutinas')
          .then(response => response.json())
          .then(data => {
            this.rutinas = data;
          });
      },
      guardarRutina() {
        const nuevaRutina = {
          nombre: this.rutina.nombre,
          fecha: this.rutina.fecha,
          horas: this.rutina.horas,
          cliente: this.rutina.cliente,
          instructor: this.rutina.instructor,
          maquina: this.rutina.maquina
        };
        fetch('/api/rutinas', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(nuevaRutina)
        })
          .then(response => response.json())
          .then(data => {
            this.rutinas.push(data);
            this.limpiarFormulario();
          });
      },
      eliminarRutina(id_rutina) {
        fetch(`/api/rutinas/${id_rutina}`, {
          method: 'DELETE'
        }).then(() => {
          this.rutinas = this.rutinas.filter(rutina => rutina.id_rutina !== id_rutina);
        });
      },
      limpiarFormulario() {
        this.rutina = {
          nombre: '',
          fecha: '',
          horas: 0,
          cliente: '',
          instructor: '',
          maquina: ''
        };
      }
    }
  };
  </script>
  
  <style scoped>
  .mantenimiento-rutinas {
    padding: 20px;
  }
  </style>
  