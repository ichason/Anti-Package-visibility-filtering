package com.chason.anti_package_visibility_filtering;

import android.os.Build;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class AntiHook implements IXposedHookLoadPackage {
    private static final String TAG = "Chason-AntiHook";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        try {
            if (loadPackageParam.packageName.equals("android")) {

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                    return;
                }

                SystemInject.updatePackage(loadPackageParam);
            }
        } catch (Exception e) {
            Log.e(TAG, "systemInject error: " + e.getMessage());
        }
    }
}
