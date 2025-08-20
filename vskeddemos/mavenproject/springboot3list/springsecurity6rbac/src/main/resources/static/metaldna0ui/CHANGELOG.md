# Changelog

All notable changes to this project will be documented in this file. See [standard-version](https://github.com/conventional-changelog/standard-version) for commit guidelines.

## [2.9.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.8.1...v2.9.0) (2024-09-07)


### Features

* The dialog supports custom-defined window size. [#527](https://github.com/kailong321200875/vue-element-plus-admin/issues/527) ([e6affad](https://github.com/kailong321200875/vue-element-plus-admin/commit/e6affad67fed5e815563396e7ce6ab816ee737ce))
* 全局默认box-sizing: border-box;降低元素布局难度。 ([a27b14e](https://github.com/kailong321200875/vue-element-plus-admin/commit/a27b14e7ffeeeae6a212f262d20303db02b017f1))


### Bug Fixes

* VideoPlayer 的实例未赋值 [#524](https://github.com/kailong321200875/vue-element-plus-admin/issues/524) ([0e99f83](https://github.com/kailong321200875/vue-element-plus-admin/commit/0e99f8374a6c4aac19da9105c9b0c1f4950f87c7))
* 修复husky问题 ([7b8e58e](https://github.com/kailong321200875/vue-element-plus-admin/commit/7b8e58e0ec81e99517cbca41e04930f013773380))
* 修复isUrl判断错误bug  [#526](https://github.com/kailong321200875/vue-element-plus-admin/issues/526) ([3cd89bd](https://github.com/kailong321200875/vue-element-plus-admin/commit/3cd89bdd09ee45d97d1ea41a5ee7686ca56c4ff2))
* 修复在表格中给按钮添加link属性后，字体颜色变成白色 [#490](https://github.com/kailong321200875/vue-element-plus-admin/issues/490) ([5d9ca8a](https://github.com/kailong321200875/vue-element-plus-admin/commit/5d9ca8ac629adeb3d9c5fbf908502e597da7a168))
* 修复新增权限时 id 缺失前端判断错误问题 ([88a0440](https://github.com/kailong321200875/vue-element-plus-admin/commit/88a04404d429e0a7e258fc8974e328dcbc04ae7a))
* 修复示例图标错误 ([a07f4e9](https://github.com/kailong321200875/vue-element-plus-admin/commit/a07f4e9925ba15b3a94ddbea1908e42c2184b4cb))
* 修复非一级子菜单显示位置错误；修改滚动条样式和系统滚动条样式一致 ([e0596ef](https://github.com/kailong321200875/vue-element-plus-admin/commit/e0596ef9f1f3ed022396961bf2a82665bebaecf7))
* 左侧菜单收起后，组件菜单的子菜单显示不全 ([574055c](https://github.com/kailong321200875/vue-element-plus-admin/commit/574055c2749b9a183af44a0aaacab45f898cfff2))


### Docs

* 修改readme ([367b350](https://github.com/kailong321200875/vue-element-plus-admin/commit/367b3508e8efaf4b2b8383f44c3fea0e1dd09e8e))


### Performance Improvements

* 移除scrollbar__view高度限定。 ([18b08e2](https://github.com/kailong321200875/vue-element-plus-admin/commit/18b08e2983c116228de5282cd6e0c84884b24238))

## [2.8.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.8.0...v2.8.1) (2024-06-20)


### Bug Fixes

* [#458](https://github.com/kailong321200875/vue-element-plus-admin/issues/458) ([49451ae](https://github.com/kailong321200875/vue-element-plus-admin/commit/49451ae606009d1f5ab0b98f84535892d3fd7646))
* [#481](https://github.com/kailong321200875/vue-element-plus-admin/issues/481) ([c77586c](https://github.com/kailong321200875/vue-element-plus-admin/commit/c77586c5670cdc63978b032bbda694a14e875838))
* 修复 search组件的收起展开 和重置 Bug ([9a5c7bc](https://github.com/kailong321200875/vue-element-plus-admin/commit/9a5c7bcb5b51e76eac6bc1d3aebc287593b13ca1))
* 修复css前缀无法应用问题([#482](https://github.com/kailong321200875/vue-element-plus-admin/issues/482)) ([4b43c87](https://github.com/kailong321200875/vue-element-plus-admin/commit/4b43c87949fe4a68b4be004a06dfff4c7f87fbd4))
* 修复表格default-expand-all属性无效BUG ([6657bbc](https://github.com/kailong321200875/vue-element-plus-admin/commit/6657bbc9f11f22cbfb04a57f5629bc810575496e))
* 修复表格合计报错问题 ([9c44006](https://github.com/kailong321200875/vue-element-plus-admin/commit/9c44006ec26bee446dc5c90b6a4546cdd84ba4dc))


### Styling

* 修改登录页样式 ([9f98b7b](https://github.com/kailong321200875/vue-element-plus-admin/commit/9f98b7be266825612f93135c460d7db2d6a8beb0))


### Performance Improvements

* 优化使用离线图标后运行慢问题 ([7e9c4a6](https://github.com/kailong321200875/vue-element-plus-admin/commit/7e9c4a6109b417a577d9ac9ecf02db52eb1964af))

## [2.8.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.7.0...v2.8.0) (2024-06-01)


### Types

* 修复Table类型错误 ([79b917a](https://github.com/kailong321200875/vue-element-plus-admin/commit/79b917af4957aa4b47db46e034385477828f5fca))


### Features

* Add a new component CodeEditor ([#466](https://github.com/kailong321200875/vue-element-plus-admin/issues/466)) ([00989b7](https://github.com/kailong321200875/vue-element-plus-admin/commit/00989b7ac9b92685be495c15c1f11dd2546eb6be))


### Bug Fixes

* [#427](https://github.com/kailong321200875/vue-element-plus-admin/issues/427) ([a00d76e](https://github.com/kailong321200875/vue-element-plus-admin/commit/a00d76e4149b430e19c985a78b9d89ce992dba3f))
* [#428](https://github.com/kailong321200875/vue-element-plus-admin/issues/428) ([97a1cd4](https://github.com/kailong321200875/vue-element-plus-admin/commit/97a1cd41de82dad8855c95cec6bb106541fd53a7))
* [#432](https://github.com/kailong321200875/vue-element-plus-admin/issues/432) ([df5b716](https://github.com/kailong321200875/vue-element-plus-admin/commit/df5b7166b48b7e0e77a1fb10ab6dd353d186547e))
* [#438](https://github.com/kailong321200875/vue-element-plus-admin/issues/438) ([f977fdb](https://github.com/kailong321200875/vue-element-plus-admin/commit/f977fdb05d018ee07baeb6db454b9a77acb89f07))
* [#451](https://github.com/kailong321200875/vue-element-plus-admin/issues/451) ([08665a3](https://github.com/kailong321200875/vue-element-plus-admin/commit/08665a35ac606549322039d073daf8072053eef4))
* [#465](https://github.com/kailong321200875/vue-element-plus-admin/issues/465) ([8996e01](https://github.com/kailong321200875/vue-element-plus-admin/commit/8996e01ca35bfad8c13bef321f86bdd711202e12))
* less 变量命名与 css 关键字冲突 [#475](https://github.com/kailong321200875/vue-element-plus-admin/issues/475) ([1c56e13](https://github.com/kailong321200875/vue-element-plus-admin/commit/1c56e13c5523a86d77464eccee26b5408db028c7))
* 修复 lint-staged 中 prettier 以 json 格式美化代码的无效命令问题 ([7b2eae1](https://github.com/kailong321200875/vue-element-plus-admin/commit/7b2eae1d6aa813e162c3ad4a0553d2df480c765f))
* 修复 Transfer 组件 optionApi 不生效 ([198718b](https://github.com/kailong321200875/vue-element-plus-admin/commit/198718b8749a036263d756f928b5dd38cfb47701))
* 修复富文本编辑器初始化时, 报错 Error: Cannot find a descendant at path [0,1] in node ([a65d5fd](https://github.com/kailong321200875/vue-element-plus-admin/commit/a65d5fd20334307a56cb469361e8f9bd838510c9))
* 修复组件-查询界面：收起和展开功能bug [#473](https://github.com/kailong321200875/vue-element-plus-admin/issues/473) ([8e58eae](https://github.com/kailong321200875/vue-element-plus-admin/commit/8e58eaeed6ea9beb749afaed75edc5a4f6d9867a))


### Docs

* 更新群二维码 ([2c89dbc](https://github.com/kailong321200875/vue-element-plus-admin/commit/2c89dbc884c38511d40c92480f65aef46511cefb))


### Performance Improvements

* 已经是 FormData 对象的不用再次转换 ([d582ad4](https://github.com/kailong321200875/vue-element-plus-admin/commit/d582ad428f4b378014d063635c4afbbad944a71a))

## [2.7.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.6.0...v2.7.0) (2024-02-29)


### Features

* IAgree ([abb6906](https://github.com/kailong321200875/vue-element-plus-admin/commit/abb69064dfdb979e2843e3a1b62a2510f6ed3637))
* 头像列表 ([3bf28a5](https://github.com/kailong321200875/vue-element-plus-admin/commit/3bf28a5d4555bf2a10754474db81d70b04ee432a))
* 新增个人中心页 ([4146716](https://github.com/kailong321200875/vue-element-plus-admin/commit/4146716655bfbe4ae5b780e5b52a6377efd914ec))


### Bug Fixes

* 修复启动慢问题 ([61d7ef6](https://github.com/kailong321200875/vue-element-plus-admin/commit/61d7ef642a027e9e1f942bc84322233be3ca9a82))
* 修复第四种布局样式层级问题([#424](https://github.com/kailong321200875/vue-element-plus-admin/issues/424)) ([78aeb89](https://github.com/kailong321200875/vue-element-plus-admin/commit/78aeb897fc93cfb998f94578d1fbe4480426843f))


### Docs

* 更新群二维码 ([c8c1a1b](https://github.com/kailong321200875/vue-element-plus-admin/commit/c8c1a1b6357105da73e23adff968c3f2fad7d837))

## [2.6.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.6...v2.6.0) (2024-02-07)


### Features

* add vite-plugin-url-copy ([f5ab977](https://github.com/kailong321200875/vue-element-plus-admin/commit/f5ab9776a90e0136b243601571f4619c20da3ccd))


### Bug Fixes

* Table组件中size属性的validator设置错误 ([f30e37e](https://github.com/kailong321200875/vue-element-plus-admin/commit/f30e37ee777d4f30d4ae58c4a016a1392d41c25f))
* Table组件注册为全局组件报错问题，存在对pinia的提前引用 ([1e209a7](https://github.com/kailong321200875/vue-element-plus-admin/commit/1e209a702a5114943a615063eefd0c00f1a6a003))
* Table组件设置 align="center" 导致横向滚动条位置错误问题 ([22f071d](https://github.com/kailong321200875/vue-element-plus-admin/commit/22f071d9268806f7abd23ab2d08e9392e377a426))
* 修复 element-plus 2.5版本以上，el-form-item inline模式下，select宽度问题 ([f44e48d](https://github.com/kailong321200875/vue-element-plus-admin/commit/f44e48d08d3f8dd347b829166107dd62e5e18c72))
* 修复 prettier 报错 ([f5f08f8](https://github.com/kailong321200875/vue-element-plus-admin/commit/f5f08f8f87b063d489f55ea8f19c7c802acf15f7))
* 修复 useCrudSchemas 详情组件数据结构文案不匹配问题 ([d94fc0a](https://github.com/kailong321200875/vue-element-plus-admin/commit/d94fc0a701bcbc9343ab3e7b630e3db8f6d61623))
* 修复cutMenu布局刷新样式问题 ([03580b0](https://github.com/kailong321200875/vue-element-plus-admin/commit/03580b0ca0c8d088589ae1d8426b1535f654361b))
* 修复Menu组件缩略菜单弹窗内样式不统一问题 ([d5dc4e3](https://github.com/kailong321200875/vue-element-plus-admin/commit/d5dc4e32d5978fcd271e841832c9cbf1e0c87db7))
* 修复TagsView右键菜单逻辑错误 ([901c891](https://github.com/kailong321200875/vue-element-plus-admin/commit/901c891872ef6164e3517eb8e798d6039b7b7f4e))
* 修复test打包VITE_USE_ONLINE_ICON无效问题 ([a3436a3](https://github.com/kailong321200875/vue-element-plus-admin/commit/a3436a32c6fd746e9e2af67c3cc5a8872aabf919))
* 修复本地化图标空白问题 ([14ff83a](https://github.com/kailong321200875/vue-element-plus-admin/commit/14ff83affcd267fbdb405d2f46e9f929a1fbfaeb))
* 修复请求示例中，mock开启时无法取消单个请求的问题 ([d6d70a4](https://github.com/kailong321200875/vue-element-plus-admin/commit/d6d70a443cccb2fe12161b57a1f227d1ed63384a))
* 修改兼容方式，兼容Form 组件中contentMap中类输入框或下拉选择的所有组件，特殊兼容 InputNumber 组件 ([ab98ceb](https://github.com/kailong321200875/vue-element-plus-admin/commit/ab98ceb85f52c5f7b87c2114997c63f1b80f216f))
* 更换判断条件 ([b5cb626](https://github.com/kailong321200875/vue-element-plus-admin/commit/b5cb626bfac4df8b1a0741b5000d5b22f6cd4555))


### Docs

* 修改群二维码 ([395ff68](https://github.com/kailong321200875/vue-element-plus-admin/commit/395ff68412ff71a9b8ce670c2399da285cfed67d))
* 更新群二维码 ([c8ccaa8](https://github.com/kailong321200875/vue-element-plus-admin/commit/c8ccaa8d49b5bf7a2784a29af6e126657ce54cda))


### Styling

* 添加TabMenu边框 ([feb3d9a](https://github.com/kailong321200875/vue-element-plus-admin/commit/feb3d9a8d07f6444c39ca89f6eb63245c06783a0))

## [2.5.6](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.5...v2.5.6) (2024-01-18)


### Bug Fixes

* [#396](https://github.com/kailong321200875/vue-element-plus-admin/issues/396) ([9b2b4d4](https://github.com/kailong321200875/vue-element-plus-admin/commit/9b2b4d42a6d5fffd5012506b7cac3892774c8595))
* [#399](https://github.com/kailong321200875/vue-element-plus-admin/issues/399) ([59d4ed4](https://github.com/kailong321200875/vue-element-plus-admin/commit/59d4ed4dd9d6b6f0d5881b4d466e7a621770ad75))
* 修复Form组件设置了hidden还是会出现占位空白 ([0f531fd](https://github.com/kailong321200875/vue-element-plus-admin/commit/0f531fd1d0469ddd56327b0a9a7956a0d6076c91))
* 修复无法登录问题 ([8ce00ab](https://github.com/kailong321200875/vue-element-plus-admin/commit/8ce00ab247de4061cb56f9c2f6d3079abd39aefd))
* 修复菜单管理回显问题 ([d9ca9ba](https://github.com/kailong321200875/vue-element-plus-admin/commit/d9ca9ba5e8111b7cc3758a8bba14f7fac45c9446))
* 升级依赖,修复vue警告 ([eafb507](https://github.com/kailong321200875/vue-element-plus-admin/commit/eafb5075d587feac0501a1adae90a176a72c240f))


### Docs

* 更新README ([28bd10f](https://github.com/kailong321200875/vue-element-plus-admin/commit/28bd10f26373ad6e139b412e08d1e2afacc4ab92))


### Styling

* 调整样式 ([09b96c7](https://github.com/kailong321200875/vue-element-plus-admin/commit/09b96c75425cd2d931e7df4ef3f330b78bf74f9e))


### Performance Improvements

* request请求根据ContentType自动转换数据 ([ef9aa62](https://github.com/kailong321200875/vue-element-plus-admin/commit/ef9aa625724b754afc565b8b1f2589376f4d5c50))
* 使用flex布局，优化section区域min-height的繁琐计算 ([fbb6f9a](https://github.com/kailong321200875/vue-element-plus-admin/commit/fbb6f9ad4b6d5fac9bb95d0a9250b5a318680d99))

## [2.5.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.4...v2.5.5) (2024-01-06)


### Bug Fixes

* [#276](https://github.com/kailong321200875/vue-element-plus-admin/issues/276) ([6fbc2b0](https://github.com/kailong321200875/vue-element-plus-admin/commit/6fbc2b0243e4aec0463a734c37591dc3de40f7db))
* el-button组件和其他部分使用到相关变量的组件无法适配主题色变化问题 ([00cac6a](https://github.com/kailong321200875/vue-element-plus-admin/commit/00cac6a831c2a0bb2f8a9df8b9264f1cad13ddde))


### Styling

* 菜单支持超出省略号 ([a926c56](https://github.com/kailong321200875/vue-element-plus-admin/commit/a926c5607a162145f77d35762b3d6730d67b23f6))
* 菜单背景支持跟随暗黑模式 ([b34aeba](https://github.com/kailong321200875/vue-element-plus-admin/commit/b34aeba10a464a0f92752fc966386286443df53a))


### Performance Improvements

* 优化ImageCropping ([069777c](https://github.com/kailong321200875/vue-element-plus-admin/commit/069777c8801c51ab28c070b2ba3f10000e9c91b4))
* 图标选择器逻辑优化 ([c2dde25](https://github.com/kailong321200875/vue-element-plus-admin/commit/c2dde252297c94036221d5d9971781182bc2998e))
* 表格组件预览字段拆分 ([8c5858e](https://github.com/kailong321200875/vue-element-plus-admin/commit/8c5858e2c5d42db1de37d5290ea2ca784f4d4612))

## [2.5.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.3...v2.5.4) (2023-12-26)


### Types

* 修复全局组件属性类型无法推导 ([94160c0](https://github.com/kailong321200875/vue-element-plus-admin/commit/94160c0418816e560f440e259e1f0fd4742e0143))


### Bug Fixes

* Menu菜单组件显示bug，renderMenuItem返回的数组存在undefined数据，导致省略菜单显示问题 ([1c63757](https://github.com/kailong321200875/vue-element-plus-admin/commit/1c63757d55076d15ffdf21d647de393ca3c6b0be))
* useClipboard在ip地址下不能使用问题 ([f3593c4](https://github.com/kailong321200875/vue-element-plus-admin/commit/f3593c453a8b8d5eb8cbd0ed5402132b027461b9))
* 修复request请求自定义headers类型错误 ([bf2cd72](https://github.com/kailong321200875/vue-element-plus-admin/commit/bf2cd720d0e5801603848a0b1520a928443ac549))
* 修复切换主题色缓存失败 ([1074520](https://github.com/kailong321200875/vue-element-plus-admin/commit/10745207e64d2d444636cb9d877cec9a0bebf1eb))
* 修复非正式环境打包报错 ([3a5db42](https://github.com/kailong321200875/vue-element-plus-admin/commit/3a5db42c97f382f3fc701b8f113385b38a214583))


### Styling

* 本地化图标 ([608bf50](https://github.com/kailong321200875/vue-element-plus-admin/commit/608bf50e1cae49b7f97587395f794ae351f833f0))
* 添加常见问题链接 ([16b9375](https://github.com/kailong321200875/vue-element-plus-admin/commit/16b93757d32c8ce2f611a62d6015072b0ecfc09a))


### Code Refactoring

* 新增列设置 ([7314065](https://github.com/kailong321200875/vue-element-plus-admin/commit/7314065c907f8ef4d184c1f3c724b67c30410ab9))
* 重写useEventBus ([8035151](https://github.com/kailong321200875/vue-element-plus-admin/commit/80351516ced0ec2d67c30405d4a644aca8ca4bc2))


### Performance Improvements

* 优化启动速度 ([379b340](https://github.com/kailong321200875/vue-element-plus-admin/commit/379b340750eb0d4f7816f5d7c25cbd2983fd33b9))
* 还原mock.js ([83de387](https://github.com/kailong321200875/vue-element-plus-admin/commit/83de387e2a0124804a9c99080ac841a9d6676fca))

## [2.5.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.2...v2.5.3) (2023-12-17)


### Bug Fixes

* [#374](https://github.com/kailong321200875/vue-element-plus-admin/issues/374) ([30fb2de](https://github.com/kailong321200875/vue-element-plus-admin/commit/30fb2de6f37fe0bb00b0f364da31b07a292d59a1))
* 修复cutMenu布局和top布局内容高度计算错误问题 ([8badd48](https://github.com/kailong321200875/vue-element-plus-admin/commit/8badd48a699aabd8fe510052d098fa6848ff5cbd))
* 修复动态路由多开标签页404问题 ([1c5b16f](https://github.com/kailong321200875/vue-element-plus-admin/commit/1c5b16f529d2e60a1eefcadf3f416585d1adb93b))
* 修复类型推导错误 ([649fb17](https://github.com/kailong321200875/vue-element-plus-admin/commit/649fb17d000c0d500ffcfe1f9ab6ddd73ab7ecfa))
* 修复项目配置清楚缓存无效 ([a09ee60](https://github.com/kailong321200875/vue-element-plus-admin/commit/a09ee60bb123f5bc4bbe6d80539145d5c4b94cb8))


### Code Refactoring

* 重构描述组件样式 ([c7658d8](https://github.com/kailong321200875/vue-element-plus-admin/commit/c7658d8c70618045a7527156444ba1d564963325))


### Performance Improvements

* 优化登录记住我流程 ([2009594](https://github.com/kailong321200875/vue-element-plus-admin/commit/2009594f089722151b739598dbad5ee7fb062b6e))

## [2.5.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.1...v2.5.2) (2023-12-10)


### Bug Fixes

* 修复mock无法使用问题 ([319aaef](https://github.com/kailong321200875/vue-element-plus-admin/commit/319aaef7eec6287a0e80f25a479918d43c051810))

## [2.5.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.5.0...v2.5.1) (2023-12-10)


### Bug Fixes

* 修复表单回车刷新页面 ([2f64836](https://github.com/kailong321200875/vue-element-plus-admin/commit/2f6483652b5d130057b4422b0f3350542b4b4b1d))
* 表单布局方式为top时，查询组件按钮位置错位 ([ca98359](https://github.com/kailong321200875/vue-element-plus-admin/commit/ca983590da72cb13392cb8897f4045fbacbc6c8d))


### Docs

* 更新Readme ([81d2dc6](https://github.com/kailong321200875/vue-element-plus-admin/commit/81d2dc6a43df8fd5799461cdafc1b7e6054cf1e1))


### Styling

* 修改视频表格样式 ([93767b6](https://github.com/kailong321200875/vue-element-plus-admin/commit/93767b65aa7c41e28a8a79a82edd2a91d20bd176))
* 抽离BaseButton，支持按钮修改主题色 ([69539ee](https://github.com/kailong321200875/vue-element-plus-admin/commit/69539ee2d34ddfcb83cbfb25e218b94891196e76))


### Performance Improvements

* [#344](https://github.com/kailong321200875/vue-element-plus-admin/issues/344) ([7fa533b](https://github.com/kailong321200875/vue-element-plus-admin/commit/7fa533b8ba0d886c0009b350a3b5fe4b027a9126))

## [2.5.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.4.1...v2.5.0) (2023-12-03)


### Types

* 删除无用类型 ([30e4214](https://github.com/kailong321200875/vue-element-plus-admin/commit/30e421438793b8283a0113ba50eb9aef90cfed4e))


### Features

* VideoPlayer ([7b5bbed](https://github.com/kailong321200875/vue-element-plus-admin/commit/7b5bbedbccf56049ff611005ba17a0f07b07034d))
* 持久化缓存 ([893459d](https://github.com/kailong321200875/vue-element-plus-admin/commit/893459da7cf819b6b94477cd76fdfeeecacc287f))
* 新增ImageCropping ([b0a43a7](https://github.com/kailong321200875/vue-element-plus-admin/commit/b0a43a70e6c93690ba4b0779527316f40297a45d))
* 新增userStore ([77c962e](https://github.com/kailong321200875/vue-element-plus-admin/commit/77c962ea91de68299a01680a7941cf7a73c7e4a7))
* 新增表格视频预览 ([cfc2d54](https://github.com/kailong321200875/vue-element-plus-admin/commit/cfc2d54586e73353295e7b73e2bf39e4e4d03c96))
* 替换mock-server插件 ([b8f9a99](https://github.com/kailong321200875/vue-element-plus-admin/commit/b8f9a9940d5eb3f532421b1b85aeb1f3d9afb4b1))
* 替换mockjs ([7c76d94](https://github.com/kailong321200875/vue-element-plus-admin/commit/7c76d945be8c46b427fe65c728ae0e70ab7a5e91))
* 重新整理目录结构,mock请求 ([179ab26](https://github.com/kailong321200875/vue-element-plus-admin/commit/179ab2672fe7fff55c8a9c55fae22a4b6c362623))


### Bug Fixes

* [#367](https://github.com/kailong321200875/vue-element-plus-admin/issues/367) ([c8400ab](https://github.com/kailong321200875/vue-element-plus-admin/commit/c8400abd9f37405127890be1c9a559edf9f251f8))


### Styling

* 格式化代码 ([31ea31d](https://github.com/kailong321200875/vue-element-plus-admin/commit/31ea31dde8a149f4fc805c08e4fca4e755c36752))
* 表单项宽度默认100% ([416de2b](https://github.com/kailong321200875/vue-element-plus-admin/commit/416de2b4d644f68d7db379c7cb1139c8a17f64d7))


### Performance Improvements

* 新增token过期示例 ([bdc8d35](https://github.com/kailong321200875/vue-element-plus-admin/commit/bdc8d358a1ca8f5fc6b43990899834791364e4f2))

## [2.4.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.4.0...v2.4.1) (2023-11-12)


### Bug Fixes

* [#361](https://github.com/kailong321200875/vue-element-plus-admin/issues/361) ([2e7797b](https://github.com/kailong321200875/vue-element-plus-admin/commit/2e7797be68b2469d979231e6588b43d0b5bdb88b))
* Default currentSize ([af583c7](https://github.com/kailong321200875/vue-element-plus-admin/commit/af583c71b0d1760ba4ed4cfa12458820c3f4db52))
* 修复瀑布流示例图片无法展示 ([3477173](https://github.com/kailong321200875/vue-element-plus-admin/commit/3477173b7649eb43a1e64c91135b0e657a3c7888))
* 修复自动格式化无效 ([bd82108](https://github.com/kailong321200875/vue-element-plus-admin/commit/bd8210858126f945bad31b3f1e0416aa178afef1))


### Styling

* 修改样式 ([92d436b](https://github.com/kailong321200875/vue-element-plus-admin/commit/92d436b8bb95c94831fcfe30678d384c3debc052))


### Performance Improvements

* 优化权限管理 ([efc1c25](https://github.com/kailong321200875/vue-element-plus-admin/commit/efc1c25db86d28438a2c324a3dc302501e1fdf8f))
* 优化瀑布流组件 ([82eb7f1](https://github.com/kailong321200875/vue-element-plus-admin/commit/82eb7f16ad3f663be602a747b55a78f6b986da30))

## [2.4.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.3.0...v2.4.0) (2023-10-14)


### Types

* 修改类型错误 ([4760733](https://github.com/kailong321200875/vue-element-plus-admin/commit/4760733bbe39b547285894555754bae6539190f9))


### Features

* Waterfall ([d543e56](https://github.com/kailong321200875/vue-element-plus-admin/commit/d543e56efb3b3e5800ab3ec24eda25565311eda2))


### Bug Fixes

* [#342](https://github.com/kailong321200875/vue-element-plus-admin/issues/342) ([1c51221](https://github.com/kailong321200875/vue-element-plus-admin/commit/1c512216453b17c64a09f97263fd481816badf7c))
* [#346](https://github.com/kailong321200875/vue-element-plus-admin/issues/346) ([d392868](https://github.com/kailong321200875/vue-element-plus-admin/commit/d392868c2799c2066ba606b0cdad95c011399559))
* [#355](https://github.com/kailong321200875/vue-element-plus-admin/issues/355) ([03d5e13](https://github.com/kailong321200875/vue-element-plus-admin/commit/03d5e130146a662a8a312e6c49f995f85ea0f9d3))
* **Descriptions:** Add a default value ([83b09f0](https://github.com/kailong321200875/vue-element-plus-admin/commit/83b09f09ffafb2a6273a1c5274e22f842c202c32))
* table column 中定义 selectable 无效 ([b8e043c](https://github.com/kailong321200875/vue-element-plus-admin/commit/b8e043c09c74fe00521ac0d7390331b9f223c797))
* Table的addColumn不能添加首列 ([240178f](https://github.com/kailong321200875/vue-element-plus-admin/commit/240178fd380402571fc056ddb9c8ae44ccb1e265))
* 修复Waterfall列数错误BUG ([1c2befa](https://github.com/kailong321200875/vue-element-plus-admin/commit/1c2befa4ddc76c625774100e3f5dd5a68a6faa45))
* 去除控制台警告 ([4d14246](https://github.com/kailong321200875/vue-element-plus-admin/commit/4d14246de50d2ba9d652ec5ef038f4fd3597006a))


### Styling

* Descriptions样式调整 ([be73f4d](https://github.com/kailong321200875/vue-element-plus-admin/commit/be73f4da3e4bbbacf3f748f7ebfd70f825e0d15e))
* formDemo集成图标选择器 ([99ffe6a](https://github.com/kailong321200875/vue-element-plus-admin/commit/99ffe6a86ac9961ad5b9be0171b01acdfa0cf994))
* 修改 Search 组件图标错误 ([7c93b74](https://github.com/kailong321200875/vue-element-plus-admin/commit/7c93b74e8f3e69d6c88ef2891eb6accc99a6a1e8))


### Performance Improvements

* IconPicker新增搜索功能 ([a4d1391](https://github.com/kailong321200875/vue-element-plus-admin/commit/a4d1391390bb33d498f2ec2cc64965f1a0b0aaab))
* useClipboard ([1db2248](https://github.com/kailong321200875/vue-element-plus-admin/commit/1db22482b43f6fb7ca8321b838fb41a5b0aff62e))
* useNetwork ([88be3ee](https://github.com/kailong321200875/vue-element-plus-admin/commit/88be3eea10196054596945af0eb9910e998dfd42))
* 优化请求例子 ([6b3d2e1](https://github.com/kailong321200875/vue-element-plus-admin/commit/6b3d2e14985c1a7a3c68001e17820d0e7a833a56))
* 完善demo ([2c4ff7d](https://github.com/kailong321200875/vue-element-plus-admin/commit/2c4ff7d190c816a92d92f9c2dbe048436b2bf964))
* 新增请求示例 ([2762aaf](https://github.com/kailong321200875/vue-element-plus-admin/commit/2762aaf09b3616944476797a6e112c350c12a0ec))

## [2.3.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.2.0...v2.3.0) (2023-09-24)


### Features

* IconPicker ([4490d5e](https://github.com/kailong321200875/vue-element-plus-admin/commit/4490d5eeeb4389f94f90c9c45a30343324db2250))
* 表格工具栏新增列设置功能 ([9d10ba8](https://github.com/kailong321200875/vue-element-plus-admin/commit/9d10ba821feca414b9b020322859ca4a47291005))


### Bug Fixes

* [#326](https://github.com/kailong321200875/vue-element-plus-admin/issues/326) ([c95a4e0](https://github.com/kailong321200875/vue-element-plus-admin/commit/c95a4e0763838e843cf5ce174110a01f2baa8000))
* default interceptor response return ([c3d8540](https://github.com/kailong321200875/vue-element-plus-admin/commit/c3d8540ab284312f24d9355072f6fb4506ed6d1d))
* 修复IconPicker BUG ([1e3aa78](https://github.com/kailong321200875/vue-element-plus-admin/commit/1e3aa789260773b1caecdaa32e1cafede22733e3))
* 修复useCrudSchemas无法自定义label ([aa5deb1](https://github.com/kailong321200875/vue-element-plus-admin/commit/aa5deb13904e45e7cb6ec7285e936b9ebae57273))


### Docs

* 更新README ([4947c82](https://github.com/kailong321200875/vue-element-plus-admin/commit/4947c82d6770f0dce2845682f0c41d853268cf82))
* 更新README ([c3624ce](https://github.com/kailong321200875/vue-element-plus-admin/commit/c3624cee588457e7fedaab360746500337c1b2a7))
* 更新群二维码 ([ead1ab8](https://github.com/kailong321200875/vue-element-plus-admin/commit/ead1ab8c88c05593d539b56a811809382675faf5))


### Styling

* 修复样式层级问题 ([f92d2b6](https://github.com/kailong321200875/vue-element-plus-admin/commit/f92d2b60a956e1963b63e23b446a9d42096704e0))
* 修改登录样式 ([bdd31f0](https://github.com/kailong321200875/vue-element-plus-admin/commit/bdd31f0621712af89d89b87ac439c3e0b398605a))

## [2.2.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.1.0...v2.2.0) (2023-08-27)


### Features

* JsonEditor ([c0f4517](https://github.com/kailong321200875/vue-element-plus-admin/commit/c0f4517b87de5a0172a057fb9da141f758cca1fa))
* 新增 useCrudSchemas demo ([ae0628e](https://github.com/kailong321200875/vue-element-plus-admin/commit/ae0628e3af3466c7c9d7b593b825f776843de5ec))
* 新增useTagsView ([a869a45](https://github.com/kailong321200875/vue-element-plus-admin/commit/a869a457e6a8052531ce3040ae0d332d7afbb478))


### Bug Fixes

* [#316](https://github.com/kailong321200875/vue-element-plus-admin/issues/316) ([7582e4d](https://github.com/kailong321200875/vue-element-plus-admin/commit/7582e4d12f18ae86f5ef4ff36211c364afca5763))
* [#317](https://github.com/kailong321200875/vue-element-plus-admin/issues/317) ([2095caa](https://github.com/kailong321200875/vue-element-plus-admin/commit/2095caaa854b686b57f47ee183419f42563a5a95))
* [#318](https://github.com/kailong321200875/vue-element-plus-admin/issues/318) ([4169e52](https://github.com/kailong321200875/vue-element-plus-admin/commit/4169e52baaaa43765848c29c5ce222d019e81c35))
* [#319](https://github.com/kailong321200875/vue-element-plus-admin/issues/319) ([b6ee4e5](https://github.com/kailong321200875/vue-element-plus-admin/commit/b6ee4e5d48deb3a07f289366ed3700baa3674cd6))
* 修复useValidator报错 ([4912f6c](https://github.com/kailong321200875/vue-element-plus-admin/commit/4912f6c0586249b3de7ac7d365c8ea98af7923c7))
* 修复动态路由无效 ([1452a1a](https://github.com/kailong321200875/vue-element-plus-admin/commit/1452a1afc77eb3f64cd3de91a05ddc15e40f4a06))


### Docs

* 更新README ([5b4defa](https://github.com/kailong321200875/vue-element-plus-admin/commit/5b4defa8c4be2de894b2cb50ae9ea739a10cf7d9))
* 更新群二维码 ([13aa71c](https://github.com/kailong321200875/vue-element-plus-admin/commit/13aa71c5bd5b5076599501961a24a171a9133c57))
* 更新群二维码 ([ae29e97](https://github.com/kailong321200875/vue-element-plus-admin/commit/ae29e974bfed2214d1beda703b976cdfa63070ab))


### Styling

* 修改Descriptions样式 ([cd0e05a](https://github.com/kailong321200875/vue-element-plus-admin/commit/cd0e05a6b9146af7ae64be62613724cd58e6c2a3))


### Code Refactoring

* 重构useValidator ([b8849da](https://github.com/kailong321200875/vue-element-plus-admin/commit/b8849dabe2b306831f69e84db167a367570d992a))


### Performance Improvements

* 优化动态路由 ([8793588](https://github.com/kailong321200875/vue-element-plus-admin/commit/879358821d02d5e4575dfee0d189b9fee7f2e217))
* 完善useTagsView ([e0c55f4](https://github.com/kailong321200875/vue-element-plus-admin/commit/e0c55f40d4c1c47e29de6c4c7e9433efa978bf7f))
* 完善useTagsView ([175abd0](https://github.com/kailong321200875/vue-element-plus-admin/commit/175abd0aa3388e8473f6ecbf63e28133fce55bd3))
* 更新demo ([2c99cd2](https://github.com/kailong321200875/vue-element-plus-admin/commit/2c99cd20f0c25a740ac7a3a8319f7a112e69c0d3))

## [2.1.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v2.0.0...v2.1.0) (2023-08-12)


### Features

* 新增多开标签页Demo ([5c253ce](https://github.com/kailong321200875/vue-element-plus-admin/commit/5c253ce803a9ef7ce03534ddd5f0865db4602378))


### Bug Fixes

* [#307](https://github.com/kailong321200875/vue-element-plus-admin/issues/307) ([4ce07e1](https://github.com/kailong321200875/vue-element-plus-admin/commit/4ce07e150c0bd3903cc5f43fcd88c2cb292d7690))
* [#311](https://github.com/kailong321200875/vue-element-plus-admin/issues/311) ([bdde4cc](https://github.com/kailong321200875/vue-element-plus-admin/commit/bdde4ccd39d5d698d68b299c6e80546d4a8be89f))
* 修复eslint错误 ([b5e47e0](https://github.com/kailong321200875/vue-element-plus-admin/commit/b5e47e04d8f5f889e0c46a2dced108d058ded94e))
* 修复Table插槽传参错误 ([97344e6](https://github.com/kailong321200875/vue-element-plus-admin/commit/97344e68f5abb144d9e5d4ad273108858dbcfba2))
* 修复Table组件插槽传参错误 ([c83a026](https://github.com/kailong321200875/vue-element-plus-admin/commit/c83a026d559e2854fead17d2e28fbebcf25490de))


### Docs

* 修改Readme ([ee059b7](https://github.com/kailong321200875/vue-element-plus-admin/commit/ee059b7619ad01ded9d3be20287086ddbcce3253))
* 修改Readme ([e05f5a7](https://github.com/kailong321200875/vue-element-plus-admin/commit/e05f5a77edc175daa267e4fc6abbcfc8fec2e291))
* 修改Readme ([b0e561d](https://github.com/kailong321200875/vue-element-plus-admin/commit/b0e561d8acd36e8780087e317cc34257956981fd))
* 修改Readme ([fced2e0](https://github.com/kailong321200875/vue-element-plus-admin/commit/fced2e0087694445a89cf360e5e3e3013d8ca604))
* 修改README ([dce76f0](https://github.com/kailong321200875/vue-element-plus-admin/commit/dce76f042d5243039540828a3fd982af25f37531))
* 更新群二维码 ([607ef58](https://github.com/kailong321200875/vue-element-plus-admin/commit/607ef585d010c9ade6f54d96c2a12b36099ece74))


### Styling

* 修改TabMenu样式 ([e8cd6f9](https://github.com/kailong321200875/vue-element-plus-admin/commit/e8cd6f9e1c4387c582e461cde4d59796bf17c1bd))

## [2.0.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.10.0...v2.0.0) (2023-08-06)


### ⚠ BREAKING CHANGES

* 重构完成

### Features

* 重构完成 ([76e971e](https://github.com/kailong321200875/vue-element-plus-admin/commit/76e971ef96ad4f5cc7df58abd0559898ce70207d))


### Code Refactoring

* 重构完成 ([85f8cda](https://github.com/kailong321200875/vue-element-plus-admin/commit/85f8cda19d8cafb951f211b845aad970a661dd1e))
* 重构完成 ([5d55597](https://github.com/kailong321200875/vue-element-plus-admin/commit/5d55597cca6c9d2bc6cb6211a01c161fa5f086ba))

## [1.10.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.9...v1.10.0) (2023-08-06)


### Types

* Form类型调整 ([a0f4aeb](https://github.com/kailong321200875/vue-element-plus-admin/commit/a0f4aebc5a685366cd56b1a7bb39fa614976e3bb))
* Form类型调整 ([674d760](https://github.com/kailong321200875/vue-element-plus-admin/commit/674d760029b451c0c6fc23a2aeac5c83992a0b27))
* 修改类型 ([c3ac191](https://github.com/kailong321200875/vue-element-plus-admin/commit/c3ac1915045d4d59bca09ec6d19151bc5da342f1))
* 修改类型 ([7d0476f](https://github.com/kailong321200875/vue-element-plus-admin/commit/7d0476f47c5858019db871cff2bdd19f0210f0d4))
* 类型优化 ([283bc58](https://github.com/kailong321200875/vue-element-plus-admin/commit/283bc58d46151a8954bb81ee6bf8f499177b15fc))
* 调整类型 ([24c8af9](https://github.com/kailong321200875/vue-element-plus-admin/commit/24c8af91835fb2c8c00e7c2673fff01f098c9944))
* 迁移types ([ccbec86](https://github.com/kailong321200875/vue-element-plus-admin/commit/ccbec865568b1c9b3c3321d7071c164fdc350a0f))
* 迁移types ([46b35e4](https://github.com/kailong321200875/vue-element-plus-admin/commit/46b35e48b3e7876c74159625b5149ef663396f5c))


### Features

* axios 改造 ([3238140](https://github.com/kailong321200875/vue-element-plus-admin/commit/32381408bbe418eeaca2a975305bac80ddaa03f5))
* axios 改造 ([5807db1](https://github.com/kailong321200875/vue-element-plus-admin/commit/5807db1dc12a7ff2dbf66801a742a78974ad8f9c))
* Descriptions组件重构 ([49e415d](https://github.com/kailong321200875/vue-element-plus-admin/commit/49e415d27788cb468c96f2a828f1df7ae65b7a3c))
* Dialog组件重构 ([3701a04](https://github.com/kailong321200875/vue-element-plus-admin/commit/3701a04231af02ec7f7ef73533f3a22e707380fb))
* Form useForm 完成 ([3e4e27c](https://github.com/kailong321200875/vue-element-plus-admin/commit/3e4e27c21fd59c944229856bee929f005d2ee140))
* Form改造 ([9c724dc](https://github.com/kailong321200875/vue-element-plus-admin/commit/9c724dc9aad18397d5ecd00e53c3c24e142a34b5))
* Icon改版 ([882f162](https://github.com/kailong321200875/vue-element-plus-admin/commit/882f162ff21c74239b638f284f52161e5791722d))
* Radio改造 ([deeee73](https://github.com/kailong321200875/vue-element-plus-admin/commit/deeee73bcb3ad912844fddee62b1155d95d4b42b))
* Radio改造 ([83513d5](https://github.com/kailong321200875/vue-element-plus-admin/commit/83513d519d4b6b8fbfd48db266b9bd7b3a998d63))
* Search组件重构 ([a7f3702](https://github.com/kailong321200875/vue-element-plus-admin/commit/a7f370214481577ab82bf2871191dda717c7978a))
* SelectV2改造完成 ([4d04734](https://github.com/kailong321200875/vue-element-plus-admin/commit/4d04734e13f6926c16aeee421feecb0d339534f0))
* Table重构 ([94800b0](https://github.com/kailong321200875/vue-element-plus-admin/commit/94800b0120ee05ca7d534dda3e59653f38d7fda0))
* 完善search组件demo ([cdf44a4](https://github.com/kailong321200875/vue-element-plus-admin/commit/cdf44a43a05010dbcba3a3ec0cb7c8251f16fce3))
* 拖拽表格 ([b69b8ed](https://github.com/kailong321200875/vue-element-plus-admin/commit/b69b8ed1bde36100fc86e51fcc63805d4ea21210))
* 新增TreeSelect表单项 ([de0cb43](https://github.com/kailong321200875/vue-element-plus-admin/commit/de0cb43566b9065250abbc71548ffeca4c8e8bf1))
* 新增Uload ([c181887](https://github.com/kailong321200875/vue-element-plus-admin/commit/c181887f7f0c5eecc9584edfe99e9065440bdc56))
* 新增useStorage ([dfea91c](https://github.com/kailong321200875/vue-element-plus-admin/commit/dfea91c7e1d18fa299067c62557cac61723ea861))
* 新增权限测试页 ([3fe40ba](https://github.com/kailong321200875/vue-element-plus-admin/commit/3fe40ba62df29c2ffea9adfd65fc559489481e24))
* 新增锁屏功能 ([e2fd349](https://github.com/kailong321200875/vue-element-plus-admin/commit/e2fd349070147c57f9400fa9a413260b7707bda2))
* 用户列表重构 ([755cea0](https://github.com/kailong321200875/vue-element-plus-admin/commit/755cea0990d9e3b64c936f29c02e4053393a1a19))
* 登录页改造 ([5312951](https://github.com/kailong321200875/vue-element-plus-admin/commit/5312951359b5d919b6c1a03783aa6bbaf8ec0044))
* 综合示例重构 ([9a0259d](https://github.com/kailong321200875/vue-element-plus-admin/commit/9a0259de5c47970502db95f4dda24998ad5d9efe))
* 菜单管理 ([c72b3a3](https://github.com/kailong321200875/vue-element-plus-admin/commit/c72b3a33aab7d3605770a64d23b8a84ef4ad68d2))
* 角色管理 ([47016a5](https://github.com/kailong321200875/vue-element-plus-admin/commit/47016a535f2b7a22ab498bee197bc30a983f507d))
* 部门管理 ([28d0785](https://github.com/kailong321200875/vue-element-plus-admin/commit/28d0785be842022cae7808c23e1f19eaab5fb996))
* 重构Dialog组件示例 ([9a78ac9](https://github.com/kailong321200875/vue-element-plus-admin/commit/9a78ac977eb0cfb3bd6c2a9b96e69d9f010017f4))


### Bug Fixes

* mock数据 ([8bdac71](https://github.com/kailong321200875/vue-element-plus-admin/commit/8bdac7152f463cd98c50c9893a46bb6c111fd428))
* 修复Form已知问题 ([097b32e](https://github.com/kailong321200875/vue-element-plus-admin/commit/097b32e1a9d92a609a66179d68b3dabe12f96b66))
* 修复Table组件已知问题 ([b1a83f6](https://github.com/kailong321200875/vue-element-plus-admin/commit/b1a83f601838cb82fb29c036654a4cdc729997cd))
* 修复类型错误 ([26dc886](https://github.com/kailong321200875/vue-element-plus-admin/commit/26dc886f8ccb5cf1ffc10e1d9601c827a1f960c2))
* 样式问题修复 ([cdc7c76](https://github.com/kailong321200875/vue-element-plus-admin/commit/cdc7c76eb5ac3ccb79f5f55ff5b7ce6b8c4955e1))
* 解决类型检测报错 ([9d93496](https://github.com/kailong321200875/vue-element-plus-admin/commit/9d9349600b3d2008e4216d49c9fa1c1b9995fa79))
* 解决类型检测报错 ([513108c](https://github.com/kailong321200875/vue-element-plus-admin/commit/513108c00e622812e2e70dfe833435f6b5462d6e))
* 解决类型检测报错 ([28bf8be](https://github.com/kailong321200875/vue-element-plus-admin/commit/28bf8bee45e3cc8575a356623abdbe56e30991f8))


### Styling

* Table样式修改 ([5fc57bd](https://github.com/kailong321200875/vue-element-plus-admin/commit/5fc57bdb08488f6898eafd6f28289b0567d6d9e2))
* Table样式修改 ([411c0f7](https://github.com/kailong321200875/vue-element-plus-admin/commit/411c0f792ae8359c49e81974d8193f049120985b))
* Table样式修改 ([d487c6a](https://github.com/kailong321200875/vue-element-plus-admin/commit/d487c6a93ec0281d76a3938e6e23ea2a4a7940c1))
* Table样式修改 ([c7d21e3](https://github.com/kailong321200875/vue-element-plus-admin/commit/c7d21e36d012377ba863ac848d77abb5db4f475a))
* Table样式修改 ([7f5078a](https://github.com/kailong321200875/vue-element-plus-admin/commit/7f5078a436c4d5abcaf7a420df35d2be9b3680c5))
* 修改Dialog样式 ([e451bfc](https://github.com/kailong321200875/vue-element-plus-admin/commit/e451bfcde6e5a47d4b3022e240ffcc0576ebb9a8))
* 修改样式 ([207c5b3](https://github.com/kailong321200875/vue-element-plus-admin/commit/207c5b3fc4e52bb06baa36cd4b659e14893785ba))
* 完善角色管理 ([c4576bd](https://github.com/kailong321200875/vue-element-plus-admin/commit/c4576bd57bcf504733f20188202ea7d33ab1c184))
* 布局样式优化 ([962689a](https://github.com/kailong321200875/vue-element-plus-admin/commit/962689a8bd0ed5eb17d946b8a21dec4a197f13a7))
* 样式布局调整完成 ([7193176](https://github.com/kailong321200875/vue-element-plus-admin/commit/719317694f71e22692256bb557070343f034ffe5))
* 用户管理样式修改 ([57a5fa7](https://github.com/kailong321200875/vue-element-plus-admin/commit/57a5fa7b82ae9f3d7a1f8ec5391f14b1d1cd32e8))
* 移除不必要样式 ([7ef1d1e](https://github.com/kailong321200875/vue-element-plus-admin/commit/7ef1d1e3013cc5bf7fc574e67c2004f50792e66d))
* 移除不必要样式 ([366db45](https://github.com/kailong321200875/vue-element-plus-admin/commit/366db4528254d18659e6a922817702b5b92a57b0))
* 调整Icon悬停样式 ([64c7e48](https://github.com/kailong321200875/vue-element-plus-admin/commit/64c7e48bd18ba83e605daccbc4c2f4cc6b58695d))
* 调整工作台样式错乱 ([cc18f29](https://github.com/kailong321200875/vue-element-plus-admin/commit/cc18f297ef50655d5773d01fcfddabc365dc53e7))


### Performance Improvements

* Dialog默认高度修改 ([0e04fce](https://github.com/kailong321200875/vue-element-plus-admin/commit/0e04fce4367d6829e8de97a249318b0309e06fd5))
* Form Table Search Descriptions 支持嵌套赋值 ([46ddf62](https://github.com/kailong321200875/vue-element-plus-admin/commit/46ddf62d2d4ce1a653f47695cb0bb3475aa16bd8))
* ImageViewer组件优化 ([3b9c3d8](https://github.com/kailong321200875/vue-element-plus-admin/commit/3b9c3d8b757646eaf74625403112a969bfd15e55))
* 优化Form事件传递 ([69cafb3](https://github.com/kailong321200875/vue-element-plus-admin/commit/69cafb3b7b2ce7ecbd9f2e8ef09e250817e9a55c))
* 优化Search组件 ([e548668](https://github.com/kailong321200875/vue-element-plus-admin/commit/e548668ccef8c41d9ac7d9fe39ffe66471d160d2))
* 优化表单组件 ([77a3866](https://github.com/kailong321200875/vue-element-plus-admin/commit/77a38662488ab9ff4cbe5ff3cf9b65eea34abca1))
* 优化锁屏组件 ([4f8330a](https://github.com/kailong321200875/vue-element-plus-admin/commit/4f8330a4faf6cc98a9bac17bd3e1719ae1b30c81))

## [1.9.9](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.8...v1.9.9) (2023-04-13)


### Bug Fixes

* 使用动态路由时，多级路由只有一个子路且父路由未使用alwaysShow时，子路由未添加至路由中 ([9b330a1](https://github.com/kailong321200875/vue-element-plus-admin/commit/9b330a1f513d3af9233b9a9dde6bdfeeefbc3393))

## [1.9.8](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.7...v1.9.8) (2023-04-12)


### Bug Fixes

* 修复已知问题 ([0a6f306](https://github.com/kailong321200875/vue-element-plus-admin/commit/0a6f306686ea024e30bcdccac34e485b8526e38f))

## [1.9.7](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.6...v1.9.7) (2023-03-28)


### Bug Fixes

* 修复表格与搜索框字段不能不一致的问题 ([5c1cd29](https://github.com/kailong321200875/vue-element-plus-admin/commit/5c1cd298defefb36b858adc766b776a0a7b9bd66))

## [1.9.6](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.5...v1.9.6) (2023-03-22)


### Bug Fixes

* 修改 Editor 的 z-index 使其不会遮挡『综合示例 - 新增』界面的下拉菜单 ([c046e45](https://github.com/kailong321200875/vue-element-plus-admin/commit/c046e4554ba8fd99614484d8fb636650072b833e))

## [1.9.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.4...v1.9.5) (2023-03-13)


### Bug Fixes

* 面包屑:1.修复使用动态路由的时候，无法显示的bug ([8790c8c](https://github.com/kailong321200875/vue-element-plus-admin/commit/8790c8cbd8d63ea0f8f276fd5af006f39b06e7d3))

## [1.9.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.3...v1.9.4) (2023-03-03)


### Bug Fixes

* 修复已知BUG ([782b8e2](https://github.com/kailong321200875/vue-element-plus-admin/commit/782b8e2f94c867c3ee282287c37c888fff93fc55))

## [1.9.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.2...v1.9.3) (2023-03-01)


### Types

* 修复类型错误 ([297b2c6](https://github.com/kailong321200875/vue-element-plus-admin/commit/297b2c69a239b487126c3b9316645a1b5f06bb7c))


### Styling

* 抽屉弹出样式问题 ([16a3eef](https://github.com/kailong321200875/vue-element-plus-admin/commit/16a3eef85a1ffb296bd44f67d89a911ecaf1c25e))
* 调整主题切换样式 ([6e6beef](https://github.com/kailong321200875/vue-element-plus-admin/commit/6e6beefc3c380f7297985adcabcf966fbd2c5197))

## [1.9.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.1...v1.9.2) (2023-01-16)


### Bug Fixes

* 修复TS类型错误 ([1c06a27](https://github.com/kailong321200875/vue-element-plus-admin/commit/1c06a27b900a891cd0b47098062cebc984ff6505))

## [1.9.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.9.0...v1.9.1) (2023-01-11)


### Bug Fixes

* dark mode toggle ([bbc7646](https://github.com/kailong321200875/vue-element-plus-admin/commit/bbc764601ec864c2fdbe3ad78c083c5ae80615e0))

## [1.9.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.7...v1.9.0) (2022-12-28)


### Features

* 添加打包进度条 ([354e87f](https://github.com/kailong321200875/vue-element-plus-admin/commit/354e87f7c533ad8e93ef484b47d0fe16f17048c9))


### Bug Fixes

* husky ([6fe5b2e](https://github.com/kailong321200875/vue-element-plus-admin/commit/6fe5b2e6c781b251bff5f0ac936c04dcfe5ef95f))

## [1.8.7](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.6...v1.8.7) (2022-12-05)


### Bug Fixes

* 解决iframe无法正常工作 ([4fcc46f](https://github.com/kailong321200875/vue-element-plus-admin/commit/4fcc46fccf747b47909e2079c4f2abc5dbfb1a0c))

## [1.8.6](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.5...v1.8.6) (2022-11-21)


### Bug Fixes

* 修复Search组件无法默认值 ([3368fda](https://github.com/kailong321200875/vue-element-plus-admin/commit/3368fda251bd3ff5a8e0059b3b33f9c0339d236b))

## [1.8.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.4...v1.8.5) (2022-11-17)


### Bug Fixes

* 修复Form赋值问题 ([f37cc1b](https://github.com/kailong321200875/vue-element-plus-admin/commit/f37cc1b5801add3ada168dbbcf4cd2c340f0e30d))

## [1.8.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.3...v1.8.4) (2022-11-07)


### Bug Fixes

* 修复option禁用属性无效 ([0b671e9](https://github.com/kailong321200875/vue-element-plus-admin/commit/0b671e914e396c7666ad5e34768a6e29f7dfbd33))


### Styling

* input默认宽度与select对齐 ([0b671e9](https://github.com/kailong321200875/vue-element-plus-admin/commit/0b671e914e396c7666ad5e34768a6e29f7dfbd33))

## [1.8.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.2...v1.8.3) (2022-10-28)


### Performance Improvements

* 优化描述组件 ([73ecc98](https://github.com/kailong321200875/vue-element-plus-admin/commit/73ecc98671d430013920246d98ce9ab1752e56eb))

## [1.8.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.1...v1.8.2) (2022-10-18)


### Bug Fixes

* Correct spelling of words(aciton →action) ([eb405b2](https://github.com/kailong321200875/vue-element-plus-admin/commit/eb405b2a9041ca0ad4455db79bf617ec910dc485))
* Correct spelling of words(tigger →trigger) ([c2ca2d7](https://github.com/kailong321200875/vue-element-plus-admin/commit/c2ca2d736c92e02380923a6741450844acb41a38))

## [1.8.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.8.0...v1.8.1) (2022-10-11)


### Bug Fixes

* 修复cutMenu收起时 ([993af6b](https://github.com/kailong321200875/vue-element-plus-admin/commit/993af6bb6576249e66e0c0ea592ebf851f65ab8c))


### Styling

* cutMenu层级样式 ([32d2408](https://github.com/kailong321200875/vue-element-plus-admin/commit/32d2408588c487cff2cf73e3cc132e5105ff4459))

## [1.8.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.7.1...v1.8.0) (2022-10-10)


### Features

* types优化 ([3351155](https://github.com/kailong321200875/vue-element-plus-admin/commit/33511553cd9055b036b2d7491f9c2eda123f8b22))


### Styling

* 优化第四种布局 ([122fa62](https://github.com/kailong321200875/vue-element-plus-admin/commit/122fa62d859413d16175e0d97c7bf13f232dbb3a))

## [1.7.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.7.0...v1.7.1) (2022-10-10)


### Bug Fixes

* 修正types提示错误 ([ef3e006](https://github.com/kailong321200875/vue-element-plus-admin/commit/ef3e006859dcd8b93ffb7cffcaeae24cbb330f2a))

## [1.7.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.6...v1.7.0) (2022-10-09)


### Features

* type抽离 ([8b4fa1a](https://github.com/kailong321200875/vue-element-plus-admin/commit/8b4fa1aa21aa2c1379288315ccd64a6f3375be51))

## [1.6.6](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.5...v1.6.6) (2022-10-09)


### Bug Fixes

* table search params ([a62929a](https://github.com/kailong321200875/vue-element-plus-admin/commit/a62929a8dac21028d3dd1cddf98189492c33b093))

## [1.6.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.4...v1.6.5) (2022-10-08)


### Bug Fixes

* The attribute of option does not work ([d946920](https://github.com/kailong321200875/vue-element-plus-admin/commit/d946920e61ed81beacf9f1f8be7ee1f50505f64d))


### Performance Improvements

* perf store ([d416178](https://github.com/kailong321200875/vue-element-plus-admin/commit/d416178d69ca6100be4b635922b1a22d27629f08))
* token test ([b320e65](https://github.com/kailong321200875/vue-element-plus-admin/commit/b320e658d1a559a6eaebdf374d63649c223c2ecd))

## [1.6.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.3...v1.6.4) (2022-09-21)


### Bug Fixes

* fix bug ([da39f3b](https://github.com/kailong321200875/vue-element-plus-admin/commit/da39f3bc904ca2d80f432a31709725f9a57deb19))

## [1.6.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.2...v1.6.3) (2022-08-20)


### Bug Fixes

* 修复重定向错误 ([89d03fd](https://github.com/kailong321200875/vue-element-plus-admin/commit/89d03fd067e7aca565ceb84ea9276f340bbfcb60))


### Styling

* 调整样式 ([d29e151](https://github.com/kailong321200875/vue-element-plus-admin/commit/d29e151f8a660031a685f6ef9f789532b1b7b58b))

## [1.6.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.1...v1.6.2) (2022-08-13)


### Styling

* Misspelling ([c43e833](https://github.com/kailong321200875/vue-element-plus-admin/commit/c43e833582e4f14ac78b0683f1eb3bdeb9fb4821))
* perfect tableDemo ([c589edd](https://github.com/kailong321200875/vue-element-plus-admin/commit/c589edd960b23ad0c8b56d2c7880b61014114d45))


### Code Refactoring

* refactor axios ([0980640](https://github.com/kailong321200875/vue-element-plus-admin/commit/0980640f65fc80e3e58ba49e98db10b7b1b80077))

## [1.6.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.6.0...v1.6.1) (2022-07-30)


### Bug Fixes

* fix menu active bug ([ff59fc7](https://github.com/kailong321200875/vue-element-plus-admin/commit/ff59fc7e133202945360a7e210f9cdf3a4a89dd7))
* Pie chart data not updated ([55d4ce7](https://github.com/kailong321200875/vue-element-plus-admin/commit/55d4ce7e35ff9a0c5590bc3589160cfd304d3ae5))


### Performance Improvements

* add static router ([55522b0](https://github.com/kailong321200875/vue-element-plus-admin/commit/55522b0661a8df3ad3c8afafcc9f8fcb162c5a00))


### Styling

* tagviews styles update ([bff7d93](https://github.com/kailong321200875/vue-element-plus-admin/commit/bff7d9370db7a9c171828721bb99643dac2f235d))

## [1.6.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.5.4...v1.6.0) (2022-07-18)


### Features

* 添加按钮权限 ([7bef662](https://github.com/kailong321200875/vue-element-plus-admin/commit/7bef662db1e91aa8164e9f7a92de3fe4480a3c3b))


### Performance Improvements

* 移除md5依赖 ([a123097](https://github.com/kailong321200875/vue-element-plus-admin/commit/a123097f1f38eac45e945c7d3fdccafc16ea9b69))


### Styling

* 压缩图片尺寸 ([ae3c565](https://github.com/kailong321200875/vue-element-plus-admin/commit/ae3c5657b604ffbdae5ce3ce3603626ad4acc5e5))


### Docs

* vite2 to vite3 ([b3918b9](https://github.com/kailong321200875/vue-element-plus-admin/commit/b3918b9c3c5de4b48811ec95967851cfb3c231e1))
* vite2 to vite3 ([aaf07de](https://github.com/kailong321200875/vue-element-plus-admin/commit/aaf07de77aa600332880a894faa35757f787c012))

## [1.6.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.5.4...v1.6.0) (2022-07-18)


### Features

* 添加按钮权限 ([7bef662](https://github.com/kailong321200875/vue-element-plus-admin/commit/7bef662db1e91aa8164e9f7a92de3fe4480a3c3b))


### Performance Improvements

* 移除md5依赖 ([a123097](https://github.com/kailong321200875/vue-element-plus-admin/commit/a123097f1f38eac45e945c7d3fdccafc16ea9b69))


### Styling

* 压缩图片尺寸 ([ae3c565](https://github.com/kailong321200875/vue-element-plus-admin/commit/ae3c5657b604ffbdae5ce3ce3603626ad4acc5e5))


### Docs

* vite2 to vite3 ([b3918b9](https://github.com/kailong321200875/vue-element-plus-admin/commit/b3918b9c3c5de4b48811ec95967851cfb3c231e1))
* vite2 to vite3 ([aaf07de](https://github.com/kailong321200875/vue-element-plus-admin/commit/aaf07de77aa600332880a894faa35757f787c012))

## [1.5.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.5.3...v1.5.4) (2022-07-16)


### Bug Fixes

* fix build:test error ([14530cf](https://github.com/kailong321200875/vue-element-plus-admin/commit/14530cf790bfbbe37c72fa831f0376bbb4209e9d))

## [1.5.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.5.2...v1.5.3) (2022-07-01)


### Bug Fixes

* fix useCrudSchemas not work ([0a855b9](https://github.com/kailong321200875/vue-element-plus-admin/commit/0a855b93e282dfe7863b3fce31dde5d7e0d3e2b6))

## [1.5.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.5.1...v1.5.2) (2022-07-01)


### Performance Improvements

* add useCrudSchemas demo ([ca3ce54](https://github.com/kailong321200875/vue-element-plus-admin/commit/ca3ce54630b723d87415b14c642440d6734876ff))

## [1.5.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.5.0...v1.5.1) (2022-07-01)


### Bug Fixes

* change showMainRoute to canTo ([5e292f8](https://github.com/kailong321200875/vue-element-plus-admin/commit/5e292f8a2b2ded7297a2a76893e113ac81517d23))


### Performance Improvements

* dialog combine with form ([34aefb6](https://github.com/kailong321200875/vue-element-plus-admin/commit/34aefb64ab9237521a1225925264818eebff9ad3))
* dynamic options demo ([1acb4d7](https://github.com/kailong321200875/vue-element-plus-admin/commit/1acb4d7e8f449ba342699f1b4387ac2404a4c1fb))
* dynamic options demo ([9a3b617](https://github.com/kailong321200875/vue-element-plus-admin/commit/9a3b6177aa0fbc99c86c5073a1c6c696e1eaf890))
* useCrudSchemas cutom label ([7864d83](https://github.com/kailong321200875/vue-element-plus-admin/commit/7864d830e2134d814609e722b7bad1754ea9460e))

## [1.5.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.4.5...v1.5.0) (2022-06-25)


### Features

* refactoring API ([37b7583](https://github.com/kailong321200875/vue-element-plus-admin/commit/37b75839a591648b145065432efb1dc8c7a3b917))


### Bug Fixes

* 修复axios已知问题 ([537af57](https://github.com/kailong321200875/vue-element-plus-admin/commit/537af57a0aaa24c88ebe75acf52dc0403a58b04b))


### Performance Improvements

* perf axios config ([39edd84](https://github.com/kailong321200875/vue-element-plus-admin/commit/39edd84023109a84683c21ea33e41bd024756520))

## [1.4.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.4.4...v1.4.5) (2022-06-09)


### Bug Fixes

* fix tagsview not work ([d88e051](https://github.com/kailong321200875/vue-element-plus-admin/commit/d88e0514349e877f1c5280a48f9b1bd2bfd622bf))
* fix tagsview not work ([1bf2d4c](https://github.com/kailong321200875/vue-element-plus-admin/commit/1bf2d4c77287fdca7ed1cb8c9998a53f1375dc6f))


### Types

* fix types error ([586486a](https://github.com/kailong321200875/vue-element-plus-admin/commit/586486a68d4bf2a024e50a79945b4007324f642d))

## [1.4.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.4.3...v1.4.4) (2022-06-06)


### Types

* fix type error ([d66f12e](https://github.com/kailong321200875/vue-element-plus-admin/commit/d66f12e0e77f6acf485bae06509d9ea4abcd1eaa))

### [1.4.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.4.2...v1.4.3) (2022-06-01)


### Bug Fixes

* multiple requests when pageSize change and currentPage isn't 1 ([f71a250](https://github.com/kailong321200875/vue-element-plus-admin/commit/f71a2503bc521c01e7102feecf4ec39a5224a6bb))

### [1.4.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.4.1...v1.4.2) (2022-05-15)


### Styling

* fix dark mode bug ([2f9fd5d](https://github.com/kailong321200875/vue-element-plus-admin/commit/2f9fd5d21550d771ec12ae3540b975e2eebcd25b))

### [1.4.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.4.0...v1.4.1) (2022-05-12)


### Bug Fixes

* the warning of VSCode extensions ([a368c21](https://github.com/kailong321200875/vue-element-plus-admin/commit/a368c21fb9c41f98f31f51586a2023076a8a9132))

## [1.4.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.3.2...v1.4.0) (2022-05-10)


### Features

* add dark mode ([0758a6a](https://github.com/kailong321200875/vue-element-plus-admin/commit/0758a6a9d83170e53d45d39c3313e52ff5885746))

### [1.3.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.3.1...v1.3.2) (2022-05-07)


### Bug Fixes

* fix the problem that the page is stuck in top mode ([8d01f48](https://github.com/kailong321200875/vue-element-plus-admin/commit/8d01f48d5098195b10c03b3cb3a0f485ebc9e018))

### [1.3.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.3.0...v1.3.1) (2022-05-06)


### Bug Fixes

* spelling 'useRenderChcekbox' ([ee92f03](https://github.com/kailong321200875/vue-element-plus-admin/commit/ee92f039bea4307ccfb819728d3e2ed04fa00e03))

## [1.3.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.13...v1.3.0) (2022-04-26)


### Features

* add useCrudSchemas hook ([00d947e](https://github.com/kailong321200875/vue-element-plus-admin/commit/00d947e2f81105194b0622d33768f999e37ad28a))


### Bug Fixes

* fix Table slot warning ([0eac05d](https://github.com/kailong321200875/vue-element-plus-admin/commit/0eac05d4f973ff7b15e00973f6e96595a3cd6d43))


### Code Refactoring

* refactor useAxios ([185f1e6](https://github.com/kailong321200875/vue-element-plus-admin/commit/185f1e6e210ecaac28ebfdee4198b7ca2eaa0933))


### Build System

* add url ([ab0f59a](https://github.com/kailong321200875/vue-element-plus-admin/commit/ab0f59ac91a077cf060923fa76e6d57e05d0b21b))
* update plugins ([c475a61](https://github.com/kailong321200875/vue-element-plus-admin/commit/c475a610c19094034306f2dc665e240c7c117f87))
* update plugins ([dfedbc7](https://github.com/kailong321200875/vue-element-plus-admin/commit/dfedbc74fdb2c819a96b6263849bdaab59b9e337))

### [1.2.13](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.12...v1.2.13) (2022-04-18)


### Performance Improvements

* Editor component support v-model ([d77f8e3](https://github.com/kailong321200875/vue-element-plus-admin/commit/d77f8e334d77ee43c9ee0f411733f7397b278bc0))

### [1.2.12](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.11...v1.2.12) (2022-04-17)


### Bug Fixes

* fixed spelling 'ElememtPlusSzie' ([5dbbc60](https://github.com/kailong321200875/vue-element-plus-admin/commit/5dbbc608640d93fe68fec6f58fdb30a43e02aada))

### [1.2.11](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.10...v1.2.11) (2022-04-14)


### Bug Fixes

* fix the error reported by the Editor component ([7dc6d8a](https://github.com/kailong321200875/vue-element-plus-admin/commit/7dc6d8a9d7289bfaf27f972e9ca1773c0a1ddd7d))
* fix the error reported by the Editor component ([90ef985](https://github.com/kailong321200875/vue-element-plus-admin/commit/90ef9856a0885fa812339cb7047ecc98b86c7b73))


### Performance Improvements

* add tagsViewIcon setting ([d395f03](https://github.com/kailong321200875/vue-element-plus-admin/commit/d395f03a57a9265f1d39b3220fc7c9b983efee30))
* add uniqueopened setting ([b060319](https://github.com/kailong321200875/vue-element-plus-admin/commit/b0603199a5ae0ee923483dad449f49220d36f444))


### Build System

* update plugins ([2ee4954](https://github.com/kailong321200875/vue-element-plus-admin/commit/2ee49549e7b601af26ef5204f7648d271f3348f2))


### Styling

* add layout background color ([9b614fe](https://github.com/kailong321200875/vue-element-plus-admin/commit/9b614fe89288538197c50f164586aeed7836b7a8))

### [1.2.10](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.9...v1.2.10) (2022-04-12)


### Bug Fixes

* fix bug ([327522f](https://github.com/kailong321200875/vue-element-plus-admin/commit/327522f2b73ae0e11f8ebbc39394b06029ce0b65))


### Styling

* modify the commitlint package manager ([ba7e722](https://github.com/kailong321200875/vue-element-plus-admin/commit/ba7e7224ab58612548519415f5429c32827a61de))

### [1.2.9](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.8...v1.2.9) (2022-04-12)


### Docs

* update changlog ([e37273d](https://github.com/kailong321200875/vue-element-plus-admin/commit/e37273d95d29a3bb752604658d550264aacdc979))

### [1.2.8](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.7...v1.2.8) (2022-04-11)

### Build System

- update plugins ([00a573a](https://github.com/kailong321200875/vue-element-plus-admin/commit/00a573af3f455395b4ee2ab99a03f3103d466e9c))

### Docs

- update changlog ([62fc183](https://github.com/kailong321200875/vue-element-plus-admin/commit/62fc1839fdff3a4d06a7db4cf3f8ce2cb9aee681))

### [1.2.7](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.6...v1.2.7) (2022-04-10)

### Build System

- update plugins ([f13a91d](https://github.com/kailong321200875/vue-element-plus-admin/commit/f13a91dd460b1dcdbd17aef723ab3ca2b01c34f0))

### Styling

- .bhs code formatting ([57b2707](https://github.com/kailong321200875/vue-element-plus-admin/commit/57b27071e9a33423c46542a5d0e5d5c2e9a3b718))

### [1.2.6](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.5...v1.2.6) (2022-04-08)

### Build System

- update plugins ([d645892](https://github.com/kailong321200875/vue-element-plus-admin/commit/d645892cde2f7f43215a2ba1776ee94a322437bf))

### [1.2.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.4...v1.2.5) (2022-04-08)

### Performance Improvements

- add plop ([fa54a17](https://github.com/kailong321200875/vue-element-plus-admin/commit/fa54a1704ffd93f7b42dbeb1229bc4868d2d3a6a))

### Build System

- update plugins ([18c6bd8](https://github.com/kailong321200875/vue-element-plus-admin/commit/18c6bd868622d954b51ea34e37516361ad4eb540))

### Styling

- fix padding and background color ([f8c9d54](https://github.com/kailong321200875/vue-element-plus-admin/commit/f8c9d54687edafd92f5b61bf5288bb1188c73f01))

### [1.2.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.3...v1.2.4) (2022-04-06)

### Bug Fixes

- add Sticky props comment ([46133b3](https://github.com/kailong321200875/vue-element-plus-admin/commit/46133b3ff39d48d11cbcaa1f20a271118f48eb29))
- fix bug ([179ca06](https://github.com/kailong321200875/vue-element-plus-admin/commit/179ca064ba8adbb3b063d9798ec1930ccc68e459))
- fix remove unnecessary variables ([ca01cbf](https://github.com/kailong321200875/vue-element-plus-admin/commit/ca01cbfd98b63a0d76190fe8d43097fdc9df74e6))
- fix style ([17c8fea](https://github.com/kailong321200875/vue-element-plus-admin/commit/17c8fea93811d9d9b708808484f5c907d761fcf1))
- remove ContentDetailWrap style ([4ceaa9d](https://github.com/kailong321200875/vue-element-plus-admin/commit/4ceaa9d7816369d0dcaf3e18e4cdbbd6165cef88))

### [1.2.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.2...v1.2.3) (2022-03-31)

### Bug Fixes

- fix refresh with query ([e94020f](https://github.com/kailong321200875/vue-element-plus-admin/commit/e94020ff541a061599486c0003258f1dbf13aba8))

### [1.2.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.1...v1.2.2) (2022-03-30)

### Bug Fixes

- fix avatar height bug ([cd4ab76](https://github.com/kailong321200875/vue-element-plus-admin/commit/cd4ab767018941777174d7837045f5259d1cc403))
- fix parmas to params ([2c7211c](https://github.com/kailong321200875/vue-element-plus-admin/commit/2c7211c89d7299ffc0a36bef8999b3c201dbaf4a))

### [1.2.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.2.0...v1.2.1) (2022-03-29)

### Bug Fixes

- fix invalid paging ([ad184ee](https://github.com/kailong321200875/vue-element-plus-admin/commit/ad184ee9c0619da36f1ca3f26e67f18f88488523))

### Build System

- update plugins ([0c7276f](https://github.com/kailong321200875/vue-element-plus-admin/commit/0c7276feadaedef83e6a4ad9d457e26d408698a8))

## [1.2.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.14...v1.2.0) (2022-03-27)

### Features

- add hooks demo ([c43f39e](https://github.com/kailong321200875/vue-element-plus-admin/commit/c43f39efef296266c64cc24690717d07fa0bcb85))
- add inputPassword demo ([8f8b126](https://github.com/kailong321200875/vue-element-plus-admin/commit/8f8b1260e75df6998ebea617f62d4ab6be81d721))

### Docs

- update LICENSE ([69d3dcc](https://github.com/kailong321200875/vue-element-plus-admin/commit/69d3dcc7edf69e9b4e3042ddb11faa85ec7d39e2))

### Styling

- modify the function name to make it more semantic ([046ae51](https://github.com/kailong321200875/vue-element-plus-admin/commit/046ae512f02df2d3f08134949b9376a061c1eef3))
- update Footer component presentation ([d4a9ba3](https://github.com/kailong321200875/vue-element-plus-admin/commit/d4a9ba3aa6758b8aac18b30e1a6b9501baff826c))
- update Icon demo ([8597122](https://github.com/kailong321200875/vue-element-plus-admin/commit/85971227cd3055ea280cf493c7c42b250c1515da))

### Tests

- test push first commit ([a67bb48](https://github.com/kailong321200875/vue-element-plus-admin/commit/a67bb48f269651a2dcd01b9e33d10f20c42d76ee))

### Build System

- update plugins ([9c13d92](https://github.com/kailong321200875/vue-element-plus-admin/commit/9c13d92b36a2a7c95b9edb7821367fc8f0ac6658))
- update server port ([d2be8c1](https://github.com/kailong321200875/vue-element-plus-admin/commit/d2be8c1a307a3c5daf363bd7f1d21e574598de5c))

### [1.1.14](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.13...v1.1.14) (2022-03-22)

### Bug Fixes

- fix the bug that the form search function is invalid of the example-dialog page ([9ec30e7](https://github.com/kailong321200875/vue-element-plus-admin/commit/9ec30e719f89865497dbb1321be1df906f59f14e))

### [1.1.13](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.12...v1.1.13) (2022-03-17)

### Build System

- update plugins ([a2d0313](https://github.com/kailong321200875/vue-element-plus-admin/commit/a2d03137899f9b16fc1d4a09a23576cd74e7950e))

### [1.1.12](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.11...v1.1.12) (2022-03-15)

### Build System

- update plugins ([fee2252](https://github.com/kailong321200875/vue-element-plus-admin/commit/fee2252930b05b709d0c012e809568c4ed32bd89))

### [1.1.11](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.10...v1.1.11) (2022-03-15)

### Bug Fixes

- fix the problem of blank bar when toggle the TagsView component ([b1d9771](https://github.com/kailong321200875/vue-element-plus-admin/commit/b1d9771c750709fe45061d13299a85dbbd6ead25))
- fix the problem that no reaction when copy setting config in http page ([61e0e33](https://github.com/kailong321200875/vue-element-plus-admin/commit/61e0e33c64d6a889fe6ed80d27a10cf8b201d21a))

### [1.1.10](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.9...v1.1.10) (2022-03-13)

### Build System

- update plugins ([0b525c8](https://github.com/kailong321200875/vue-element-plus-admin/commit/0b525c875075a28288e92243b205b337f85ab550))

### [1.1.9](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.8...v1.1.9) (2022-03-07)

### Build System

- update plugins ([1456fd4](https://github.com/kailong321200875/vue-element-plus-admin/commit/1456fd49ec9abbfe1f25aeadfe5fed54fec07394))

### [1.1.8](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.7...v1.1.8) (2022-03-07)

### Docs

- update changelog ([bf09441](https://github.com/kailong321200875/vue-element-plus-admin/commit/bf09441852e59b0d07d4949a33de75958696817f))

### [1.1.7](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.6...v1.1.7) (2022-03-06)

### Styling

- add labelMessage attribute to Form component ([8c42790](https://github.com/kailong321200875/vue-element-plus-admin/commit/8c427907843ccb2dfd882d27c1e8a894c5616487))

### [1.1.6](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.5...v1.1.6) (2022-03-04)

### Bug Fixes

- fix the problem that the tree data of Table component cannot be displayed ([bf83d3e](https://github.com/kailong321200875/vue-element-plus-admin/commit/bf83d3efbad9097f245c32cc07d1178580cec4e3))

### [1.1.5](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.4...v1.1.5) (2022-03-02)

### Bug Fixes

- fix the problem of tagsview error when loginout ([835d76a](https://github.com/kailong321200875/vue-element-plus-admin/commit/835d76ae87b950106f957976ebc8f6f2e8842ddf))

### Build System

- update plugins ([de34bb1](https://github.com/kailong321200875/vue-element-plus-admin/commit/de34bb193d6c844dbc1cec38db5f61b3f95e19f2))

### Styling

- fix tabMenu z-index bug ([8b3be02](https://github.com/kailong321200875/vue-element-plus-admin/commit/8b3be02368a1bddb7dc78f18adbea7f4ebfe75d6))
- fix tags-view style bug ([ebff817](https://github.com/kailong321200875/vue-element-plus-admin/commit/ebff81777b9c0b839256b83e321ecbdbff25fc73))

### [1.1.4](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.3...v1.1.4) (2022-03-01)

### CI

- update workflow ([0490d18](https://github.com/kailong321200875/vue-element-plus-admin/commit/0490d18145cb0d9c4b066ab01a2c10cb527e38ba))
- update workflow ([51f7bca](https://github.com/kailong321200875/vue-element-plus-admin/commit/51f7bca6034902b251d081ee383b0d796782d434))

### [1.1.3](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.2...v1.1.3) (2022-03-01)

### CI

- update workflow ([91cc5c5](https://github.com/kailong321200875/vue-element-plus-admin/commit/91cc5c595cadc5695d8f54bdc4922d8f04439f24))

### [1.1.2](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.1...v1.1.2) (2022-03-01)

### Workflows

- update workflow ([d9708aa](https://github.com/kailong321200875/vue-element-plus-admin/commit/d9708aae5bc0cb795bb0fbf8d17df753cc88ba1d))

### [1.1.1](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.1.0...v1.1.1) (2022-03-01)

### Workflows

- update workflow ([085328a](https://github.com/kailong321200875/vue-element-plus-admin/commit/085328aba8c4f356bf7915a6bbdc1ec4f46ceeda))

## [1.1.0](https://github.com/kailong321200875/vue-element-plus-admin/compare/v1.0.3...v1.1.0) (2022-03-01)

### Features

- 🎸 layout 三种布局重构完成 ([429e428](https://github.com/kailong321200875/vue-element-plus-admin/commit/429e42809cef33a33662e41ad50297217d128b8c))
- 🎸 layout 布局重构 �[bd24b92](https://github.com/kailong321200875/vue-element-plus-admin/commit/bd24b92acb279343dbaf83b74f1ed2a3f57f1003))
- 🎸 Table 组件重构完成并给出相应示 �[35879f8](https://github.com/kailong321200875/vue-element-plus-admin/commit/35879f8ecc0ffa76122a336e2eaa93ecfb408c1d))
- 🎸 v0.0.4 发布 ([a58dc1b](https://github.com/kailong321200875/vue-element-plus-admin/commit/a58dc1b1c2774974782ef6d116b8805975b82b1c))
- 🎸 初始化项 �[26d4c7c](https://github.com/kailong321200875/vue-element-plus-admin/commit/26d4c7c56894cf2031b3a7cce08d53c37f4a49e3))
- 🎸 初版完成 ([5bfe4d2](https://github.com/kailong321200875/vue-element-plus-admin/commit/5bfe4d236fd9c2841da100f34c980b4572b67b20))
- 🎸 新增 Detail 详情组件并给出相应示 �[e77a931](https://github.com/kailong321200875/vue-element-plus-admin/commit/e77a931ef2d2967a9717e27b187d68512c01284f))
- 🎸 新增二维码组 �[85555ee](https://github.com/kailong321200875/vue-element-plus-admin/commit/85555eef7dc7d72cb701bdd81044ba8fb8e72acc))
- 🎸 新增全局配置 ([f8405a6](https://github.com/kailong321200875/vue-element-plus-admin/commit/f8405a63c9b1288fbe95bae235b65a08e8fae8d2))
- 🎸 新增固定 � 级菜单配 �[4c4903e](https://github.com/kailong321200875/vue-element-plus-admin/commit/4c4903e806c8818e320108cc3e5279d728061c29))
- 🎸 新增权限管理及相关示例文 �[32b6583](https://github.com/kailong321200875/vue-element-plus-admin/commit/32b6583099646b2ee622ac7b35388468769b91b8))
- 🎸 显示更多组建 � 发中 ([fa9f24d](https://github.com/kailong321200875/vue-element-plus-admin/commit/fa9f24d5da8d2e40d7c3661eabacb8f0474a7bf2))
- 🎸 权限管理 � 发中 ([38f5211](https://github.com/kailong321200875/vue-element-plus-admin/commit/38f521174ba9eba750fee4516141d7a267f1c4ce))
- 🎸 权限管理 � 发中 ([6d7ea66](https://github.com/kailong321200875/vue-element-plus-admin/commit/6d7ea6694d8299332018a6689bcd82502a9a552c))
- 🎸 综合实例重构 �[5142e6e](https://github.com/kailong321200875/vue-element-plus-admin/commit/5142e6e323cb20c89a97398bf41d32c93ce42cad))
- 🎸 重构 layout ([7ede021](https://github.com/kailong321200875/vue-element-plus-admin/commit/7ede02141e258ab4c88e9b4daad966513d4dbe68))
- 🎸 重构 layout-classic 布局 ([29d9c98](https://github.com/kailong321200875/vue-element-plus-admin/commit/29d9c988605b822195900268da6bc3f3b0b9c770))
- 🎸 重构 sider 组件 �[51313d7](https://github.com/kailong321200875/vue-element-plus-admin/commit/51313d7116c7ab2ded7e3a65514ea9ac413edecd))
- Add analysis api ([83327ea](https://github.com/kailong321200875/vue-element-plus-admin/commit/83327ea763ebb233bb540513276ffa288fbcb4a1))
- Add analysis demo ([cd06934](https://github.com/kailong321200875/vue-element-plus-admin/commit/cd069340fc5157535fdc82e792c6b6dce7d7a97e))
- Add count-to demo ([d3fbd3a](https://github.com/kailong321200875/vue-element-plus-admin/commit/d3fbd3a06c3b802fc863b4dc8013122c14bd16f2))
- Add Descriptions component and add Descriptions demo ([7ad46f8](https://github.com/kailong321200875/vue-element-plus-admin/commit/7ad46f828d626a87699cd4d3a959a5634577d580))
- Add Dialog component and add dailog demo ([a18ad8f](https://github.com/kailong321200875/vue-element-plus-admin/commit/a18ad8f4a89b78c73e57d8d2543494243f656d05))
- add doucment link ([53201ae](https://github.com/kailong321200875/vue-element-plus-admin/commit/53201ae97a425714871d99e8847a3672ba0d389f))
- Add dynamic route ([9d926b2](https://github.com/kailong321200875/vue-element-plus-admin/commit/9d926b2760b75e1d8e71a68dc7ff6c5026223a43))
- Add Editor component and add editor demo ([3fb3e8d](https://github.com/kailong321200875/vue-element-plus-admin/commit/3fb3e8da39d816bcf4aedb65d40c7052bdb6d8bf))
- Add Error component ([7411dbc](https://github.com/kailong321200875/vue-element-plus-admin/commit/7411dbc9fd8f122187c86a11523b49c88cc71a8c))
- Add example-dialog demo ([262f421](https://github.com/kailong321200875/vue-element-plus-admin/commit/262f4211cf53aef30a32f4b88e88fb1b9246ffcb))
- Add example-page demo ([1492f91](https://github.com/kailong321200875/vue-element-plus-admin/commit/1492f9119aa2960cc05956218e6d151c8b316875))
- Add form demo ([472f574](https://github.com/kailong321200875/vue-element-plus-admin/commit/472f574f42f8f31c4e6047043ac755ba5fb35b7b))
- Add form demo ([e6f9580](https://github.com/kailong321200875/vue-element-plus-admin/commit/e6f95803316bb5df2d1060285c1d591a79340721))
- Add form demo ([543156f](https://github.com/kailong321200875/vue-element-plus-admin/commit/543156f328350bd12e71a41c872e547e41cda7fe))
- Add form demo ([7795d2a](https://github.com/kailong321200875/vue-element-plus-admin/commit/7795d2a4fe3dbc9849ddc7c1d3e2d9215dc66f56))
- Add guide demo ([0832194](https://github.com/kailong321200875/vue-element-plus-admin/commit/0832194e6131051416edff7c2eac6b0a016ffd80))
- Add highlight demo ([eb206b0](https://github.com/kailong321200875/vue-element-plus-admin/commit/eb206b0cc31ac7da3dfd8b3d4b874061c5c91d53))
- Add Icon demo ([e4b7a76](https://github.com/kailong321200875/vue-element-plus-admin/commit/e4b7a769126d6f0fca424007c294ff229eefcb35))
- Add ImageViewer component and add ImageViewer demo ([af9fc0a](https://github.com/kailong321200875/vue-element-plus-admin/commit/af9fc0a4aded3ec08746ddeaeabac4c3cfa9463d))
- Add Infotip component ([e4b7a76](https://github.com/kailong321200875/vue-element-plus-admin/commit/e4b7a769126d6f0fca424007c294ff229eefcb35))
- Add infotip demo ([dbf3b0f](https://github.com/kailong321200875/vue-element-plus-admin/commit/dbf3b0f5a333ccef524bbac825035b0c6dc78ec9))
- Add Qrcode component and add qrcode demo ([535a31b](https://github.com/kailong321200875/vue-element-plus-admin/commit/535a31b35eb6a76589f602fd96dcf91f46f349b0))
- Add Search component and add search demo ([33eca8a](https://github.com/kailong321200875/vue-element-plus-admin/commit/33eca8a97d59f5cc453e1a60ee81b1519527d0f1))
- Add Table component and add useTable hook ([17e8e7c](https://github.com/kailong321200875/vue-element-plus-admin/commit/17e8e7cda9a009818f11cfa0429ce0f9adc00be5))
- Add useScrollTo hook ([7d7fd9e](https://github.com/kailong321200875/vue-element-plus-admin/commit/7d7fd9ed646d2b68cec0547ad8e65b0404bb95bb))
- Add useWatermark hook and add useWatermark demo ([d3fbd3a](https://github.com/kailong321200875/vue-element-plus-admin/commit/d3fbd3a06c3b802fc863b4dc8013122c14bd16f2))
- Add workplace api ([cb558f8](https://github.com/kailong321200875/vue-element-plus-admin/commit/cb558f8af9dfef2ba2879f021db395ee79e8c8d4))
- **Animate:** Add animate.css ([1436543](https://github.com/kailong321200875/vue-element-plus-admin/commit/1436543a5c599f651ed7805165ea83b9ebcddef5))
- **Breadcrumbe:** Add Breadcrumb component ([4612e55](https://github.com/kailong321200875/vue-element-plus-admin/commit/4612e5544bcd626d686972e5cb874d0aa4af08b3))
- **component:** Add CountTo component and Echart component ([e20fa76](https://github.com/kailong321200875/vue-element-plus-admin/commit/e20fa76cad0894a69fd04c81c2108faabf392684))
- **component:** Add Footer component ([dad7330](https://github.com/kailong321200875/vue-element-plus-admin/commit/dad733063413c79eca61c6cb5ff671b35933a85f))
- **component:** Add Footer component ([f81e996](https://github.com/kailong321200875/vue-element-plus-admin/commit/f81e996a426538aeaa2aa37a540395dcf360a09c))
- **Component:** Add Highlight component ([c53fa56](https://github.com/kailong321200875/vue-element-plus-admin/commit/c53fa562e540447df082e35c7f26e56f2426e430))
- **component:** Add namespace of class ([d847ccb](https://github.com/kailong321200875/vue-element-plus-admin/commit/d847ccb098edc72fe55c1f8459bf149453a3b73d))
- **Component:** Setting component add copy button ([e496096](https://github.com/kailong321200875/vue-element-plus-admin/commit/e496096539e6a56b0761a625c9d59210facc5432))
- **ContextMenu:** Add ContextMenu component ([349ac9d](https://github.com/kailong321200875/vue-element-plus-admin/commit/349ac9d3989d77e5246cecf0006dd8d83c489990))
- Detail 组件重构完成 ([7f5ef99](https://github.com/kailong321200875/vue-element-plus-admin/commit/7f5ef99ccc32b03f7be21f70c333bb8e679c7d93))
- Highlight 组件重构 ([34221f3](https://github.com/kailong321200875/vue-element-plus-admin/commit/34221f387f5e15a08cdc21edd76ce8d8c5c20fbc))
- **hooks:** Add useIntro hook ([0832194](https://github.com/kailong321200875/vue-element-plus-admin/commit/0832194e6131051416edff7c2eac6b0a016ffd80))
- **hooks:** Add useTimeAgo hook ([c53fa56](https://github.com/kailong321200875/vue-element-plus-admin/commit/c53fa562e540447df082e35c7f26e56f2426e430))
- **I18n:** Add Ii8n ([3810b8c](https://github.com/kailong321200875/vue-element-plus-admin/commit/3810b8c3b26f86c27aa7db479dfb7b0d283d970f))
- **Layout:** Add classic layout ([839b601](https://github.com/kailong321200875/vue-element-plus-admin/commit/839b6015b8e31bf70e6f0bf0608fa729b028729b))
- **Layout:** Add cutMenu layout ([ff4dd3a](https://github.com/kailong321200875/vue-element-plus-admin/commit/ff4dd3afbf5c0c7a439c71b0c494b81e0f2c70d4))
- **Layout:** Add topLeft layout ([71b1c5e](https://github.com/kailong321200875/vue-element-plus-admin/commit/71b1c5e10cade8d1c018d0c5f63c98ba9357bab8))
- **LocaleDropdown:** Add LocaleDropdown Component ([3810b8c](https://github.com/kailong321200875/vue-element-plus-admin/commit/3810b8c3b26f86c27aa7db479dfb7b0d283d970f))
- **Logo:** Add Logo component ([958edef](https://github.com/kailong321200875/vue-element-plus-admin/commit/958edefe7bc2bf3ae77520a5d885a9d47e8a37b9))
- **mock:** Add mock ([3fc7d4d](https://github.com/kailong321200875/vue-element-plus-admin/commit/3fc7d4d39a72056fcf419fe19a9d41d90f945bad))
- **router:** Add dynamic routing ([b218ccc](https://github.com/kailong321200875/vue-element-plus-admin/commit/b218ccc9cce2ce1363c4a21d22b4d69c43c7b2dc))
- Search component add expand attribute and expandField attribute ([9b4b317](https://github.com/kailong321200875/vue-element-plus-admin/commit/9b4b31781765d31dec50acc40e2eed91401502d4))
- **store:** Add localeStore ([3810b8c](https://github.com/kailong321200875/vue-element-plus-admin/commit/3810b8c3b26f86c27aa7db479dfb7b0d283d970f))
- **store:** Add tagsView store ([349ac9d](https://github.com/kailong321200875/vue-element-plus-admin/commit/349ac9d3989d77e5246cecf0006dd8d83c489990))
- Table 组件重构 ([07adefb](https://github.com/kailong321200875/vue-element-plus-admin/commit/07adefb89b7555280e6217e09cf81ba7aa5b93c2))
- **TagsView:** Add TagsView component ([349ac9d](https://github.com/kailong321200875/vue-element-plus-admin/commit/349ac9d3989d77e5246cecf0006dd8d83c489990))
- **useForm:** Add useForm ([357fc44](https://github.com/kailong321200875/vue-element-plus-admin/commit/357fc44e519c5829567c17f611fcaadee3f9f933))
- **useNProgress:** Add useNProgress ([c5ab359](https://github.com/kailong321200875/vue-element-plus-admin/commit/c5ab3599c8ea001ff7831b72fefc9e274163fbbb))
- **useTitle:** Add useTitle ([c5ab359](https://github.com/kailong321200875/vue-element-plus-admin/commit/c5ab3599c8ea001ff7831b72fefc9e274163fbbb))
- **utils:** Add color utils ([71dfba2](https://github.com/kailong321200875/vue-element-plus-admin/commit/71dfba21c5bc0276689b5aecf0d75e53efdda09f))
- **VForm:** Add VForm component ([448ac52](https://github.com/kailong321200875/vue-element-plus-admin/commit/448ac5293e48a03840df2bb0b399a8f02aae666e))
- **VInputPassword:** Add VInputPassword Component ([a1bf7e9](https://github.com/kailong321200875/vue-element-plus-admin/commit/a1bf7e9b552f75d3b87c64904ac9e7c99fc936a5))
- **Workplace:** Add wrokplace demo ([c53fa56](https://github.com/kailong321200875/vue-element-plus-admin/commit/c53fa562e540447df082e35c7f26e56f2426e430))
- 综合实例、权限管理重 �[a4bd206](https://github.com/kailong321200875/vue-element-plus-admin/commit/a4bd2068a5d40d146b5b45cb3727ced990147b68))
- 部分组件重构完成 ([3d96229](https://github.com/kailong321200875/vue-element-plus-admin/commit/3d9622978dc234ef12dbce63e18caf3440563aa0))

### Bug Fixes

- 🐛 删除 Editor 双向绑定，改 �props 传参 ([c395e27](https://github.com/kailong321200875/vue-element-plus-admin/commit/c395e27f67af9f60b151a5484ab5a3c90c4c1d1e))
- fix Form component setProps not work bug ([48ffc52](https://github.com/kailong321200875/vue-element-plus-admin/commit/48ffc52ca8fa26d8e6a5fa4b8b3001701a1f0732))
- fix useScrollTo not work bug ([53201ae](https://github.com/kailong321200875/vue-element-plus-admin/commit/53201ae97a425714871d99e8847a3672ba0d389f))
- 修复 tagsView 无动画效 �[0e3eb4b](https://github.com/kailong321200875/vue-element-plus-admin/commit/0e3eb4ba8b1503e1d221dfda59a3a0001dbdcb56))

### Performance Improvements

- update useForm hook ([8a958cd](https://github.com/kailong321200875/vue-element-plus-admin/commit/8a958cd71d9afbd32b243aac0814bfa3281477cd))

### Code Refactoring

- 💡 综合实例查看详情重构 ([9c26edd](https://github.com/kailong321200875/vue-element-plus-admin/commit/9c26edd5d599b5fb5a832fb547e3d95b6bfa9a98))

### Build System

- Add conventional-changelog-cli plugin ([384485f](https://github.com/kailong321200875/vue-element-plus-admin/commit/384485f6994c6ac33abee506508ab9d35fe658a9))
- Add conventional-github-releaser plugin ([3cd5c71](https://github.com/kailong321200875/vue-element-plus-admin/commit/3cd5c71899dde3ac3910aef0180d8b39fad51f1b))
- Add standard-version plugin ([110ce25](https://github.com/kailong321200875/vue-element-plus-admin/commit/110ce257841648e29b247a0338624a188694b6e9))
- Add vite-plugin-html plugin ([d5b6e2a](https://github.com/kailong321200875/vue-element-plus-admin/commit/d5b6e2a7770eb59aa32839f69da5be37397e3538))
- delete useless plugin ([c756761](https://github.com/kailong321200875/vue-element-plus-admin/commit/c756761dfc3200156acb228474d3539197ef413b))
- **pinia:** Add pinia ([2040500](https://github.com/kailong321200875/vue-element-plus-admin/commit/2040500af14d277a79f01eba5eca2a440203cecf))
- **types:** Add vue-types ([2c41826](https://github.com/kailong321200875/vue-element-plus-admin/commit/2c41826c572268b74a663a6966c548628ac7e280))
- **unplugin-auto-import:** Delete unplugin-auto-import ([2040500](https://github.com/kailong321200875/vue-element-plus-admin/commit/2040500af14d277a79f01eba5eca2a440203cecf))
- **unplugin-vue-components:** Delete unplugin-vue-components ([2040500](https://github.com/kailong321200875/vue-element-plus-admin/commit/2040500af14d277a79f01eba5eca2a440203cecf))
- update plugin ([8d08bc6](https://github.com/kailong321200875/vue-element-plus-admin/commit/8d08bc6fc92258674abdd12834eaa4530ec276dd))
- update plugins ([3c58042](https://github.com/kailong321200875/vue-element-plus-admin/commit/3c580420a20121845f02c0dd3caca5a74f06a89d))
- **vite-plugin-style-import:** Add vite-plugin-style-import ([2040500](https://github.com/kailong321200875/vue-element-plus-admin/commit/2040500af14d277a79f01eba5eca2a440203cecf))
- **vite-plugin-vue-setup-extend:** Delete vite-plugin-vue-setup-extend ([2040500](https://github.com/kailong321200875/vue-element-plus-admin/commit/2040500af14d277a79f01eba5eca2a440203cecf))
- 修改 vite 配置 ([9991fb4](https://github.com/kailong321200875/vue-element-plus-admin/commit/9991fb4e5c46b9e4016beaade7232e28dc272797))
- 设置多语 �([45e879e](https://github.com/kailong321200875/vue-element-plus-admin/commit/45e879edeef677b6aa1d2cfe4dd8dc5b76c83c59))
- 配置代码格式 �[ffdb556](https://github.com/kailong321200875/vue-element-plus-admin/commit/ffdb556a096db247306eae8eecc1b85718314cdd))
- 集成基础配置 ([ced99de](https://github.com/kailong321200875/vue-element-plus-admin/commit/ced99de9b113a01d9d0b190f6d2c6adc983a3102))
- 集成基础配置 ([5dbcf23](https://github.com/kailong321200875/vue-element-plus-admin/commit/5dbcf2397ccdec80c695c113f49e8aa9bb6d012c))

### Styling

- 💄 优化 layout 样式 ([37ec378](https://github.com/kailong321200875/vue-element-plus-admin/commit/37ec378f0b2bf83d73ddf0e472aada6aab248f09))
- 💄 微调样式 ([612b486](https://github.com/kailong321200875/vue-element-plus-admin/commit/612b48673c3389779ccfdd161e2ca80b21d265b2))
- Add elNamespace ([d847ccb](https://github.com/kailong321200875/vue-element-plus-admin/commit/d847ccb098edc72fe55c1f8459bf149453a3b73d))
- **appStore:** code style ([641ed68](https://github.com/kailong321200875/vue-element-plus-admin/commit/641ed684fefeb52e2f91e8baab7b610fc74c8d88))
- **Breadcrumb:** fix Breadcrumb style bug ([8755c86](https://github.com/kailong321200875/vue-element-plus-admin/commit/8755c862b837d90a25b27c01fabe64abf81fc4a2))
- **breadcrumb:** update disabled text color ([1522e92](https://github.com/kailong321200875/vue-element-plus-admin/commit/1522e925bae37cb9df4de2252d81f717788f4537))
- change function to arrow function ([4612e55](https://github.com/kailong321200875/vue-element-plus-admin/commit/4612e5544bcd626d686972e5cb874d0aa4af08b3))
- delete console.log ([49a6bfe](https://github.com/kailong321200875/vue-element-plus-admin/commit/49a6bfe9d81a40e2f5f15b68d7289e1787e89b54))
- **Icon:** delete default color ([95a2bd8](https://github.com/kailong321200875/vue-element-plus-admin/commit/95a2bd884dd9846a56cda7c4c3ee4a41ce631b7c))
- level demo style beautification ([dbf3b0f](https://github.com/kailong321200875/vue-element-plus-admin/commit/dbf3b0f5a333ccef524bbac825035b0c6dc78ec9))
- lint code style ([b292419](https://github.com/kailong321200875/vue-element-plus-admin/commit/b2924190b8996e8208f951e3fadbcb09baddb8df))
- **Login:** update login styles ([eb68f1d](https://github.com/kailong321200875/vue-element-plus-admin/commit/eb68f1d919e13c07b7d200e9aec53804b2a6dc7b))
- modify menu z-index attribute ([0d7a778](https://github.com/kailong321200875/vue-element-plus-admin/commit/0d7a7781ce0b5e39f01355d3acdb3f364cabf76d))
- **TagView:** Vertical center tag ([41281c4](https://github.com/kailong321200875/vue-element-plus-admin/commit/41281c4d541a2744e5df5dff2764cc85465b6a4c))

### Types

- add ImportMetaEnv ([38e0257](https://github.com/kailong321200875/vue-element-plus-admin/commit/38e0257487e4138a74ad1bb4ee4ba004abcfaa12))
- Adding BfFrom Component types ([8e036f5](https://github.com/kailong321200875/vue-element-plus-admin/commit/8e036f54b56ce8521eb8ec4b7ca21aa9c24f43f2))
- **BfForm:** Adding BfForm types ([bc9195b](https://github.com/kailong321200875/vue-element-plus-admin/commit/bc9195b21eeb79629a82a04d90e2ac5aa6592928))
- **BfForm:** Adding BfForm types ([184b468](https://github.com/kailong321200875/vue-element-plus-admin/commit/184b468cd41dcd1cdae11477b9ee2d6e17de1481))
- **BfForm:** Adding BfForm types ([58cb24d](https://github.com/kailong321200875/vue-element-plus-admin/commit/58cb24d9f8a50be80b5ea793387d582a77a59137))
- delete useless types ([3fc79c0](https://github.com/kailong321200875/vue-element-plus-admin/commit/3fc79c0ae7acd0929f47e33f96c8d45a90d8f762))
- **VForm:** Adding VForm types ([7528fe6](https://github.com/kailong321200875/vue-element-plus-admin/commit/7528fe6da60368213d28d9f1b6310d02d3d53282))

### Docs

- ✏️ 修改 readme ([8edb2a3](https://github.com/kailong321200875/vue-element-plus-admin/commit/8edb2a3493dca975036859b5d2c52afaa91f5dbb))
- ✏️ 更新 readme ([62eeb55](https://github.com/kailong321200875/vue-element-plus-admin/commit/62eeb55330dd4af2a46801c7a19f38a3ef312bbf))
- Add README.md ([21dcf88](https://github.com/kailong321200875/vue-element-plus-admin/commit/21dcf88ba31957bbdb50c6207d010650daab70fc))
- Error modifying readme name ([25d5c84](https://github.com/kailong321200875/vue-element-plus-admin/commit/25d5c84e92e68aa72362a14f55aacd946fa5b1b2))
- update description ([be6ff98](https://github.com/kailong321200875/vue-element-plus-admin/commit/be6ff9899b25cc00519210950d27ee56ac5112e6))
- update description ([c15aa87](https://github.com/kailong321200875/vue-element-plus-admin/commit/c15aa8755c9c937512c7380a6d03c4d877ef4d87))
- update README ([27979dc](https://github.com/kailong321200875/vue-element-plus-admin/commit/27979dc6def7d9d8cea62a08d49a6c828be2258b))
- update README.md ([53201ae](https://github.com/kailong321200875/vue-element-plus-admin/commit/53201ae97a425714871d99e8847a3672ba0d389f))
- update README.md ([c11823a](https://github.com/kailong321200875/vue-element-plus-admin/commit/c11823abd8a033e14b4c20d17ac941195d39bcfe))
- 修改 README ([b79a567](https://github.com/kailong321200875/vue-element-plus-admin/commit/b79a56753df55976e749c4494266df052d315416))
