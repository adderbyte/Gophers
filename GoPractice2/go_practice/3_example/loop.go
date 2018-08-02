package main

import "fmt"


func main () {
	sum := 0
	for i :=0 ; i<10 ; i ++{

		sum += i
	}
	fmt.Println(sum)

// for loop without post and pre condition 
	for ; sum < 100 ;{
		sum += sum
        }
	fmt.Printf("value of sum now:  %v \n", sum)
// use for loop as while statement	
	for sum < 259{
	
		sum += sum 

	}

	fmt.Printf("value of sum lastly: %v \n", sum) 
}

