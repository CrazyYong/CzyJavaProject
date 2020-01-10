package 日期与时间;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Java日期和时间API
 * <p>
 * Java API中关于日期和时间，有三个主要的类：
 * <p>
 * Date：表示时刻，即绝对时间，与年月日无关。
 * Calendar：表示年历，Calendar是一个抽象类，其中表示公历的子类是GregorianCalendar
 * DateFormat：表示格式化，能够将日期和时间与字符串进行相互转换，DateFormat也是一个抽象类，其中最常用的子类是SimpleDateFormat。
 * 还有两个相关的类：
 * <p>
 * TimeZone: 表示时区
 * Locale: 表示国家和语言
 */
public class TimeDataTest {
    public static void main(String[] args) {
        /**
         * 1:Date
         * Date是Java API中最早引入的关于日期的类，一开始，Date也承载了关于年历的角色，但由于不能支持国际化，其中的很多方法都已经过时了，被标记为了@Deprecated，不再建议使用。
         *
         * Date表示时刻，内部主要是一个long类型的值，如下所示：
         * private transient long fastTime;  fastTime表示距离纪元时的毫秒数
         *
         * Date有两个构造方法：
         * public Date(long date) {
         *     fastTime = date;
         * }
         *
         * public Date() {
         *     this(System.currentTimeMillis());
         * }
         * 第一个构造方法，就是根据传入的毫秒数进行初始化，第二个构造方法是默认构造方法，它根据System.currentTimeMillis()的返回值进行初始化。
         * System.currentTimeMillis()是一个常用的方法，它返回当前时刻距离纪元时的毫秒数。
         *
         * Date中的大部分方法都已经过时了，其中没有过时的主要方法有：
         * 返回毫秒数
         * public long getTime()
         *
         * 判断与其他Date是否相同 主要就是比较内部的毫秒数是否相同。
         * public boolean equals(Object obj)
         *
         * 与其他Date进行比较
         * public int compareTo(Date anotherDate)
         * Date实现了Comparable接口，比较也是比较内部的毫秒数，如果当前Date的毫秒数小于参数中的，返回-1，相同返回0，否则返回1。
         *
         * 除了compareTo，还有另外两个方法，与给定日期比较，判断是否在给定日期之前或之后，内部比较的也是毫秒数。
         *
         * public boolean before(Date when)
         * public boolean after(Date when)
         */


        /**
         * 2:TimeZone
         * TimeZone表示时区，它是一个抽象类，有静态方法用于获取其实例。
         */

        /*
         *获取当前的默认时区，代码为：
         *  */
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID());

        /*
         * 默认时区是在哪里设置的呢，可以更改吗？Java中有一个系统属性，user.timezone，保存的就是默认时区，系统属性可以通过System.getProperty获得，如下所示：
         * */
        System.out.println(System.getProperty("user.timezone"));

        /*
        * 系统属性可以在Java启动的时候传入参数进行更改，如
            java -Duser.timezone=Asia/Shanghai xxxx
        * */

        /*
        * TimeZone也有静态方法，可以获得任意给定时区的实例，比如：
            获取美国东部时区
        * */
        TimeZone timeZone = TimeZone.getTimeZone("US/Eastern");
        System.out.println(timeZone.getID());

        /*
         * ID除了可以是名称外，还可以是GMT形式表示的时区，如：
         * */
        TimeZone tz1 = TimeZone.getTimeZone("GMT+08:00");
        System.out.println(tz1.getID());

        /**
         3:国家和语言Locale
         Locale表示国家和语言，它有两个主要参数，一个是国家，另一个是语言，每个参数都有一个代码，不过国家并不是必须的。
         比如说，中国的大陆代码是CN，台湾地区的代码是TW，美国的代码是US，中文语言的代码是zh，英文是en。
         Locale类中定义了一些静态变量，表示常见的Locale，比如：
         Locale.US：表示美国英语
         Locale.ENGLISH：表示所有英语
         Locale.TAIWAN：表示台湾中文
         Locale.CHINESE：表示所有中文
         Locale.SIMPLIFIED_CHINESE：表示大陆中文
         与TimeZone类似，Locale也有静态方法获取默认值，如：
         */
        Locale locale = Locale.getDefault();
        System.out.println(locale.toString());

        /**
         * 4:Calendar
         * Calendar类是日期和时间操作中的主要类，它表示与TimeZone和Locale相关的日历信息，可以进行各种相关的运算。
         *
         * 我们先来看下它的内部组成。
         *
         * 内部组成
         *
         * 与Date类似，Calendar内部也有一个表示时刻的毫秒数，定义为：
         *
         * protected long  time;
         * 除此之外，Calendar内部还有一个数组，表示日历中各个字段的值，定义为：
         *
         * protected int   fields[];
         * 这个数组的长度为17，保存一个日期中各个字段的值，都有哪些字段呢？Calendar类中定义了一些静态变量，表示这些字段，主要有：
         *
         * Calendar.YEAR：表示年
         * Calendar.MONTH：表示月，一月份是0，Calendar同样定义了表示各个月份的静态变量，如Calendar.JULY表示7月。
         * Calendar.DAY_OF_MONTH：表示日，每月的第一天是1。
         * Calendar.HOUR_OF_DAY：表示小时，从0到23。
         * Calendar.MINUTE：表示分钟，0到59。
         * Calendar.SECOND：表示秒，0到59。
         * Calendar.MILLISECOND：表示毫秒，0到999。
         * Calendar.DAY_OF_WEEK：表示星期几，周日是1，周一是2，周六是7，Calenar同样定义了表示各个星期的静态变量，如Calendar.SUNDAY表示周日。
         *
         * 获取Calendar实例
         *
         * Calendar是抽象类，不能直接创建对象，它提供了四个静态方法，可以获取Calendar实例，分别为：
         *
         * public static Calendar getInstance()
         * public static Calendar getInstance(Locale aLocale)
         * public static Calendar getInstance(TimeZone zone)
         * public static Calendar getInstance(TimeZone zone, Locale aLocale)
         *
         * 最终调用的方法都是需要TimeZone和Locale的，如果没有，则会使用上面介绍的默认值。getInstance方法会根据TimeZone和Locale创建对应的Calendar子类对象，
         * 在中文系统中，子类一般是表示公历的GregorianCalendar。
         *
         * getInstance方法封装了Calendar对象创建的细节，TimeZone和Locale不同，具体的子类可能不同，但都是Calendar，这种隐藏对象创建细节的方式，
         * 是计算机程序中一种常见的设计模式，它有一个名字，叫工厂方法，getInstance就是一个工厂方法，它生产对象。
         */

        /*
         * 获取日历信息与new Date()类似，新创建的Calendar对象表示的也是当前时间，
         * 与Date不同的是，Calendar对象可以方便的获取年月日等日历信息。
         * 内部，Calendar会将表示时刻的毫秒数，按照TimeZone和Locale对应的年历，
         * */
        Calendar calendar = Calendar.getInstance();
        System.out.println("year: " + calendar.get(Calendar.YEAR));
        System.out.println("month: " + calendar.get(Calendar.MONTH));
        System.out.println("day: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("hour: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute: " + calendar.get(Calendar.MINUTE));
        System.out.println("second: " + calendar.get(Calendar.SECOND));
        System.out.println("millisecond: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("day_of_week: " + calendar.get(Calendar.DAY_OF_WEEK));

        /*
        * 设置和修改时间
        * Calendar支持根据Date或毫秒数设置时间：
            public final void setTime(Date date)
            public void setTimeInMillis(long millis)
            也支持根据年月日等日历字段设置时间：
            public final void set(int year, int month, int date)
            public final void set(int year, int month, int date, int hourOfDay, int minute)
            public final void set(int year, int month, int date, int hourOfDay, int minute, int second)
            public void set(int field, int value)
        * */

        /*
        * 除了直接设置，Calendar支持根据字段增加和减少时间：
            public void add(int field, int amount)
            amount为正数表示增加，负数表示减少。
            * 比如说，如果想设置Calendar为第二天的下午2点15，代码可以为：
        * */
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_MONTH, 1);
        calendar1.set(Calendar.HOUR_OF_DAY, 14);
        calendar1.set(Calendar.MINUTE, 15);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar1.get(Calendar.HOUR_OF_DAY));


        /*
        * Calendar的这些方法中一个比较方便和强大的地方在于，它能够自动调整相关的字段。
        比如说，我们知道二月份最多有29天，如果当前时间为1月30号，对Calendar.MONTH字段加1，即增加一月，Calendar不是简单的只对月字段加1，那样日期是2月30号，是无效的，Calendar会自动调整为2月最后一天，即2月28或29。
        再比如，设置的值可以超出其字段最大范围，Calendar会自动更新其他字段，如：
        * 相当于增加了46小时。
        * */
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.HOUR_OF_DAY, 48);
        calendar2.add(Calendar.MINUTE, -120);
        System.out.println(calendar2.get(Calendar.DAY_OF_MONTH));

        /*
        * 内部，根据字段设置或修改时间时，Calendar会更新fields数组对应字段的值，但一般不会立即更新其他相关字段或内部的毫秒数的值，
        * 不过在获取时间或字段值的时候，Calendar会重新计算并更新相关字段。
        简单总结下，Calenar做了一项非常繁琐的工作，根据TimeZone和Locale，在绝对时间毫秒数和日历字段之间自动进行转换，
        且对不同日历字段的修改进行自动同步更新。
        * */

        /*
        * 除了add，Calendar还有一个类似的方法：
        public void roll(int field, int amount)
        与add的区别是，这个方法不影响时间范围更大的字段值。比如说：
        *
        * calendar首先设置为13:59，然后分钟字段加3，执行后的calendar时间为14:02。如果add改为roll，即:
            calendar.roll(Calendar.MINUTE, 3);
            则执行后的calendar时间会变为13:02，在分钟字段上执行roll不会改变小时的值。
        * */
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.HOUR_OF_DAY, 13);
        calendar3.set(Calendar.MINUTE, 59);
        calendar3.add(Calendar.MINUTE, 3);

        /*
        * 转换为Date或毫秒数
        * Calendar可以方便得转换为Date或毫秒数 方法是
        * public final Date getTime()
          public long getTimeInMillis()
        * */

        /*
        * Calendar的比较
            与Date类似，Calendar之间也可以进行比较，也实现了Comparable接口，相关方法有：
            public boolean equals(Object obj)
            public int compareTo(Calendar anotherCalendar)
            public boolean after(Object when)
            public boolean before(Object when)
        * */

        /**
         * DateFormat
         * DateFormat类主要在Date和字符串表示之间进行相互转换，它有两个主要的方法：
         * public final String format(Date date)
         * public Date parse(String source)
         * format将Date转换为字符串，parse将字符串转换为Date。
         *
         * DateFormat定义了四个静态变量，表示四种风格，SHORT、MEDIUM、LONG和FULL，还定义了一个静态变量DEFAULT，表示默认风格，值为MEDIUM，不同风格输出的信息详细程度不同。
         */

        /*
        与Calendar类似，DateFormat也是抽象类，也用工厂模式创建对象，提供了多个静态方法创建DateFormat对象，有三类方法：
         * public final static DateFormat getDateTimeInstance()
         * public final static DateFormat getDateInstance()
         * public final static DateFormat getTimeInstance()
        * getDateTimeInstance既处理日期也处理时间，getDateInstance只处理日期，getTimeInstance只处理时间，
        * */
        Calendar calendars = Calendar.getInstance();
        //2016-08-15 14:15:20
        calendars.set(2016, 07, 15, 14, 15, 20);
        System.out.println(DateFormat.getDateTimeInstance()
                .format(calendars.getTime()));
        System.out.println(DateFormat.getDateInstance()
                .format(calendars.getTime()));
        System.out.println(DateFormat.getTimeInstance()
                .format(calendars.getTime()));

        /*
        * 每类工厂方法都有两个重载的方法，接受日期和时间风格以及Locale作为参数：
            DateFormat getDateTimeInstance(int dateStyle, int timeStyle)
            DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)
        * */
        Calendar calendars1 = Calendar.getInstance();
        //2016-08-15 14:15:20
        calendars1.set(2016, 07, 15, 14, 15, 20);
        System.out.println("--"+DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.SHORT, Locale.CHINESE)
                .format(calendars1.getTime()));

        /*
        * DateFormat的工厂方法里，我们没看到TimeZone参数，不过，DateFormat提供了一个setter方法，可以设置TimeZone：
          public void setTimeZone(TimeZone zone)
        * */

        /**
         * SimpleDateFormat
         * SimpleDateFormat是DateFormat的子类，相比DateFormat，它的一个主要不同是，它可以接受一个自定义的模式(pattern)作为参数，这个模式规定了Date的字符串形式。先看个例子：
         */
        Calendar calendars3 = Calendar.getInstance();
        //2016-08-15 14:15:20  输出为:2016年08月15日 星期一 14时15分20秒
        calendars3.set(2016, 07, 15, 14, 15, 20);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒");
        System.out.println(sdf.format(calendars3.getTime()));

        /*
        * SimpleDateFormat有个构造方法，可以接受一个pattern作为参数，这里pattern是：yyyy年MM月dd日 E HH时mm分ss秒

            pattern中的英文字符a-z和A-Z表示特殊含义，其他字符原样输出，这里：

            yyyy：表示四位的年
            MM：表示月，两位数表示
            dd：表示日，两位数表示
            HH：表示24小时制的小时数，两位数表示
            mm：表示分钟，两位数表示
            ss：表示秒，两位数表示
            E：表示星期几
            这里需要特意提醒一下，hh也表示小时数，但表示的是12小时制的小时数，而a表示的是上午还是下午
        * */
        Calendar calendars4 = Calendar.getInstance();
//2016-08-15 14:15:20
        calendars4.set(2016, 07, 15, 14, 15, 20);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
        System.out.println(sdf1.format(calendars4.getTime()));

    }
}
