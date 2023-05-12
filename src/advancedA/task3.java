package advancedA;


public class task3 {
private int[] arr;
private int blueTop, redTop;
public task3(int size) {
    arr = new int[size];
    blueTop = -1;
    redTop = size;
}

public void pushinBlue(int item) {
    if (blueTop + 1 == redTop) 
    {
       System.out.println("Stack full");
       return;
    }
    arr[++blueTop] = item;
}

public void pushinRed(int item) 
{
    if (redTop - 1 == blueTop) 
    {
       System.out.println("Stack full");
       return;
    }
   arr[--redTop] = item;
}

public int pop() {
	
    if (blueTop == -1 && redTop == arr.length) 
    {
       System.out.println("Stack empty");
       return -1;
    }
    
    if (blueTop != -1) 
    {
       return arr[blueTop--];
    }
    else 
    {
       return arr[redTop++];
    }
}

public boolean isEmpty() {
    return blueTop == -1 && redTop == arr.length;
}

public static void main(String[] args) {
    task3 stack = new task3(10);
    stack.pushinBlue(9);
    stack.pushinRed(1);
    stack.pushinBlue(5);
    stack.pushinRed(2);
    stack.pushinBlue(3);
    stack.pushinRed(6);
    stack.pushinBlue(8);
    stack.pushinRed(7);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
}
}