package part1.lesson4;

import javax.imageio.stream.ImageInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.*;


public class Task1 {
    void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (String fields : fieldsToCleanup) {
            Field f = clazz.getDeclaredField(fields);

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
}
