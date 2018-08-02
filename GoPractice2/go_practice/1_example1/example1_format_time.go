package main 


import ( 

	"fmt"
	"math"
	"time"
        "math/rand"
)

func main() {
	var multiplier  = math.Pi 
    	var  rnd_num  = rand.Float64() * multiplier

    	fmt.Printf("I selcted a number: %g " , rnd_num)
	fmt.Println("\n")
  	fmt.Printf("The squre root of the number is %g :", math.Sqrt(rnd_num))
	fmt.Println("\n")
	fmt.Println("All these happened at " , time.Now())



}
