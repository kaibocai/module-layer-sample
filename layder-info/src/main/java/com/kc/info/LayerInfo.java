package com.kc.info;

public class LayerInfo {
    private final static String VERSION = "1.0";
    static {
        System.out.println("Loading LayerInfo version" + VERSION);
    }

    public void printInfo(){
        Class cls = this.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        Module module = cls.getModule();
        String name = module.getName();
        ModuleLayer layer = module.getLayer();

        System.out.println("Class Version: " + VERSION);
        System.out.println("Class Name: " + cls.getName());
        System.out.println("Class Loader: " + classLoader);
        System.out.println("Module Name: " + name);
        System.out.println("Layer Name: " + layer);
    }
}
