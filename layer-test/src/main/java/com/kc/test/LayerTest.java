package com.kc.test;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LayerTest {
    public static void main(String[] args) {
        final String CX_LOCATION = "D:\\code\\xuexi\\java\\modules\\layer-info\\target\\layer-info-1.0-SNAPSHOT.jar";
//        final String CX_LOCATION = "libs/layder-info-1.0-SNAPSHOT.jar";
        Path path = Paths.get(CX_LOCATION);
        ModuleFinder beforeFinder = ModuleFinder.of(path);
        Set<ModuleReference> all = beforeFinder.findAll();
        Set<String> collect = all.stream().map(reference -> reference.descriptor().name()).collect(Collectors.toSet());
        ModuleLayer layer = createLayer(path, collect);
        ModuleLayer bootLayer = ModuleLayer.boot();
        testLayer(bootLayer);
        System.out.println();
        testLayer(layer);
    }

    public static ModuleLayer createLayer(Path path, Set<String> root){
        ModuleFinder beforeFinder = ModuleFinder.of(path);
        ModuleFinder afterFinder = ModuleFinder.of();
        Configuration parentConfig = ModuleLayer.boot().configuration();
        Configuration config = parentConfig.resolve(beforeFinder, afterFinder, root);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ModuleLayer parentLayer = ModuleLayer.boot();
        ModuleLayer layer = parentLayer.defineModulesWithOneLoader(config, systemClassLoader);
        if (layer.modules().isEmpty()) System.out.println("no modules find in cx layer");
        return layer;
    }

    public static void testLayer(ModuleLayer layer){
        final String moduleName = "layer.info";
        final String className = "com.kc.info.LayerInfo";
        final String methodName = "printInfo" ;

        try {
            Class<?> aClass = layer.findLoader(moduleName).loadClass(className);
            Object o = aClass.getDeclaredConstructor().newInstance();
            Method declaredMethod = aClass.getDeclaredMethod(methodName);
            declaredMethod.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
