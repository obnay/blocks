<template>
  <a-layout-footer style="textAlign: center;">
    <div>
      <span>
        Software Blocks ©2020 Created by Obnay
        <github-button
          href="https://github.com/obnay/blocks"
          aria-label="Star obnay/blocks on GitHub"
        >Star</github-button>
      </span>
    </div>
  </a-layout-footer>
</template>

<script>
import GithubButton from "vue-github-button";
export default {
  name: "FooterBar",
  components: {
    GithubButton
  }
};
</script>

<style scoped>
</style>