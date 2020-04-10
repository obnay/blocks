<template>
  <a-menu theme="dark" mode="inline" @click="handleClick">
    <template v-for="item in menus">
      <a-menu-item v-if="!item.children" :key="item.key">
        <a-icon type="pie-chart" />
        <span>{{item.title}}</span>
      </a-menu-item>
      <sub-menu v-else :menu-info="item" :key="item.key" />
    </template>
  </a-menu>
</template>

<script>
import SubMenu from "./../SubMenu";
export default {
  name: "MenuBar",
  data() {
    return {};
  },
  components: {
    SubMenu
  },
  props: {
    menus: {
      type: Array,
      required: true,
      default: () => []
    }
  },
  methods: {
    handleClick({ item, key, keyPath }) {
      /*
      if (this.$route.name === key) {
        return;
      } else {
        this.$router.push({ name: key });
      }
      */
    }
  }
};
</script>