package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Address address1 = new Address("rd", "Uf", "Le", "54", null);
        advancedValidate(address1);
    }



    public static List<String> validate(Object object) throws IllegalAccessException {
        var list = new ArrayList<String>();
        for (Field field: object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                var value = field.get(object);
                if (value == null) {
                    list.add(field.getName());
                }
            }
        }
        return list;
    }
    public static Map<String, List<String>> advancedValidate(Object object) throws IllegalAccessException {
        var map = new HashMap<String, List<String>>();
        for (Field field: object.getClass().getDeclaredFields()) {
            var list = new ArrayList<String>();
            if (field.isAnnotationPresent(NotNull.class) && !field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                var value = field.get(object);
                if (value == null) {
                    list.add("cannot be null");
                    map.put(field.getName(), list);
                }
            } else if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                var value = field.get(object);
                if (value != null) {
                    if (value.toString().length() < field.getAnnotation(MinLength.class).minLength()) {
                        list.add("length less than " + field.getAnnotation(MinLength.class).minLength());
                        map.put(field.getName(), list);
                    }
                }
            }
        }
        return map;
    }
}
