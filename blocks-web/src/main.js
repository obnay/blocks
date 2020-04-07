import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import './registerServiceWorker';

import {
    Button,
    Form,
    Icon,
    Input,
    Checkbox,
    Row,
    Col,
    Layout,
    Modal,
    notification,
    message,
    Menu,
    Card,
    Tabs,
    Breadcrumb,
    Rate,
    Divider,
    Avatar,
    Collapse,
    List,
    Skeleton,
    Tag,
    Switch,
    Radio,
    Tooltip,
    Dropdown,
    Popconfirm,
    Spin,
    Table,
    Pagination,
    LocaleProvider,
    DatePicker,
    Select,
    InputNumber,
    Empty,
    Statistic,
    Carousel,
} from 'ant-design-vue';

Vue.prototype.$message = message;
Vue.prototype.$notification = notification;
Vue.prototype.$info = Modal.info;
Vue.prototype.$success = Modal.success;
Vue.prototype.$error = Modal.error;
Vue.prototype.$warning = Modal.warning;
Vue.prototype.$confirm = Modal.confirm;

Vue.use(Button);
Vue.use(Form);
Vue.use(Icon);
Vue.use(Input);
Vue.use(Checkbox);
Vue.use(Row);
Vue.use(Col);
Vue.use(Layout);
Vue.use(Pagination);
Vue.use(Modal);
Vue.use(Menu);
Vue.use(Card);
Vue.use(Tabs);
Vue.use(Breadcrumb);
Vue.use(Rate);
Vue.use(Divider);
Vue.use(Avatar);
Vue.use(Collapse);
Vue.use(Skeleton);
Vue.use(List);
Vue.use(Dropdown);
Vue.use(Tag);
Vue.use(Switch);
Vue.use(Radio);
Vue.use(Spin);
Vue.use(Popconfirm);
Vue.use(Tooltip);
Vue.use(Table);
Vue.use(LocaleProvider);
Vue.use(DatePicker);
Vue.use(Select);
Vue.use(InputNumber);
Vue.use(Empty);
Vue.use(Statistic);
Vue.use(Carousel);

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app');
