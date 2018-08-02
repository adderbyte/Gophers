package main

import "fmt"


func main() {

	var a[2]string 

	a[0] = "Hello"
	a[1] = "Babs"
	fmt.Println("Print Element of Array.")
	fmt.Println(a[0],a[1])
	fmt.Println("Print Array: ")
	fmt.Println(a)

	// another way to define an array 
	// note the use of := 
	primes := [6]int{2,3,5,7,11}
	fmt.Println("Another way to initialise array")
	fmt.Println(primes)

	// slicing 
	var s []int = primes[1:4]
	fmt.Print("Testing slicing:")
	fmt.Println(s)

	// slices are references to array

	names := [4]string{
		"Babs",
		"Taylor",
		"Tressot",
		"Juiliana",
		}

	n := names[0:2]
	b := names[1:3]

	fmt.Print("\nSlices are  references not copies:")
	fmt.Println(n,b)

	b[0] = "XXX"
	fmt.Println("\nChange to Slice changes the original : ")
	fmt.Println(n,b)
	fmt.Println(names)



}
