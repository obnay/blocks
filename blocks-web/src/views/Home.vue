<template>
  <div class="home">
    <img alt="Vue logo" src="~@assets/logo.png" />
     <footer-bar></footer-bar>
  </div>
</template>

<script>
// @ is an alias to /src

import FooterBar from "@components/layout/FooterBar";
export default {
  name: "Home",
  components: {
    FooterBar
  }
};
</script>
