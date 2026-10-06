# VIA 浏览器国民党主题 LSPosed 模块

[![构建状态](https://github.com/你的用户名/VIAKMTTheme/workflows/构建%20VIA%20国民党主题%20LSPosed%20模块/badge.svg)](https://github.com/你的用户名/VIAKMTTheme/actions)

为 VIA 浏览器 7.3.4 应用国民党/蒋介石主题,采用白蓝配色方案。

## 📥 下载

**通过 GitHub Actions 自动构建:**

1. 前往 [Actions](https://github.com/你的用户名/VIAKMTTheme/actions) 页面
2. 点击最新的成功构建
3. 在 "Artifacts" 部分下载 `VIA-KMT-Theme-LSPosed`
4. 解压 ZIP 文件获得 APK

**或从 Releases 下载:**

前往 [Releases](https://github.com/你的用户名/VIAKMTTheme/releases) 下载最新版本的 APK

## ✨ 特性

- ✅ 国民党主题色 (#0000CD)
- ✅ 白蓝配色方案
- ✅ 自动修改状态栏/导航栏颜色
- ✅ 工具栏/地址栏主题替换
- ✅ 进度条天蓝色
- ✅ 支持 LSPosed 和 EdXposed

## 🎨 主题色方案

| 颜色名称 | 十六进制 | 用途 |
|---------|---------|------|
| 国民党蓝 | `#0000CD` | 主色调、工具栏、状态栏 |
| 白色 | `#FFFFFF` | 背景色、文字 |
| 天蓝 | `#1E90FF` | 进度条、强调色 |
| 深蓝 | `#00008B` | 导航栏 |
| 天空蓝 | `#87CEEB` | 辅助色 |

## 📋 系统要求

- ✅ Android 7.0+ (API 24+)
- ✅ 已 Root 的设备
- ✅ LSPosed 或 EdXposed 框架
- ✅ VIA 浏览器 7.3.4

## 🚀 安装步骤

### 方法一: 使用 GitHub Actions 构建的 APK

1. 从 [Actions](https://github.com/你的用户名/VIAKMTTheme/actions) 或 [Releases](https://github.com/你的用户名/VIAKMTTheme/releases) 下载 APK
2. 安装到手机
3. 打开 LSPosed 管理器
4. 在「模块」列表中找到「VIA 国民党主题」
5. 启用模块并勾选「VIA 浏览器」(mark.via.gp)
6. 重启 VIA 浏览器

### 方法二: 本地编译

```bash
# 克隆仓库
git clone https://github.com/你的用户名/VIAKMTTheme.git
cd VIAKMTTheme

# 编译
./gradlew assembleRelease

# APK 位于: app/build/outputs/apk/release/app-release.apk
```

## 📖 使用说明

1. **安装模块**: 将 APK 安装到已 Root 的 Android 设备
2. **启用模块**: 在 LSPosed 管理器中启用「VIA 国民党主题」
3. **配置作用域**: 勾选「VIA 浏览器」(包名: mark.via.gp)
4. **重启应用**: 强制停止并重新打开 VIA 浏览器
5. **验证效果**: 工具栏应显示为国民党蓝色

## ✅ 验证模块是否生效

打开 VIA 浏览器后检查:

- ✅ 状态栏是否为国民党蓝 (#0000CD)
- ✅ 导航栏是否为深蓝 (#00008B)
- ✅ 工具栏背景是否为国民党蓝
- ✅ 进度条是否为天蓝色
- ✅ 整体是否呈现白蓝配色

## 🐛 调试日志

在 LSPosed 管理器中查看模块日志:

```
VIA 国民党主题: 开始加载模块
VIA 国民党主题: 主题Hook成功
VIA 国民党主题: Activity主题已应用
VIA 国民党主题: 替换深色背景为国民党蓝
```

## 🎨 自定义颜色

编辑 `app/src/main/res/values/colors.xml`:

```xml
<color name="kmt_blue">#0000CD</color>     <!-- 主色调 -->
<color name="kmt_light_blue">#1E90FF</color> <!-- 进度条 -->
<color name="kmt_dark_blue">#00008B</color>  <!-- 导航栏 -->
```

修改后推送到 GitHub,Actions 会自动重新构建。

## 🔄 GitHub Actions 云编译

本项目配置了自动化构建:

- ✅ **推送代码时自动构建**: 每次推送到 main/master 分支都会触发构建
- ✅ **标签发布时创建 Release**: 推送 `v*` 标签会自动发布新版本
- ✅ **手动触发构建**: 在 Actions 页面可以手动运行工作流
- ✅ **构建产物下载**: 每次构建的 APK 都可以在 Artifacts 中下载

### 如何上传到 GitHub

```bash
# 1. 在 GitHub 创建新仓库 (不要初始化 README)

# 2. 在本地项目目录执行
cd F:\VIAKMTTheme
git init
git add .
git commit -m "Initial commit: VIA 国民党主题 LSPosed 模块"
git branch -M main
git remote add origin https://github.com/你的用户名/VIAKMTTheme.git
git push -u origin main

# 3. GitHub Actions 会自动开始构建
```

## 🔧 故障排除

**Q: 模块已启用但没有效果?**
- 确认已勾选「VIA 浏览器」作用域
- 确认已重启 VIA 浏览器(不是重启手机)
- 查看 LSPosed 日志是否有错误

**Q: 颜色显示不正确?**
- 确认 VIA 版本为 7.3.4
- 其他版本可能需要调整 Hook 代码

**Q: LSPosed 显示模块未激活?**
- 检查 `xposed_init` 文件是否存在
- 确认包名正确: com.example.viakmt.MainHook

## 🔗 兼容性

| 框架 | 支持情况 |
|------|---------|
| LSPosed | ✅ 完全支持 |
| EdXposed | ✅ 完全支持 |
| 太极/无极 | ⚠️ 未测试 |

| VIA 版本 | 支持情况 |
|---------|---------|
| 7.3.4 | ✅ 已测试 |
| 其他版本 | ⚠️ 可能需要调整 |

## 📜 许可证

MIT License

## 👨‍💻 开发者

- **作者**: Creator
- **版本**: 1.0
- **最后更新**: 2026-10-06

## 🙏 致谢

- [LSPosed Framework](https://github.com/LSPosed/LSPosed)
- [VIA 浏览器](https://viayoo.com)
- Xposed API

---

**免责声明**: 本模块仅供学习交流使用。使用本模块造成的任何问题,作者不承担责任。
# VIAKMTTheme
