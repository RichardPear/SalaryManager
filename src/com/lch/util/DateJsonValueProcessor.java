package com.lch.util;
import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;  
import net.sf.json.processors.JsonValueProcessor;  
  
public class DateJsonValueProcessor implements JsonValueProcessor {  
  
    public Object processArrayValue(Object value, JsonConfig config) {  
        return process(value);  
   }  
  
   public Object processObjectValue(String key, Object value, JsonConfig config) {  
        return process(value);  
    }  
      
   private Object process(Object value){  
       String format ="yyyy-MM-dd HH:mm:ss";  
       if(value instanceof java.sql.Timestamp){  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            return sdf.format(value);  
       }  
       return value == null ? "" : value.toString();  
   }  
}