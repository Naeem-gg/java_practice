import java.util.*;

public class avg_int extends Thread {
    int ar[];
    int sum = 0;

    public avg_int() {
        Random r = new Random();
        ar = new int[100];
        for (int i = 0; i < ar.length; i++)
            ar[i] = r.nextInt(1000);
    }

    public int getSum() {
        return sum;
    }

public void run()
{
int i=0;
while(i<ar.length)
{
sum+=ar[i];
i++;
}
}

public static void main(String[] args) throws InterruptedException
{
avg_int t[]=new avg_int[10];
int sum=0;
for(int i=0;i<t.length;i++)
{
t[i]=new avg_int();
t[i].start();
}
for(int i=0;i<t.length;i++)
{
sum+=t[i].getSum();
t[i].join();
}
System.out.println("Sum of 1000 integer is:\t"+sum);
float f=sum/100;
System.out.println("Average of 1000 integer is:\t"+f);
}
}