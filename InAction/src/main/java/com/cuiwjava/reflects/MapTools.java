package com.cuiwjava.reflects;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapTools {

    public static void main(String[] args) throws Exception{
        Car car = new Car();
        car.setId("00000");
        car.setColor("black");
        car.setModel("bmw x5");
        car.setVolume("3.0L");
        car.setYear(2018);

        System.out.println(objectToMap(car));
    }

    /**
     * 将Object对象里面的属性和值转化成Map对象
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String,Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = StringUtils.nvl(field.get(obj));
            map.put(fieldName, value);
        }
        return map;
    }

}