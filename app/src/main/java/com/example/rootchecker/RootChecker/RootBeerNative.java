package com.example.rootchecker.RootChecker;


import android.util.Log;

public class RootBeerNative {

    private static boolean libraryLoaded = false;
    private static final String TAG = "RootBeerNative";

    /**
     * Loads the C/C++ libraries statically
     */
    static {
        try {
            System.loadLibrary("toolChecker");
            libraryLoaded = true;
        } catch (UnsatisfiedLinkError e) {
            Log.d(TAG, "static initializer: "+e);
        }
    }

    public boolean wasNativeLibraryLoaded() {
        return libraryLoaded;
    }

    public native int checkForRoot(Object[] pathArray);

    public native int setLogDebugMessages(boolean logDebugMessages);

}
