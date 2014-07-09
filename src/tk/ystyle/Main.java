package tk.ystyle;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import tk.ystyle.entity.Book;
import tk.ystyle.entity.Order;

import java.io.IOException;
import java.util.*;

public class Main {
    CacheManager manager;//缓存管理器
    Cache cache;//本程序操作的缓存对象

    public static void main(String[] args) {
        Main main = new Main();
        main.init(args);//初始化缓存
        main.menu();//显示菜单
    }

    /**
     * 初始化
     */
    private void init(String[] path) {
        //指定ehcache.xml的位置
        if (path.length > 0) {
            manager = CacheManager.newInstance(path[0]);//new CacheManager(fileName);
        } else {
            manager =CacheManager.newInstance(getClass().getResource("ehcache.xml"));//new CacheManager(fileName);
        }
        System.out.println(manager.getActiveConfigurationText());
        //取出所有的cacheName
        String names[] = manager.getCacheNames();
        for (String name : names) {
            System.out.println(name);//输出所有Cache名称
        }
        cache = manager.getCache("book");//得到本程序操作的cache
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
        System.out.println("4,监控缓存数量(按T退出)");
        System.out.println("5,批量添加数据");
        System.out.println("6,测试命中");
        System.out.println("7,批量添加数据(Order 20列)");
        System.out.println("C,清空缓存");
        System.out.println("Q,退出");
        String str = s.next();
        switch (str) {
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
            case "7":
                addSomeOrders();//批量添加数据(Order 20列)
                break;
            case "C":
                claerCache();//清空缓存
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

    private void claerCache() {
        System.out.println("缓存个数为：" + cache.getSize());
        cache.removeAll();
        cache.flush();
        System.out.println("缓存个数为：" + cache.getSize());
    }

    /**
     * 批量添加数据(Order 20列)
     */
    private void addSomeOrders() {
        Scanner s = new Scanner(System.in);
        System.out.println("添加多少个缓存:");
        long number = s.nextLong();
        long see = System.currentTimeMillis();
        System.out.println("种子为:" + see);
        long start = System.currentTimeMillis();
        for (long i = 0; i < number; i++) {
            Order order = new Order();
            order.setOrderno(see + "" + i);
            order.setType(1);
            order.setApproveuser("用户" + see + "" + 1);
            order.setApuser("用户" + see + "" + 1);
            order.setConsigneeaddress("地址" + see + "" + 1);
            order.setNote(false);
            order.setCrtime(new Date());
            order.setCruser("用户" + see + "" + 1);
            order.setRetono("订单" + see + "" + 1);
            order.setWhcode("仓库" + see + "" + 1);
            order.setStorecode("门店" + see + "" + 1);
            order.setExpresscode("邮编" + see + "" + 1);
            order.setExpressnumber("快递" + see + "" + 1);
            order.setMobile("13800138000");
            order.setConsigneeaddress("固定地址" + see + "" + 1);
            order.setConsigneename("编码" + see + "" + 1);
            order.setShopcode("商店" + see + "" + 1);
            order.setShopname("商店名称" + see + "" + 1);
            order.setTradeid(see + "" + 1);
            order.setReceivedfee(new Double(i));
            cache.put(new Element(order.getOrderno(), order));
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
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
        long see = System.currentTimeMillis();
        System.out.println("种子为:" + see);
        long start = System.currentTimeMillis();
        for (long i = 0; i < number; i++) {
            Book book = new Book();
            book.setName("书名" + see + i);
            book.setAuthor("作者" + i);
            book.setBookno(see + "" + i);
            book.setPrice("100");
            cache.put(new Element(book.getBookno(), book));
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }

    /**
     * 监控缓存数量(不能退出)
     */
    private void monitoring() {
        Timer timer = new Timer();//定时器
        timer.schedule(new TimerTask() {
            @Override
            public void run() {//定时 操作 : 查看缓存个数
                String names[] =manager.getCacheNames();
                for (String name : names) {
                    Cache cache = manager.getCache(name);
                    System.out.println("缓存中的对象数：" + cache.getSize());
                    //得到缓存对象占用内存的大小
                     System.out.println("缓存对象占用内存:"+cache.getMemoryStoreSize());
                    //得到缓存读取的命中次数
                     System.out.println("缓存读取的命中次数:"+cache.getStatistics().cacheHitCount());
                    //得到缓存读取的错失次数
                     System.out.println("缓存读取的错失次数:"+cache.getStatistics().cacheMissCount());
                }
            }
        }, 1L, 1000 * 3l);
        while (true) {
            try {
                int str = System.in.read();
                if (str == (int) 'T') {
                    timer.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * //查看缓存数量
     */
    private void getAll() {
        String names[] = manager.getCacheNames();
        for (String name : names) {
            Cache cache = manager.getCache(name);
            System.out.println("缓存个数为：" + cache.getSize());
            List<String> list = cache.getKeys();
            if (list.size() > 100) {
                System.out.println("由于缓存数量太多，只输出100条");
                for (int i = 0; i < 100; i++) {
                    System.out.println(cache.get(list.get(i)).getObjectValue().toString());
                }
                System.out.println("由于缓存数量太多，只输出100条");
            } else {
                for (String s : list) {
                    System.out.println(cache.get(s).getObjectValue().toString());
                }
            }
            System.out.println("缓存个数为：" + cache.getSize());
        }
    }

    /**
     * 获取一个缓存
     */
    private void get() {
        Scanner s = new Scanner(System.in);
        System.out.println("KEY:");
        String key = s.next();
        Element element = cache.get(key);
        if (element != null) {
            String s1 = element.getObjectValue().toString();
            System.out.println("成功：key:" + key + "->value:" + s1);
            System.out.println("命中：" + element.getHitCount());
        }
    }

    /**
     * 添加缓存
     */
    private void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("KEY:");
        String bookno = s.next();
        System.out.println("NAME:");
        String name = s.next();
        cache.put(new Element(bookno, new Book(bookno, name)));
        System.out.println("成功：KEY:" + bookno + "->value:" + cache.get(bookno).getObjectValue().toString());
    }

    private void closs() {
        manager.shutdown();
    }


}
