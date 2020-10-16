package equation;
import java.util.Scanner;
public class Equation 
{
   static int a,b,c,d;
   static int x1,x2;
   public static void main(String[] args) 
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Введите a: ");
        a = sc.nextInt();
        System.out.println("Введите b: ");
        b = sc.nextInt();
        System.out.println("Введите c: ");
        c = sc.nextInt();
        d = (int) Math.pow (b,2) - (4*a*c);
        System.out.println("Дискриминант: " + d);
        if (d<0)
        {
            System.out.println("У уравнения нет решения");
        }
        else
        {
            if (d>0)
            {
                x1 = (-b + (int)Math.sqrt (d))/(2*a);
                System.out.println("x1 = " + x1);
                x2 = (-b - (int)Math.sqrt (d))/(2*a);
                System.out.println("x2 = " + x2);
            }
            if (d == 0)
            {
                x1 = x2 = (-b)/(2*a);
                System.out.println("x = " + x1);
            }
        }
    }
}
