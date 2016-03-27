package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr02TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aX = sc.nextInt();
        int aY = sc.nextInt();
        int bX = sc.nextInt();
        int bY = sc.nextInt();
        int cX = sc.nextInt();
        int cY = sc.nextInt();
        int area = aX*(bY - cY) + bX*(cY - aY) + cX*(aY - bY) >> 1;
        if (area < 0){
            area = -area;
        }
        System.out.println(area);
    }
}
