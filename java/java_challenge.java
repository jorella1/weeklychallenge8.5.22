import java.util.Arrays;

/* Create a function that takes an array and a number and selectively reverse the order of the array based
 on the number you're given (second argument). If you're given the arguments [1,2,3,4,5,6] and 2, you would
  return the array [2,1, 4,3, 6,5].

Examples

selReverse([1,2,3,4,5,6], 2) ➞ [2,1, 4,3, 6,5]
selReverse([2,4,6,8,10,12,14,16], 3) ➞ [6,4,2, 12,10,8, 16,14]
selReverse([5,7,2,6,0,4,6], 100) ➞ [6,4,0,6,2,7,5]

Notes
If the array you're given can't be broken up into equal parts, just reverse the remaining numbers (see 2nd expample).
If len exceeds the array length, reverse everything.
If len is zero, return the original array. */

class java_challenge{
    public static void main(String args[]){
        int[] testArray = {2,4,6,8,10,12,14,16};
        System.out.println(Arrays.toString(testArray));
        selReverse(testArray, 3);
        System.out.println(Arrays.toString(testArray));
    }
    public static void selReverse(int[] A, int subA){
        //empty array
        if(A.length == 0){
            return;
        }
        //if 2nd param is greater then length, then reverse all
        if(subA > A.length){
            subA = A.length;
        }
        int temp, end, start;
        int remainder = A.length % subA;
        boolean leftovers = A.length % subA != 0;
        for(int i = 0; i < (int) Math.ceil((double) A.length/subA); i++){
            //only for remainder case
            if(i == (int) Math.ceil((double) A.length/subA)-1 && leftovers){
                start = A.length - remainder;
                end = A.length-1;
                for(int j = 0; j < remainder/2; j++){
                    temp = A[start+j];
                    A[start+j] = A[end-j]; 
                    A[end-j] = temp;
                }
            }else{
                //every other case
                for(int k = 0; k < subA/2; k++){
                    start = (i*subA)+k;
                    end = (i*subA)+subA-1-k;
                    temp = A[start];
                    A[start] = A[end];
                    A[end] = temp;           
                }
            }
        }
    }
}
