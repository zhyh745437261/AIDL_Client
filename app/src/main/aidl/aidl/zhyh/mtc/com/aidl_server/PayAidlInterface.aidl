// PayAidlInterface.aidl
package aidl.zhyh.mtc.com.aidl_server;

import aidl.zhyh.mtc.com.aidl_server.person;

// Declare any non-default types here with import statements

interface PayAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int calculation(int anInt, int bnInt);
    person getOne();
}
