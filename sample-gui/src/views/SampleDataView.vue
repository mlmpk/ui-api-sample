<script setup>
import { ref, reactive } from 'vue'

var someReactiveData = ref('huhu')

const runMethod = () => {
  someReactiveData.value = someReactiveData.value === 'huhu' ? 'haha' : 'huhu'
}

function doesTheSameButDefinedDifferent() {
  runMethod()
}

var reactiveObject = reactive({
  id: '0',
  content: 'empty',
  parameterValue: 'not available'
})

const fetchData = () => {
  fetch('http://localhost:8080/getData')
    .then((response) => response.json())
    .then((data) => {
      reactiveObject.id = data.id
      reactiveObject.content = data.content
      reactiveObject.parameterValue = data.parameterValue
    })
}

var pval = ref('')

const fetchDataWithParam = () => {
  fetch('http://localhost:8080/getData?param=' + pval.value)
    .then((response) => response.json())
    .then((data) => {
      reactiveObject.id = data.id
      reactiveObject.content = data.content
      reactiveObject.parameterValue = data.parameterValue
    })
}

var formdata = reactive({ val: '' })

const postData = () => {
  fetch('http://localhost:8080/create', {
    method: 'POST',
    body: JSON.stringify(formdata),
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    }
  })
    .then((response) => response.json())
    .then((data) => {
      reactiveObject.id = data.id
      reactiveObject.content = data.content
      reactiveObject.parameterValue = data.parameterValue
    })
}
</script>

<template>
  <div class="sample">
    <h2>Display reactive data</h2>
    <div class="card">
      <p>{{ someReactiveData }}</p>
    </div>
    <h2>Change data</h2>
    <div class="card">
      <button @click="runMethod">Push me!</button>
      <button @click="doesTheSameButDefinedDifferent">Does the same</button>
    </div>
    <h2>Display a reactive object</h2>
    <div class="card">
      {{ reactiveObject }}
    </div>
    <h2>Display object values</h2>
    <div class="card">
      <p>{{ reactiveObject.id }}</p>
      <p>{{ reactiveObject.content }}</p>
      <p>{{ reactiveObject.parameterValue }}</p>
    </div>
    <h2>Get data</h2>
    <div class="card">
      <button @click="fetchData">Fetch data!</button>
    </div>
    <h2>Get data with parameter</h2>
    <div class="card">
      <label for="param">Param:</label>
      <input id="param" v-model="pval" type="text" />
      <button @click="fetchDataWithParam">Fetch data with param!</button>
    </div>
    <h2>Post Data</h2>
    <div class="card">
      <label for="postparam">Post Param:</label>
      <input id="postparam" v-model="formdata.val" type="text" />
      <button @click="postData">Post data!</button>
    </div>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .sample {
    min-height: 100vh;
    display: flex;
    align-items: center;
    flex-direction: column;
  }
}

.card {
  border: 1px solid grey;
  padding: 2rem;
  margin: 2rem;
}
</style>
