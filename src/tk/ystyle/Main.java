package tk.ystyle;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import tk.ystyle.entity.Book;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    CacheManager manager;//缓存管理器
    Cache cache;//本程序操作的缓存对象

    public static void main(String[] args) {
        Main main = new Main();
        main.init();//初始化缓存
        main.menu();//显示菜单
    }

    /**
     * 初始化
     */
    private void init() {
        //指定ehcache.xml的位置
        String fileName="D:\\Eclipse\\EhCache\\src\\tk\\ystyle\\ehcache.xml";
        manager = new CacheManager(fileName);
        //取出所有的cacheName
        String names[] = manager.getCacheNames();
        for (String name : names) {
            System.out.println(name);//输出所有Cache名称
        }
        cache=manager.getCache("book");//得到本程序操作的cache
    }

    private void menu() {
        menuItemTop();//显示顶层菜单
        //子菜单
    }

    /**
     * 显示顶层菜单
     */
    private void menuItemTop() {
        Scanner s = new Scanner(System.in);
        System.out.println("1,添加缓存");
        System.out.println("2,获取一个缓存");
        System.out.println("3,查看缓存数量");
        System.out.println("4,监控缓存数量(不能退出)");
        System.out.println("5,批量添加数据");
        System.out.println("6,测试命中");
        System.out.println("Q,退出");
        String str = s.next();
        switch (str){
            case "1":
                add();//添加缓存
                break;
            case "2":
                get();//获取一个缓存
                break;
            case "3":
                getAll();//查看缓存数量
                break;
            case "4":
                monitoring();//监控缓存数量(不能退出)
                break;
            case "5":
                addSomeBooks();//批量添加数据
                break;
            case "6":
                testHitCount();//测试命中
                break;
            case "Q":
                closs();
                System.exit(0);
                break;
            default:
                break;
        }
        menu();//显示菜单
    }

    /**
     * 测试命中
     */
    private void testHitCount() {
        Scanner s = new Scanner(System.in);
        System.out.println("bookno:");
        String bookno = s.next();
        for (int i = 0; i < 10000; i++) {
           cache.get(bookno).getObjectValue().toString();
        }
        System.out.println(cache.get(bookno).getHitCount());
    }

    /**
     * 批量添加缓存
     */
    private void addSomeBooks() {
        Scanner s = new Scanner(System.in);
        System.out.println("添加多少个缓存:");
        long number = s.nextLong();
        int see = Math.round(System.currentTimeMillis());
        System.out.println("种子为:"+see);
        for (long i = 0; i < number; i++) {
            Book book = new Book();
            book.setName("书名"+see+i);
            book.setAuthor("作者"+i);
            book.setBookno(see+""+i);
            book.setPrice("100");
            cache.put(new Element(book.getBookno(),book));
        }
    }

    /**
     * 监控缓存数量(不能退出)
     */
    private void monitoring() {
        Timer timer = new Timer();//定时器
        timer.schedule(new TimerTask() {
            @Override
            public void run() {//定时 操作 : 查看缓存个数
                String names[] = manager.getCacheNames();
                for (String name : names) {
                    Cache cache=manager.getCache(name);
                    System.out.println("缓存个数为："+cache.getSize());
                }
            }
        },1L,1000 * 3l);
    }

    /**
     * //查看缓存数量
     */
    private void getAll() {
        String names[] = manager.getCacheNames();
        for (String name : names) {
            Cache cache=manager.getCache(name);
            System.out.println("缓存个数为："+cache.getSize());
        }
    }

    /**
     * 获取一个缓存
     */
    private void get() {
        Scanner s = new Scanner(System.in);
        System.out.println("key:");
        String key = s.next();
        Element element= cache.get(key);
        if (element != null) {
            String s1 = element.getObjectValue().toString();
            System.out.println("成功：key:"+key+"->value:" + s1);
            System.out.println("命中："+element.getHitCount());
        }
    }

    /**
     * 添加缓存
     */
    private void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("bookno:");
        String bookno = s.next();
        System.out.println("name:");
        String name = s.next();
        cache.put(new Element(bookno,new Book(bookno,name)));
        System.out.println("成功：KEY:"+bookno+"->value:" + cache.get(bookno).getObjectValue().toString());
    }

    private  void  closs(){
        manager.shutdown();
    }


}
