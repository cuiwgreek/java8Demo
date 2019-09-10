package com.cuiwjava.reflects;


import java.lang.reflect.Field;
import java.math.BigDecimal;
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

        //檢查字串否為空白檢
        System.out.println("是否為空白:"+ StringUtils.isEmpty(""));
        System.out.println("A是否為空白:"+StringUtils.isEmpty("A"));
        System.out.println(" 是否為空白:"+StringUtils.isEmpty(" "));
        System.out.println("-------------------------------");
        //字串nvl
        System.out.println("空白　:"+StringUtils.nvl("", "啦啦啦"));
        System.out.println("非空白:"+StringUtils.nvl("AAA", "啦啦啦"));
        System.out.println("-------------------------------");

        //字串是否為數字
        System.out.println("123數字:"+StringUtils.intNvl("123", 0));
        System.out.println("A123數字:"+StringUtils.intNvl("A123", 0));
        System.out.println("-------------------------------");

        //字串是否為數字BigDecimal
        System.out.println("BigDecimal:");
        System.out.println("123數字:"+StringUtils.BigDecimalNvl("123", BigDecimal.ZERO));
        System.out.println("A123數字:"+StringUtils.BigDecimalNvl("A123", BigDecimal.ZERO));
        System.out.println("-------------------------------");

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
            field.get(null);
            Object value = field.get(obj);
                    StringUtils.nvl(value.toString(),null);
            map.put(fieldName, value);
        }
        return map;
    }

}