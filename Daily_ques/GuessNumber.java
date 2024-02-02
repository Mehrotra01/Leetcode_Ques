// public class GuessNumber extends GuessGame {
//     public int guessNumber(int n) {
//         int start=1;
//         int end =n;
//         int mid =start+(end-start)/2;
//         while(start<=end){
//             mid =start+(end-start)/2;
//             int res = guess(mid);  // calling the in built function which wil give 0.-1,1
//             if(res==0){
//                 return mid;
//             }else if(res<0){
//                 end = mid-1;
//             }else{
//                 start=mid+1;
//             }
//         }
//         return -1;
//     }
