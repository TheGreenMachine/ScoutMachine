#include <jni.h>
#include <string>

extern "C"
jstring
Java_android_greenmachine_otih_1oith_com_scoutmachine_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
