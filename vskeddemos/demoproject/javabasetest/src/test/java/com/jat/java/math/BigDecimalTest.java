package com.jat.java.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    private static final Logger log = LoggerFactory.getLogger(BigDecimalTest.class);

    @Test
    private void create(){
        /*
         * 原因分析：
         * 1）参数类型为double的构造方法的结果有一定的不可预知性。
         * 有人可能认为在Java中写入newBigDecimal(0.1)所创建的BigDecimal正好等于 0.1（非标度值 1，其标度为 1），
         * 但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。
         * 这是因为0.1无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。
         * 这样，传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。
         * 2）String 构造方法是完全可预知的：写入 newBigDecimal(“0.1”) 将创建一个 BigDecimal，
         * 它正好等于预期的 0.1。因此，比较而言， 通常建议优先使用String构造方法。
         * 3）当double必须用作BigDecimal的源时，请注意，此构造方法提供了一个准确转换；
         * 它不提供与以下操作相同的结果：先使用Double.toString(double)方法，
         * 然后使用BigDecimal(String)构造方法，将double转换为String。要获取该结果，
         * 请使用static valueOf(double)方法。
         */
        BigDecimal a =new BigDecimal(0.1);
        log.info("a values is:{}",a);
        log.info("=====================");
        BigDecimal b =new BigDecimal("0.1");
        log.info("b values is:{}",b);
    }

    @Test
    public void compareTest(){
        /*
         * a = -1,表示bigdemical小于bigdemical2；
         * a = 0,表示bigdemical等于bigdemical2；
         * a = 1,表示bigdemical大于bigdemical2；
         */
        BigDecimal b1=new BigDecimal("60");
        BigDecimal b2=new BigDecimal("5");
        int a=b1.compareTo(b2);
        log.info("b1与b2比较结果:{}",a);
        boolean aresult1=(a>0);
        log.info("b1大于b2{}",aresult1);
        boolean aresult2=(a>=0);
        log.info("b1大于等b2{}",aresult2);

        int b=b2.compareTo(b1);
        log.info("b2与b1比较结果:{}",b);
        boolean bresult1=b<0;
        log.info("b2小于b1{}",bresult1);
        boolean bresult2=(b<=0);
        log.info("b2小于等b1{}",bresult2);

        BigDecimal b3=new BigDecimal(b1.toString());
        int c=b3.compareTo(b1);
        log.info("b3与b1比较结果:{}",c);
        boolean cresult1=(c==0);
        log.info("b3等于b1{}",cresult1);
    }

    @Test
    public void calculate(){
        BigDecimal b1=new BigDecimal("60");
        BigDecimal b2=new BigDecimal("5");

        BigDecimal b1Addb2=b1.add(b2);//+加法
        log.info("b1+b2={}+{}={}",b1,b2,b1Addb2);

        BigDecimal b1Subtractb2=b1.subtract(b2);//-减法
        log.info("b1-b2={}-{}={}",b1,b2,b1Subtractb2);

        BigDecimal b1Multiplyb2=b1.multiply(b2);//*乘法
        log.info("b1*b2={}*{}={}",b1,b2,b1Multiplyb2);

        BigDecimal b1Divideb2=b1.divide(b2);///除法
        log.info("b1/b2={}/{}={}",b1,b2,b1Divideb2);
    }

    @Test
    public void roundTest(){
//        double i = 3.856;
        BigDecimal b1=new BigDecimal("3.555");
        BigDecimal b2=new BigDecimal("3.454");
        log.info("舍掉小数取整:{}={}",b1,b1.intValue());
        log.info("四舍五入取整:{}={}",b1,b1.setScale(0, RoundingMode.HALF_UP));
        log.info("四舍五入取整:{}={}",b2,b2.setScale(0,RoundingMode.HALF_UP));

        log.info("四舍五入保留两位小数:{}={}",b1,b1.setScale(2,RoundingMode.HALF_UP));
        log.info("四舍五入保留两位小数:{}={}",b2,b2.setScale(2,RoundingMode.HALF_UP));

    }

    @Test
    public void roundMode(){
        /*
         * 1、ROUND_UP
         * 始终对非舍弃部分前面的数字加1。
         * 0.1203456789,当精度为3的时候，按照round_up模式，结果是0.121
         * -0.1203456789,当精度为3的时候，按照round_up模式，结果是-0.121
         * 注意：0.1891，当精度为3的时候，按照round_up模式，结果是0.19，自动去掉了9后面的0
         * 而当0.91，当精度为1的时候，按照round_up模式，结果是1.0，保留了唯一一个小数点后面的0
         * 截图好像更加直观一点：大家可以按照我的数据去做试验，（数据都是经过精心筛选的数据）
         */
        //1）精度0时：
        int scale=0;//精度
        log.info("{}",new BigDecimal("1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.90196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.90196789").setScale(scale,RoundingMode.UP));


        //2）精度为1时：
        scale=1;//精度
        log.info("{}",new BigDecimal("1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.90196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.90196789").setScale(scale,RoundingMode.UP));
        //3）精度为2时：
        scale=2;//精度
        log.info("{}",new BigDecimal("1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.90196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.90196789").setScale(scale,RoundingMode.UP));
        //4）精度为3时：
        scale=3;//精度
        log.info("{}",new BigDecimal("1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("1.90196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.0000000").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.00196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.10196789").setScale(scale,RoundingMode.UP));
        log.info("{}",new BigDecimal("-1.90196789").setScale(scale,RoundingMode.UP));

        /*
         * 2、ROUND_DOWN
         * 从不对舍弃部分前面的数字加1，即截短。
         * 0.1203456789,当精度为3的时候，按照round_down模式，结果是0.12，自动去掉了2后面的0
         * -0.1203456789,当精度为3的时候，按照round_down模式，结果是-0.12，自动去掉了2后面的0
         * 注意：0.1891，当精度为3的时候，按照round_down模式，结果是0.189，
         * 而当0.91，当精度为1的时候，按照round_down模式，结果是1.0，保留了唯一一个小数点后面的0
         * 3、ROUND_CEILING
         * 接近正无穷大的舍入模式。
         * 如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;
         * 如果为负，则舍入行为与 ROUND_DOWN 相同。
         * 注意，此舍入模式始终不会减少计算值。
         * 4、ROUND_FLOOR
         * 接近负无穷大的舍入模式。
         * 如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;
         * 如果为负，则舍入行为与 ROUND_UP 相同。
         * 注意，此舍入模式始终不会增加计算值。
         * 5、ROUND_HALF_UP
         * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
         * 如果舍弃部分 >= 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同。
         * 注意，这是我们大多数人在小学时就学过的舍入模式(四舍五入)。
         * 6、ROUND_HALF_DOWN
         * <p>
         * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。
         * 如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同(五舍六入)。
         * 7、ROUND_HALF_EVEN
         * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
         * 如果舍弃部分左边的数字为奇数，则舍入行为与 ROUND_HALF_UP 相同;
         * 如果为偶数，则舍入行为与 ROUND_HALF_DOWN 相同。
         * 注意，在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。
         * 此舍入模式也称为“银行家舍入法”，主要在美国使用。四舍六入，五分两种情况。
         * 如果前一位为奇数，则入位，否则舍去。
         * 以下例子为保留小数点1位，那么这种舍入方式下的结果。
         * 1.15>1.2 1.25>1.2
         * 8、ROUND_UNNECESSARY
         * 断言请求的操作具有精确的结果，因此不需要舍入。
         * 如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException。
         */

    }

    @Test
    public void divideTest1(){
        BigDecimal b1=new BigDecimal(22);
        BigDecimal b2=new BigDecimal(10);
        BigDecimal b3=b1.divide(b2).setScale(0,RoundingMode.CEILING);
        log.info(b3.intValue()+"");
    }
}
