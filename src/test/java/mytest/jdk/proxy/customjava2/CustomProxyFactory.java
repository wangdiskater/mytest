package mytest.jdk.proxy.customjava2;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;

/**
 * @version 1.0
 * @ClassName CustomProxyFactory
 * @Description 手动实现jdk动态代理
 * 原理就是：
 * 1.生成代理对象类的java文件
 * 和目标类都同时实现同一个接口，而代理类需要传入一个invocationHandler，里面包含了目标类，
 * 而且包含了需要进行代理的功能的invoke方法。
 * 2.这个java文件先编译成class文件然后动态加载到jvm中
 * 3.通过反射获取构造方法类然后生成代理对象
 *
 * @Author wangdi
 * @Date 2021/5/4 14:49
 **/

public class CustomProxyFactory {

    private static final String ln = "\r\n";


    public CustomProxyFactory() {
    }

    public static Object getProxy(CustomSmsService target, InvocationHandler invocationHandler) {

        return newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler);
    }

    private static Object newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler invocationHandler) {
        try {
            // 1.根据目标类的接口信息，去动态编写代理对象的源代码（java代码---字符串）
            String sourceCode = generateSourceCode(interfaces);

//			String path = JDKProxyFactory.class.getResource("").getPath();
            String path = CustomSmsServiceImp.class.getResource("").getPath();

            File f = new File(path + "$Proxy18.java");
            FileWriter fw = new FileWriter(f);
            fw.write(sourceCode);
            fw.close();

            // 2.使用JDK自带的API完成javac编译功能，将java源代码编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
//			Iterable<String> options = Arrays.asList("-d", "target");
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 3.使用目标类对应的类加载器完成代理类的class文件的类加载
//			classLoader = target.getClass().getClassLoader();

            Class<?> clazz = classLoader.loadClass("mytest.jdk.proxy.customjava2.$Proxy18");
//			Class<?> clazz = classLoader.loadClass("proxy.target.$Proxy0");
            // 4.而JVM就会根据代理类的class信息创建代理对象。
            Constructor<?> constructor = clazz.getDeclaredConstructor(mytest.jdk.proxy.customjava2.InvocationHandler.class);
            // newInstance第三个参数也有用了
            Object proxy = constructor.newInstance(invocationHandler);

            return proxy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 功能描述 生成代理对象的java文件
     * @author wangdi
     * @date   2021/5/4 14:57
     * @param interfaces
     * @return java.lang.String
     */
    private static String generateSourceCode(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package mytest.jdk.proxy.customjava2;" + ln);
        sb.append("import mytest.jdk.proxy.customjava2.InvocationHandler;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);

        sb.append("public class $Proxy"+18+" implements " );

        for(int i = 0;i<interfaces.length ;i++){
            sb.append(interfaces[0].getName() );
            sb.append(",");
        }
        sb = new StringBuffer(sb.substring(0,sb.length()-1));
        // 去掉最后的,
        sb.append(" { "+ ln);

        sb.append("private InvocationHandler h;" + ln);
        sb.append("public $Proxy"+18+"(InvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        //遍历接口中的方法
        sb.append("private static Method m1;" + ln);


        //遍历接口中的方法
        sb.append("public String sendMsg(String msg) {" + ln);
        sb.append("Object[] args = new Object[]{msg};" + ln);
        sb.append("try {" + ln);
        sb.append("h.invoke(this, m1, args);" + ln);
        sb.append("} catch (Throwable e) {" + ln);
        sb.append("e.printStackTrace();" + ln);
        sb.append("}" + ln);
        sb.append("return msg;" + ln);
        sb.append("}" + ln);

        sb.append("static {" + ln);
        sb.append("try {" + ln);

        //遍历接口中的方法
        sb.append("m1 = Class.forName(\"mytest.jdk.proxy.customjava2.CustomSmsServiceImp\").getDeclaredMethod" +
                "(\"sendMsg\", String.class);" + ln);


        sb.append("} catch (Exception e) {" + ln);
        sb.append("e.printStackTrace();" + ln);
        sb.append("}" + ln);
        sb.append("}" + ln);
        sb.append("}" + ln);

        return sb.toString();
    }
}
