# Android 11+ Package Visibility Bypass Hook Module

## Project Introduction

This is an Hook module developed based on the hook framework to bypass the package visibility restrictions introduced in Android 11. Through Hook system functions, it enables access to other application package information without modifying application code.

## Features

### 🎯 Core Features

- Bypass Android 11+ package visibility restrictions
- No need to modify target application code
- Support for all Android 11+ devices
- Compatible with Xposed, Lsposed, Edxposed and other frameworks

### 🔧 Problems Solved

- Resolve \Unable to start service Intent **not found\ errors
- Restore inter-application service call functionality
- Fix third-party application detection issues

## Technical Principles

### Core Hook Points

- **Class**: \com.android.server.am.ActiveServices\
- **Method**: \etrieveServiceLocked()\
- **Key Function**: \shouldFilterApplication()\

### Bypass Mechanism

By Hook the \shouldFilterApplication()\ method and force it to return \alse\, the system's package visibility filtering mechanism is bypassed.


## Technical Background

### Android 11 Package Visibility Restrictions

Android 11 introduced a new package visibility mechanism. By default, applications cannot query information about other installed applications on the device, unless:

- Declare \<queries>\ element in \AndroidManifest.xml\
- Apply for \QUERY_ALL_PACKAGES\ permission (requires special reasons)

### Limitations of Traditional Solutions

- Requires modification of application source code
- Requires repackaging the application
- May be rejected by app stores

## Related Technical Article

For detailed technical principles, implementation methods and source code analysis, please refer to: [Android 11 Package Visibility Bypass Technical Details](https://blog.csdn.net/a_Chaon/article/details/124746530?spm=1001.2014.3001.5501)

## Compatibility

-  Android 11 (API 30)
-  Android 12 (API 31)
-  Android 13 (API 33)
-  Android 14 (API 34)
.....

## Disclaimer

This tool is for learning and research purposes only. Please do not use it for illegal purposes. Users need to bear the risks of use themselves.


---

