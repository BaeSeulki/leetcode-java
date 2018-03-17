package test;

/**
 * Created by zhouyu on 2017/12/19.
 *
 */
public class string_spilt
{
    public static void main(String[] args)
    {
        String s = "jdbc:mysql://tw-node13063:3316/metastore_sophon1?useUnicode=true&characterEncoding=UTF-8,jdbc:mysql://tw-node1364:3316/metastore_sophon1?useUnicode=true&characterEncoding=UTF-8,jdbc:mysql://tw-node1365:3316/metastore_sophon1?useUnicode=true&characterEncoding=UTF-8";
        String s1 = "jdbc:mysql://tw-node13063:3316/metastore_sophon1?useUnicode=true&characterEncoding=UTF-8";
        String[] a = s1.split(",");
        System.out.println(a[0]);

    }
}
