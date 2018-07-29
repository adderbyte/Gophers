package main

import "fmt"
import "reflect"

type Pair struct {
	a, b interface{}
}

func main() {

	var myOuputPairArray []interface{} // output mon and stats are put into an  array
	p1 := Pair{"finished", 42}
	p2 := Pair{6.1, "hello"}

	myOuputPairArray = append(myOuputPairArray, p1, p2)

	for _, s := range myOuputPairArray {
		t := reflect.ValueOf(s)
		for i := 0; i < t.NumField(); i++ {
			if i == 0 {

				continue
			} else if i == 1 {
				k := t.Field(i)
				fmt.Printf("%v\n", t.Field(i))
				fmt.Sprintf("%T", k)

			}

		}
	}

}
