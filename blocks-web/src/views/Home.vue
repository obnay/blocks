<template>
  <a-layout id="home-layout" style="min-height:100vh;">
    <a-layout-sider :trigger="null" collapsible v-model="collapsed">
      <div class="logo">
        <a href="/">
          <img alt="logo" src="~@/assets/logo.png" style="width:30%" />
        </a>
      </div>
      <menu-bar :menus="menus"></menu-bar>
    </a-layout-sider>
    <a-layout>
      <header-bar :collapsed.sync="collapsed"></header-bar>
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
      collapsed: false,
      menus: [
        {
          key: "1",
          title: "菜单一",
          icon: "book"
        },
        {
          key: "2",
          title: "菜单二",
          icon: "bug",
          children: [
            {
              key: "2.1",
              title: "Navigation 3",
              icon: "diff",
              children: [
                {
                  key: "2.1.1",
                  title: "Option 2.1.1",
                  icon: "edit",
                  children: [
                    { key: "2.1.1.1", title: "Option 2.1.1.1", icon: "crown" }
                  ]
                }
              ]
            },
            { key: "2.2", title: "Navigation 2", icon: "eye" }
          ]
        },
        {
          key: "3",
          title: "菜单三",
          icon: "cloud"
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
.logo {
  height: 32px;
  margin: 24px;
}
</style>
