package com.chason.anti_package_visibility_filtering;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SystemInject {
    private static final String TAG = "Chason-SystemInject";

    /**
     * the visibility of the package returns the interception modification.
     * @param lpparam
     */
    public static void updatePackage(XC_LoadPackage.LoadPackageParam lpparam) {
        /*包的可见性*/
        Class<?> appsFilter = XposedHelpers.findClass("com.android.server.pm.AppsFilter",
                lpparam.classLoader);

        if (appsFilter != null) {
            XposedHelpers.findAndHookMethod(appsFilter, "shouldFilterApplication",
                    int.class,
                    "com.android.server.pm.SettingBase",
                    "com.android.server.pm.PackageSetting",
                    int.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            //TODO this text needs to be replaced with the text you want,
                            // or check the parameters for more information.
                            if (param.args[2].toString().contains("xxxx")) {
                                param.setResult(false);
                            }
                        }
                    });
        }
    }

}
