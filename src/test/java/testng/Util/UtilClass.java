package testng.Util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class UtilClass {
    private UtilClass(){

    }
    // https://gpcoder.com/2883-huong-dan-su-dung-java-reflection/
    public static final List<String> getFieldNamesByClass(Class<?> clazz){
         return Arrays.stream(clazz.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static final List<String> getFieldNamesByClass(Object object){
        return Arrays.stream(object.getClass().getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    // dynamic class
    public static final void createDynamicClass(String nameClass, Map<String,String> field){

    }

}
