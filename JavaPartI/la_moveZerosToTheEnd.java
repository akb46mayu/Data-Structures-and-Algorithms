

import java.util.Arrays;
public class move0 {
	public int[] moveZero(int[] array) {
	    // Write your solution here.
	    if (array.length == 0){
	      return array;
	    }
	    int zero = array.length - 1, i = 0;
	    while (i <= zero){
	      if (array[i] == 0){
		swap(array, i, zero--);
	      }
	      i++;
	    }
	    return array;
	  }  

	private void swap(int[] array, int left, int right){
	int temp = array[left];
	array[left] = array[right];
	array[right] = temp;
	}
	public static void main(String[] args){
	  move0 a = new move0();
	  int[] array = {2,4,1,0,0,7,3};
	  a.moveZero(array);
	  System.out.println(Arrays.toString(array));
	}

}
