package main 

import  (

	"fmt"
	"math"
)



func sqrt(x float64) string {
  if x < 0 {

	return   sqrt(-x) + "i"

  }

  return fmt.Sprint(math.Sqrt(x))



}

// if with condition before 

func pow (x,n,lim float64) float64 {

	if v := math.Pow(x,n); v < lim {

		return v

	} else {
	fmt.Printf("%g >= %g\n", v, lim)

	}
      return   lim

}


func main() {
	fmt.Println("The answer is \n")
	fmt.Println(sqrt(2), sqrt(-6))
        var  pow_ = pow(3,4,54)

	fmt.Printf("\nThe power computation is: %v \n", pow_)
}
