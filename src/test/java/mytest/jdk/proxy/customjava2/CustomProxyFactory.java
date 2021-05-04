package mytest.jdk.proxy.customjava2;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @version 1.0
 * @ClassName CustomProxyFactory
 * @Description 手动实现jdk动态代理
 * 原理就是：
 * 1.生成代理对象类的java文件
 * 和目标类都同时实现同一个接口，而代理类需要传入一个invocationHandler，里面包含了目标类，
 * 而且包含了需要进行代理的功能的invoke方法。
 * 2.这个java文件先编译成class文件然后动态加载到jvm中
 *
 *
 * 3.通过反射获取构造方法类然后生成代理对象
 *
 * @Author wangdi
 * @Date 2021/5/4 14:49
 **/

public class CustomProxyFactory {

    private static final String ln = "\r\n";
    private static final String space = "    ";
    public static final String FILE_NAME = "$Proxy18";

    public CustomProxyFactory() {
    }

    public static Object getProxy(CustomSmsService target, InvocationHandler invocationHandler) {

//        return newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                invocationHandler);

        return newProxyInstance(target,invocationHandler);
    }

    private static Object newProxyInstance(CustomSmsService target, InvocationHandler invocationHandler) {
        Class<? extends CustomSmsService> aClass = target.getClass();

        Class<?>[] interfaces = aClass.getInterfaces();
        ClassLoader classLoader = aClass.getClassLoader();


        try {
            // 1.根据目标类的接口信息，去动态编写代理对象的源代码（java代码---字符串）
            String sourceCode = generateSourceCode(aClass, interfaces);

//			String path = JDKProxyFactory.class.getResource("").getPath();
            String path = CustomSmsServiceImp.class.getResource("").getPath();

            File f = new File(path + FILE_NAME +".java");
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


/*
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
*/

    /**
     * 功能描述 生成代理对象的java文件
     * @author wangdi
     * @date   2021/5/4 14:57
     * @param targetClass
     * @param interfaces
     * @return java.lang.String
     */
    private static String generateSourceCode(Class targetClass, Class<?>[] interfaces) {
        String packageName = targetClass.getPackageName();

        StringBuffer sb = new StringBuffer();
        sb.append("package "+ packageName +";" + ln);

        // 导包
        sb.append("import mytest.jdk.proxy.customjava2.InvocationHandler;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);

        sb.append("public class "+ FILE_NAME + " implements " );

        for(int i = 0;i<interfaces.length ;i++){
            sb.append(interfaces[0].getName() );
            sb.append(",");
        }

        // 去掉最后的,
        sb = new StringBuffer(sb.substring(0,sb.length()-1));
        sb.append(" { "+ ln);

        // 構造函數
        sb.append("private InvocationHandler h;" + ln);
        sb.append("public " + FILE_NAME + "(InvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);


        // 自定义方法假设只继承一个接口
        Class<?> anInterface = interfaces[0];
        sb.append(customMethod(anInterface));

        // 静态代码块获取目标类的方法
        // 遍历接口中的方法
        sb.append("private static Method m1;" + ln);

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

    private static StringBuffer customMethod(Class<?> anInterface) {
        // 假设只有一个方法
        Method[] methods = anInterface.getMethods();
        StringBuffer sb = new StringBuffer();

        for (Method method : methods) {

            String methodName = method.getName();
            String returnTypeName = method.getReturnType().getName();
            Parameter[] parameters = method.getParameters();
            // 拼接参数
            StringBuilder paraSb = new StringBuilder();
            StringBuilder paraNameSb = new StringBuilder();

            for (Parameter parameter : parameters) {
                String parameterTypeName = parameter.getType().getName();
                String parameterName = parameter.getName();
                paraSb.append(parameterTypeName).append(" ").append(parameterName);
                paraSb.append(",");

                paraNameSb.append(parameterName);
                paraNameSb.append(",");
            }
            String substring = paraSb.substring(0, paraSb.length()-1);
            String paraNameStr = paraNameSb.substring(0, paraNameSb.length()-1);
            sb.append("public " + returnTypeName + " " + methodName + "(" + substring + ") {" + ln);

//        sb.append("public String sendMsg(String msg) {" + ln);
            sb.append("Object[] args = new Object[]{" + paraNameStr +"};" + ln);
            sb.append("try {" + ln);
            sb.append("Object result = h.invoke(this, m1, args);" + ln);
            sb.append("return "+ "(" + returnTypeName + ")result" +";" + ln);
            sb.append("} catch (Throwable e) {" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}" + ln);
            // 先返回null
            sb.append("return "+ "null" +";" + ln);
            sb.append("}" + ln);

        }




        return sb;
    }
}
