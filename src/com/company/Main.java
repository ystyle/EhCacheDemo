package com.company;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    CacheManager manager;
    Cache cache;


    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.menu();

    }

    private void init() {
        //指定ehcache.xml的位置
        String fileName="D:\\Eclipse\\EhCache\\src\\com\\company\\ehcache.xml";
        manager = new CacheManager(fileName);
        //取出所有的cacheName
        String names[] = manager.getCacheNames();
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }
        cache=manager.getCache("kvs");
    }

    private void menu() {
        menuItemTop();
    }

    private void menuItemTop() {
        Scanner s = new Scanner(System.in);
        System.out.println("1,添加缓存");
        System.out.println("2,获取一个缓存");
        System.out.println("3,查看缓存数量");
        System.out.println("4,监控缓存数量(不能退出)");
        System.out.println("5,退出");
        String str = s.next();
        switch (str){
            case "1":
                add();
                menu();
                break;
            case "2":
                get();
                menu();
                break;
            case "3":
                getAll();
                menu();
                break;
            case "4":
                monitoring();
                menu();
                break;
            default:
                closs();
                break;
        }
    }

    private void monitoring() {
        Timer timer = new Timer();//new Timer(()->{},2L,2L);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String names[] = manager.getCacheNames();
                for (String name : names) {
                    Cache cache=manager.getCache(name);
                    System.out.println("缓存个数为："+cache.getSize());
                }
            }
        },1L,1000 * 3l);
    }

    private void getAll() {
        String names[] = manager.getCacheNames();
        for (String name : names) {
            Cache cache=manager.getCache(name);
            System.out.println("缓存个数为："+cache.getSize());
        }
    }

    private void get() {
        Scanner s = new Scanner(System.in);
        System.out.println("key:");
        String key = s.next();
        Element element= cache.get(key);
        if (element == null) {
            String s1 = element.getObjectValue().toString();
            System.out.println("成功：key:"+key+"->value:" + s1);
        }
    }

    private void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("KEY:");
        String key = s.next();
        System.out.println("VALUE:");
        String value = s.next();
        cache.put(new Element(key,value));
        System.out.println("成功：key:"+key+"->value:" + cache.get(key).getObjectValue().toString());
    }

    private  void  closs(){
        manager.shutdown();
    }

    
}
