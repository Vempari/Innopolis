package part1.lesson4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.*;


public class Task1 {
    void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = object.getClass();
        Class[] interfaces = clazz.getInterfaces();
        Set<String> proxyClean = new HashSet<>();
        Set<String> proxyOutput = new HashSet<>();

        boolean result = false;
        for(Class cInterface : interfaces) {
            if (cInterface.getName().equals("java.util.Map")) {
                result = true;
                break;
            }
        }

        if (result) {

            Set<?> keySet = ((Map) object).keySet();

            for (Object set : keySet) {
                proxyClean = makeProxyClean(((Map) object).get(set), fieldsToCleanup);
                proxyOutput = makeProxyOutput(((Map) object).get(set), fieldsToOutput);
                cleanObject(((Map) object).get(set), proxyClean);
                outputObject(((Map) object).get(set), proxyOutput);
            }
        } else {
            proxyClean = makeProxyClean(object, fieldsToCleanup);
            proxyOutput = makeProxyClean(object, fieldsToOutput);
            cleanObject(object, proxyClean);
            outputObject(object, proxyOutput);
        }
    }
    public void cleanObject(Object object, Set<String> fieldsToCleanup)
            throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (String fieldsClean : fieldsToCleanup) {
            Field f = clazz.getDeclaredField(fieldsClean);

            if (f.getType().isPrimitive()) {
                f.setAccessible(true);
                f.setInt(object, 0);
            }
            else {
                f.setAccessible(true);
                f.set(object, null);
            }
        }
    }

    public Set<String> makeProxyClean (Object object, Set<String> fieldsToCleanup) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Set<String> proxyClean = new HashSet<>();
        for (Field field : fields) {
            if (fieldsToCleanup.contains(field.getName())) {
                proxyClean.add(field.getName());
            }
        }
        return proxyClean;
    }

    public Set<String> makeProxyOutput (Object object, Set<String> fieldsToOutput) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Set<String> proxyOutput = new HashSet<>();
        for (Field field : fields) {
            if (fieldsToOutput.contains(field.getName())) {
                proxyOutput.add(field.getName());
            }
        }
        return proxyOutput;
    }


    public void outputObject(Object object, Set<String> fieldsToOutput)
            throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (String fieldsOut : fieldsToOutput) {
            Field f = clazz.getDeclaredField(fieldsOut);
            char firstLetter = fieldsOut.charAt(0);
            firstLetter = Character.toUpperCase(firstLetter);

            if (f.getType().isPrimitive()) {
                Method method = clazz.getMethod("get" + firstLetter + fieldsOut.substring(1));
                Integer output = (Integer) method.invoke(object);
                System.out.println(output);
            } else {
                Method method = clazz.getMethod("get" + firstLetter + fieldsOut.substring(1));
                String output = (String) method.invoke(object);
                System.out.println(output);
            }
        }
    }
}
