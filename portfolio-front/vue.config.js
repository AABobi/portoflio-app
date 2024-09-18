const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({

    transpileDependencies: true,
    lintOnSave: true,
  /*  css: {
        loaderOptions: {
            sass: {
                additionalData: `@import "@/core/css/global/index.scss";`,
            },
        },
    },*/
    devServer: {
        hot: true,
        port: 3333,
        proxy: 'http://localhost:8080'
        /* proxy: {
           '/api': {
             target: 'http://localhost:8080', // Your backend server URL
             changeOrigin: true,
             pathRewrite: { '/': '' },
           },
         },*/
    },
});