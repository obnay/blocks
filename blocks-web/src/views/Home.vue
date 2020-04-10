<template>
  <a-layout id="home-layout" style="min-height:100vh;">
    <a-layout-sider>
      <menu-bar :menus="menus"></menu-bar>
    </a-layout-sider>
    <a-layout>
      <header-bar></header-bar>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <footer-bar></footer-bar>
    </a-layout>
  </a-layout>
</template>

<script>
import FooterBar from "@components/layout/FooterBar";
import HeaderBar from "@components/layout/HeaderBar";
import MenuBar from "@components/layout/MenuBar";
export default {
  name: "Home",
  data() {
    return {
      menus: [
        {
          key: "1",
          title: "Option 1"
        },
        {
          key: "2",
          title: "Navigation 2",
          children: [
            {
              key: "2.1",
              title: "Navigation 3",
              children: [
                {
                  key: "2.1.1",
                  title: "Option 2.1.1",
                  children: [{ key: "2.1.1.1", title: "Option 2.1.1.1" }]
                }
              ]
            },
            {  key: "2.2",
              title: "Navigation 2",}
          ]
        },
        {
          key: "3",
          title: "Option 3"
        }
      ]
    };
  },
  components: {
    FooterBar,
    HeaderBar,
    MenuBar
  }
};
</script>

<style scoped>
.content {
  margin: 24px 16px 0;
  padding: 24px;
  background: #fff;
  overflow: initial;
}
</style>
