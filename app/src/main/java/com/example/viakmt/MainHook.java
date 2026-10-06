package com.example.viakmt;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    
    private static final String VIA_PACKAGE = "mark.via.gp";
    
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(VIA_PACKAGE)) {
            return;
        }
        
        XposedBridge.log("VIA 国民党主题: 开始加载模块");
        
        try {
            ThemeHooker themeHooker = new ThemeHooker(lpparam);
            themeHooker.hook();
            XposedBridge.log("VIA 国民党主题: 主题Hook成功");
        } catch (Throwable t) {
            XposedBridge.log("VIA 国民党主题: Hook失败 - " + t.getMessage());
            XposedBridge.log(t);
        }
    }
}
