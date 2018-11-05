
<template>
  <div>
  <b-container class="bv-example-row">
      <b-row class="justify-content-md-center">
      <b-col cols="6">
      <b-col offset-md="3"> 
      <h2>Agregar Actor:</h2>
      </b-col>
      <br/>
      <b-form >
      <b-form-group id="input1"
                    label="Nombre:"
                    label-for="firstName"
                    >
        <b-form-input id="exampleInput1"
                      type="text"
                      required
                      v-model="firstName"
                      placeholder="Ingrese nombre actor">
        </b-form-input>
      </b-form-group>
      <b-form-group id="inputGroup2"
                    label="Apellido:"
                    label-for="lastName">
        <b-form-input id="exampleInput2"
                      type="text"
                      required
                      v-model="lastName"
                      placeholder="Ingrese apellido actor">
        </b-form-input>
      </b-form-group>
      
       <b-col md="3" offset-md="5"> 
        <b-button type="submit" @click="this.save" variant="primary">Agregar</b-button>
       </b-col>

    </b-form>
    </b-col>     
    </b-row>
</b-container>

</div>
</template>
<script>
export default {
  data(){
    return{
      firstName:"",
      lastName:""
    }
  },
   methods:{
     save:function(){
    console.log('Index.vue');
    const actor={
      firstName:this.firstName,
      lastName:this.lastName
    }

    //POST
    this.$http.post('http://localhost:8085/sakila-spring-backend/actors',actor)
    .then(response=>{
       // get body data
       console.log(response.data);
       this.firstName = "";
       this.lastName="";
       alert("Se ha agregado el actor con éxito");
       
    }, response=>{
       // error callback
       console.log('error ');
    })
     }
  }
}
</script>