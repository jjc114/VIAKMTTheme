# 如何使用 GitHub Actions 云编译

本项目已配置好 GitHub Actions 自动构建,无需本地 Android 开发环境即可生成 APK。

## 📋 准备工作

1. **GitHub 账号**: 确保你有 GitHub 账号
2. **Git 工具**: 安装 Git (https://git-scm.com/)

## 🚀 上传项目到 GitHub

### 步骤 1: 创建 GitHub 仓库

1. 登录 GitHub (https://github.com)
2. 点击右上角 `+` → `New repository`
3. 填写信息:
   - Repository name: `VIAKMTTheme`
   - Description: `VIA 浏览器国民党主题 LSPosed 模块`
   - 选择 `Public` 或 `Private`
   - ⚠️ **不要** 勾选 "Initialize this repository with a README"
4. 点击 `Create repository`

### 步骤 2: 上传本地代码

在 Windows PowerShell 中执行:

```powershell
# 进入项目目录
cd F:\VIAKMTTheme

# 初始化 Git 仓库
git init

# 添加所有文件
git add .

# 提交
git commit -m "初始提交: VIA 国民党主题 LSPosed 模块"

# 设置主分支名称
git branch -M main

# 关联远程仓库 (替换成你的 GitHub 用户名)
git remote add origin https://github.com/你的用户名/VIAKMTTheme.git

# 推送到 GitHub
git push -u origin main
```

**如果需要身份验证:**
- 使用 GitHub Personal Access Token (PAT)
- 生成方式: GitHub → Settings → Developer settings → Personal access tokens → Generate new token
- 权限选择: `repo` (完整仓库访问权限)

## ⚙️ GitHub Actions 自动构建

### 推送代码后会自动触发构建

1. 推送完成后,访问你的仓库页面
2. 点击 `Actions` 标签
3. 可以看到构建任务正在运行

### 构建过程 (约 3-5 分钟)

- ✅ 检出代码
- ✅ 设置 JDK 17
- ✅ 下载 Gradle 依赖
- ✅ 编译 APK
- ✅ 上传构建产物

### 下载构建好的 APK

**方法一: 从 Actions 下载**

1. 进入 `Actions` 页面
2. 点击最新的成功构建 (绿色勾号)
3. 在页面底部 `Artifacts` 部分
4. 点击 `VIA-KMT-Theme-LSPosed` 下载 ZIP
5. 解压得到 `app-release.apk`

**方法二: 创建 Release**

```bash
# 打标签并推送 (会自动创建 Release)
git tag v1.0
git push origin v1.0
```

然后在仓库的 `Releases` 页面直接下载 APK。

## 🔄 更新代码并重新构建

修改代码后:

```bash
# 1. 添加修改
git add .

# 2. 提交
git commit -m "更新: 描述你的修改内容"

# 3. 推送
git push

# GitHub Actions 会自动重新构建
```

## 🛠️ 手动触发构建

1. 进入仓库的 `Actions` 页面
2. 选择 `构建 VIA 国民党主题 LSPosed 模块` 工作流
3. 点击 `Run workflow` 按钮
4. 选择分支并点击 `Run workflow` 确认

## 📱 安装到手机

1. 下载构建好的 `app-release.apk`
2. 传输到 Android 手机
3. 安装 APK
4. 在 LSPosed 管理器中:
   - 启用 "VIA 国民党主题" 模块
   - 勾选 "VIA 浏览器" (mark.via.gp)
   - 重启 VIA 浏览器

## 🔍 查看构建日志

如果构建失败:

1. 进入 `Actions` 页面
2. 点击失败的构建 (红色 X)
3. 点击 `build` 任务
4. 展开各个步骤查看详细日志
5. 根据错误信息修改代码

## ⚠️ 常见问题

**Q: 推送代码时要求身份验证?**
- 使用 GitHub Personal Access Token (PAT) 代替密码
- 在 Git 凭据管理器中保存 PAT

**Q: Actions 构建失败?**
- 检查 `build.yml` 文件格式是否正确
- 查看构建日志找出具体错误
- 确保所有必需文件都已提交

**Q: 下载的 ZIP 文件没有 APK?**
- 确认构建成功完成 (绿色勾号)
- 解压 ZIP 文件,APK 在里面

**Q: 想修改颜色怎么办?**
1. 修改 `app/src/main/res/values/colors.xml`
2. 提交并推送代码
3. GitHub Actions 会自动重新构建新版本

## 🎯 优势

✅ **无需本地环境**: 不需要安装 Android Studio, Gradle, JDK  
✅ **自动化构建**: 推送代码即可自动编译  
✅ **版本管理**: 每次构建都有记录,可回溯  
✅ **多人协作**: 团队成员都可以访问最新构建  
✅ **持续集成**: 自动测试和构建流程  

## 🔗 相关链接

- [GitHub Actions 文档](https://docs.github.com/actions)
- [Git 安装指南](https://git-scm.com/book/zh/v2/%E8%B5%B7%E6%AD%A5-%E5%AE%89%E8%A3%85-Git)
- [GitHub PAT 生成](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)

---

完成以上步骤后,你就可以通过 GitHub Actions 云端编译生成 APK 了!
