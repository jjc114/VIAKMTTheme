# VIA 浏览器国民党主题 LSPosed 模块 - 使用指南

## 快速上手

### 📦 从 GitHub Actions 下载 APK

1. 访问: https://github.com/jjc114/VIAKMTTheme/actions
2. 点击最新的 ✅ 成功构建
3. 滚动到底部 **Artifacts** 部分
4. 下载 **VIA-KMT-Theme-LSPosed** ZIP
5. 解压得到 `app-release.apk`

### 📱 安装步骤

1. 传输 APK 到已 Root 的 Android 手机
2. 安装 APK
3. 打开 **LSPosed 管理器**
4. 在「模块」中启用「VIA 国民党主题」
5. 勾选作用域:「VIA 浏览器」(mark.via.gp)
6. **强制停止** VIA 浏览器
7. 重新打开 VIA 查看效果

## 🎨 主题效果

- 🔵 状态栏: 国民党蓝 (#0000CD)
- 🔵 工具栏: 国民党蓝
- 🔷 进度条: 天蓝色 (#1E90FF)  
- ⚫ 导航栏: 深蓝 (#00008B)
- ⚪ 整体白蓝配色

## 🔧 故障排除

**Q: 模块已启用但没效果?**
- 确认已勾选「VIA 浏览器」作用域
- **强制停止** VIA 浏览器(不是重启手机)
- 查看 LSPosed 日志是否有 "VIA 国民党主题" 相关信息

**Q: LSPosed 显示模块未激活?**
- 重新安装模块 APK
- 检查 LSPosed 版本是否过旧

**Q: GitHub Actions 构建失败?**
- 查看本仓库的 Actions 日志
- 如果是 Gradle 版本问题,已在最新配置中修复

## 📚 技术说明

- **Gradle**: 7.6.4 (稳定兼容版本)
- **Android Gradle Plugin**: 7.3.1
- **Target SDK**: 33 (Android 13)
- **Min SDK**: 24 (Android 7.0)

## 📄 许可证

MIT License

---

完整文档: https://github.com/jjc114/VIAKMTTheme
