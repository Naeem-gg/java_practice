import java.util.Random;
import java.util. Scanner;
public class square
{
public static void main(String args[])
{
Number n = new Number();
n.start();
}
}

class Square extends Thread
{int x;
Square(int n)
{
x=n;
}
public void run()
{
int sqr = x* x;
System.out.println("Square of "+ x +" =" + sqr );
}
}
class Cube extends Thread
{
int x;
Cube(int n)
{
x =n;
}
public void run()
{
int cub = x * x * x;
System.out.println("Cube of " + x +" =" + cub );
}
}
class Number extends Thread
{
public void run()
{
Scanner sc= new Scanner(System.in);
Random random = new Random();
System.out.println("How many random number you want to generate ?");
int limit=sc.nextInt();
for(int i =0; i<limit; i++)
{
int randomInteger = random.nextInt(100);
System.out.println("\nRandom Integer generated : " + randomInteger);
Square s = new Square(randomInteger);
s.start();
Cube c = new Cube(randomInteger);
c.start();
try
{Thread.sleep(1000);
}
catch (InterruptedException ex)
{
System.out.println(ex);
}
}
}
}
