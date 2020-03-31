const path = require('path');
const CompressionPlugin = require('compression-webpack-plugin');

function resolve(dir) {
  return path.join(__dirname, dir);
}

module.exports = {
  // runtimeCompiler: true,
  devServer: {
    host: '0.0.0.0',
    port: 9000, // 端口
    open: true, // 配置自动启动浏览器
    proxy: {
      '/blocks': {
        target: 'http://127.0.0.1:8080', // 请求本地
        //target: 'http://10.173.23.48:9010', // 测试环境
        //target: 'http://10.173.23.23:9080', // 测试环境
        ws: false,
        changeOrigin: true,
      },
    },
  },
  lintOnSave: true, // eslint 验证,
  productionSourceMap: false, // 如果不需要生产时的源映射，那么将此设置为false可以加速生产构建

  // gzip
  configureWebpack: () => {
    if (process.env.NODE_ENV === 'production') {
      return {
        plugins: [new CompressionPlugin({
          test: /\.js$|\.html$|\.css/,
          threshold: 10240,
          deleteOriginalAssets: false,
        })],
      };
    }
  },

  chainWebpack: (config) => {

    // 热部署
    config.resolve.symlinks(true);

    config.resolve.alias
      .set('@$', resolve('src'))
      .set('@assets', resolve('src/assets'))
      .set('@comp', resolve('src/components'))
      .set('@request', resolve('src/request'))
      .set('@views', resolve('src/views'))
      .set('@utils', resolve('src/utils'));
  },

  css: {
    sourceMap: false,
  },
};
