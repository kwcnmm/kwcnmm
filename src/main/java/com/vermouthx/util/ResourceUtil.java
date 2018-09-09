package com.vermouthx.util;

import java.net.URL;

public class ResourceUtil {
    private ResourceUtil() {

    }

    public static URL getResource(String path) {
        return ClassLoader.getSystemClassLoader().getResource(path);
    }
}
