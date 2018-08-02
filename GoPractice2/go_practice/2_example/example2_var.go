package main


import "fmt"

// outside a function every statement begins with var

// as illustrated here 


var  python , java bool


var i,j  int = 1,2

var k = 2

const Truth = true
func main(){

// inside use := for initialisation and assigment
//constant cant be declared using :=
	go_lan := true
	fmt.Println(i,j,k, python,java)
	values,values_2 := "golang is ","awesome"

	fmt.Println(go_lan,values, values_2 )
	fmt.Printf("values is of type %T\n", values)
	fmt.Printf("\n Truth is %v \n",Truth)
	fmt.Printf("Values is %q\n",values)
}
