module.exports = {
    publicPath: './',
    assetsDir: 'static',
    productionSourceMap: false,
    devServer: {
    host: '127.0.0.1',//前端服务器地址
      port:81,//前端运行的端口号
    open: true, //运行完启动命令后主动启动浏览器
    proxy: {
      // detail: https://cli.vuejs.org/config/#devserver-proxy
      ['/']: {
        target: `http://127.0.0.1`, //后台服务器接口地址与端口号
        changeOrigin: true,
        pathRewrite: {
          ['^/']: ''
        }
      }
    },
    disableHostCheck: true
  }
}