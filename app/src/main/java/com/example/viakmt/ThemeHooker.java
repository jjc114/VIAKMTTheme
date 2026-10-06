package com.example.viakmt;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class ThemeHooker {
    
    private final XC_LoadPackage.LoadPackageParam lpparam;
    
    // 国民党主题色
    private static final int KMT_BLUE = 0xFF0000CD;
    private static final int KMT_WHITE = 0xFFFFFFFF;
    private static final int KMT_LIGHT_BLUE = 0xFF1E90FF;
    private static final int KMT_SKY_BLUE = 0xFF87CEEB;
    private static final int KMT_DARK_BLUE = 0xFF00008B;
    
    public ThemeHooker(XC_LoadPackage.LoadPackageParam lpparam) {
        this.lpparam = lpparam;
    }
    
    public void hook() {
        hookActivityTheme();
        hookViewBackgrounds();
        hookProgressBarTheme();
    }
    
    /**
     * Hook Activity 主题
     */
    private void hookActivityTheme() {
        XposedHelpers.findAndHookMethod(
            Activity.class,
            "onCreate",
            android.os.Bundle.class,
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Activity activity = (Activity) param.thisObject;
                    
                    // 设置状态栏和导航栏颜色
                    Window window = activity.getWindow();
                    if (window != null) {
                        try {
                            window.setStatusBarColor(KMT_BLUE);
                            window.setNavigationBarColor(KMT_DARK_BLUE);
                            XposedBridge.log("VIA 国民党主题: Activity主题已应用");
                        } catch (Throwable t) {
                            XposedBridge.log("VIA 国民党主题: 设置窗口颜色失败 - " + t.getMessage());
                        }
                    }
                }
            }
        );
    }
    
    /**
     * Hook View 背景色
     */
    private void hookViewBackgrounds() {
        // Hook setBackgroundColor
        XposedHelpers.findAndHookMethod(
            View.class,
            "setBackgroundColor",
            int.class,
            new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    View view = (View) param.thisObject;
                    int color = (int) param.args[0];
                    
                    // 检测深色背景并替换为国民党蓝
                    if (isDarkColor(color)) {
                        param.args[0] = KMT_BLUE;
                        XposedBridge.log("VIA 国民党主题: 替换深色背景为国民党蓝");
                    }
                }
            }
        );
        
        // Hook setBackground
        XposedHelpers.findAndHookMethod(
            View.class,
            "setBackground",
            Drawable.class,
            new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Drawable drawable = (Drawable) param.args[0];
                    
                    if (drawable instanceof ColorDrawable) {
                        ColorDrawable colorDrawable = (ColorDrawable) drawable;
                        int color = colorDrawable.getColor();
                        
                        if (isDarkColor(color)) {
                            param.args[0] = new ColorDrawable(KMT_BLUE);
                            XposedBridge.log("VIA 国民党主题: 替换深色Drawable为国民党蓝");
                        }
                    }
                }
            }
        );
    }
    
    /**
     * Hook 进度条主题
     */
    private void hookProgressBarTheme() {
        try {
            XposedHelpers.findAndHookMethod(
                "android.widget.ProgressBar",
                lpparam.classLoader,
                "setProgressTintList",
                android.content.res.ColorStateList.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.args[0] = android.content.res.ColorStateList.valueOf(KMT_LIGHT_BLUE);
                        XposedBridge.log("VIA 国民党主题: 进度条颜色已设置");
                    }
                }
            );
        } catch (Throwable t) {
            XposedBridge.log("VIA 国民党主题: ProgressBar Hook失败 - " + t.getMessage());
        }
    }
    
    /**
     * 判断是否为深色
     */
    private boolean isDarkColor(int color) {
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        
        // 计算亮度
        double brightness = (0.299 * red + 0.587 * green + 0.114 * blue);
        
        // 亮度小于128视为深色
        return brightness < 128;
    }
}
