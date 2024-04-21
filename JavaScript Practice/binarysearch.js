//This JavaScript code utilizes node.js to run the code in the
//terminal. To run this code type node binarysearch.js in the terminal.

function binarysearch(arr, x, start, end) {
    if (start > end) return -1;                      //Base condition

    var mid = Math.floor((start + end)/2);           //Find the middle index

    if (arr[mid]===x) return mid;                    //Compare mid with given key x

    if(arr[mid] > x)                                 //If element at mid is greater than x,
        return binarysearch(arr, x, start, mid-1);   // search in the left half of mid
    else
        return binarysearch(arr, x, mid+1, end);     // If element at mid is smaller than x,
}                                                    // search in the right half of mid


var arr = [1, 3, 5, 7, 8, 9];
var x = 5;
var result = binarysearch(arr,x,0,arr.length-1);
if (result > -1) {
    document.write("Element found! <br>");
    document.write("In index: " + result + "<br>");
}
else document.write("Element not found! <br>");

x = 6;
result = binarysearch(arr,x,0,arr.length-1);
if (result > -1) {
    document.write("Element found!<br>");
    document.write("In index: " + result + "<br>");
}
else document.write("Element not found!<br>");
