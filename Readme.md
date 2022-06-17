Create a same project as layder-info but change it's static field versiont to 2.0 and put it's modular jar at the location specified [here](https://github.com/kaibocai/module-layer-sample/blob/05f4db394aa5984ea96ab31bca1c03f4a46108ae/layer-test/src/main/java/com/kc/test/LayerTest.java#L16)
Remove the class folder in above layder-info project target folder
Run the project use below command in the target folder of layder-test project
```
java -p "layer-test-1.0-SNAPSHOT.jar;layder-info-1.0-SNAPSHOT.jar" -m layer.test
```
you should say output as 
```
Loading LayerInfo version1.0
Class Version: 1.0
Class Name: com.kc.info.LayerInfo
Class Loader: jdk.internal.loader.ClassLoaders$AppClassLoader@65b54208
Module Name: layer.info
Layer Name: java.datatransfer, jdk.management.jfr, java.compiler, jdk.jdeps, java.security.jgss, jdk.security.auth, jdk.crypto.ec, jdk.internal.opt, jdk.security.jgss, jdk.jlink, jdk.javadoc, jdk.naming.dns, jdk.crypto.cryptoki, jdk.jartool, java.management, java.desktop, jdk.jpackage, jdk.accessibility, layer.info, java.xml.crypto, java.rmi, java.smartcardio, java.xml, jdk.crypto.mscapi, jdk.random, java.security.sasl, jdk.localedata, jdk.unsupported.desktop, java.logging, jdk.naming.rmi, java.naming, java.base, java.prefs, jdk.management, jdk.compiler, jdk.charsets, java.management.rmi, jdk.jfr, layer.test, jdk.zipfs

Loading LayerInfo version2.0
Class Version: 2.0
Class Name: com.kc.info.LayerInfo
Class Loader: jdk.internal.loader.Loader@4783da3f
Module Name: layer.info
Layer Name: layer.info
```
