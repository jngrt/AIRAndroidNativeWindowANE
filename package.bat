@echo off
echo ANE build script
set adt_directory=c:\Program Files (x86)\Adobe\Adobe Flash Builder 4.6\sdks\4.6.0\bin
set root_directory=d:\Projects\android\Android_ANE_native_window
set library_directory=%root_directory%\ANE_window_as3lib
set native_directory=%root_directory%\ANE_window_java
set signing_options=-storetype pkcs12 -keystore cert.p12 -storepass 1234
set dest_ANE=ANEWindowExtension.ane
set extension_XML=%library_directory%\src\extension.xml
set library_SWC=%library_directory%\bin\ANEWindowExtension.swc
set SWF_directory=%library_directory%\bin\Android-ARM
echo start build ...
"%adt_directory%"\adt ^
-package %signing_options% ^
-tsa none ^
-target ane "%dest_ANE%" "%extension_XML%" ^
-swc "%library_SWC%" ^
-platform Android-ARM ^
-C "%native_directory%" ./res ^
-C "%SWF_directory%" library.swf ^
-C "%root_directory%" ANEWindowExtension.jar
echo "build process complete"