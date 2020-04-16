<template>
  <a-layout-header class="header" id="layout-out" onselectstart="return false;">
    <div>
      <a-icon
        class="trigger"
        :type="collapsed ? 'menu-unfold' : 'menu-fold'"
        @click="onCollapsedClick"
      />
      <span>欢迎!</span>
      <div style="float:right;margin-right:16px;">
        <a-avatar size="small" icon="user" />
        <span style="margin-left:14px;margin-right:14px;">{{currentUser.name}}</span>
        <a class="logout" href="javascript:;" @click="handleLogout">
          <a-icon type="poweroff" />
          <span style="margin-left:4px;">退出</span>
        </a>
      </div>
    </div>
  </a-layout-header>
</template>

<script>
export default {
  name: "HeaderBar",
  data() {
    return {
      currentUser: { name: "admin" }
    };
  },
  props: {
    collapsed: {
      type: Boolean,
      default: false,
      required: true
    }
  },
  methods: {
    onCollapsedClick() {
      this.$emit("update:collapsed", !this.collapsed);
    },
    handleLogout() {
      const _this = this;
      this.$confirm({
        title: "提示",
        content: "真的要注销登录吗 ?",
        onOk() {
          _this.onLogout();
        },
        onCancel() {}
      });
    },
    onLogout() {
      console.log("logout");
    }
  }
};
</script>

<style scoped lang="less">
.header {
  background: #fff;
  padding: 0;
}
#layout-out .trigger {
  font-size: 18px;
  line-height: 80px;
  padding: 0 24px;
  cursor: pointer;
  transition: color 0.3s;
}
#layout-out .trigger:hover {
  color: #1890ff;
}
.logout {
  color: inherit;
  text-decoration: none;
}
</style>