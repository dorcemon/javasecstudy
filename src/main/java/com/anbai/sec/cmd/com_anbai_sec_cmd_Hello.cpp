#include <jni.h>
#include <stdio.h>
#include "com_anbai_sec_cmd_Hello.h"

JNIEXPORT void JNICALL Java_com_anbai_sec_cmd_Hello_helloFromCPP
  (JNIEnv *, jobject){
  printf("%s", "I'm from C Plus Plus");
}