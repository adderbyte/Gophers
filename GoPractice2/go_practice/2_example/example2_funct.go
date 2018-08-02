package main 


import (
	"fmt"
      //"math/rand"
     //	"math"
)


func add(x int, y int ) int  {
	return x+y
}

func multiply(x,y int) int{
	// function shares types so we can shorten it
	return x*y
}


func main() {
        fmt.Println(add(4,10))
	fmt.Println(multiply(4,10))
}
