package com.forezp.springbootfirstapplication;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
//        int max=100000000;
//        int i=0;
//        while(true){
//            String uuid=UUID.randomUUID().toString().replace("-", "");
//            FileUtils.write(new File("D:/3.txt"),uuid+"\r\n", Charset.forName("UTF-8"),true);
//            if(i>max)
//                break;
//            if(i%10000==0)
//                System.out.println("已写入:"+i);
//            i++;
//        }
        int b=-128;
        System.out.println(Integer.toBinaryString(b));
//        long start = System.currentTimeMillis();
//        Map<Character,Integer> countMap=new HashMap<>();
//        List<String> lines=FileUtils.readLines(new File("D:/3.txt"),Charset.defaultCharset());
//        for(String line:lines){
//            char[] chars = line.toCharArray();
//            for(char c:chars) {
//                if (countMap.containsKey(c)){
//                    countMap.put(c,countMap.get(c)+1);
//                }else{
//                    countMap.put(c,1);
//                }
//            }
//        }
//        long count=0;
//        Set<Map.Entry<Character, Integer>> entries = countMap.entrySet();
//        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Character, Integer> next = iterator.next();
//            System.out.println(next.getKey()+":"+next.getValue());
//            count+=next.getValue();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("分析花费了:"+(end-start)+"毫秒!共"+count+"个字符");
    }
}
