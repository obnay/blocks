<template>
  <a-layout-footer align="center" class="footer">
    <div>
      <span>
        Blocks software ©2020 Created by Obnay
        <a
          href="https://github.com/obnay/blocks"
          target="_blank"
        >
          <a-icon type="github" />
        </a>
      </span>
    </div>
  </a-layout-footer>
</template>

<script>
export default {
  name: "FooterBar",
  methods: {
    gotoGithub() {
      window.open("https://github.com/obnay/blocks", "_blank");
    }
  }
};
</script>

<style scoped>
.footer {
  padding: 0;
}
.footer div {
  margin: 10px 0;
}
.github {
  cursor: pointer;
}
</style>