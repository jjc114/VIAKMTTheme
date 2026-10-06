package com.example.viakmt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 模块设置界面(可选)
 * 在 LSPosed 中点击模块可以打开此界面
 */
public class SettingsActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView textView = new TextView(this);
        textView.setText("VIA 国民党主题模块\n\n" +
                "版本: 1.0\n" +
                "作者: Creator\n\n" +
                "功能说明:\n" +
                "- 自动应用国民党主题色(白蓝配色)\n" +
                "- 状态栏/导航栏为国民党蓝\n" +
                "- 工具栏使用白蓝搭配\n" +
                "- 进度条为天蓝色\n\n" +
                "使用方法:\n" +
                "1. 在 LSPosed 中启用本模块\n" +
                "2. 勾选「VIA 浏览器」作用域\n" +
                "3. 重启 VIA 浏览器生效\n\n" +
                "如需自定义颜色,请编辑源码重新编译。");
        textView.setPadding(50, 50, 50, 50);
        textView.setTextSize(16);
        
        setContentView(textView);
    }
}
