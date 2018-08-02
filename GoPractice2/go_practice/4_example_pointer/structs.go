package main

import "fmt"

type Vertex struct {

	X int 
	Y int 

}


var (

	v1 = Vertex{1,2}
	v2 = Vertex{X:1}
	v3 = Vertex{}
	p = &Vertex{1,2}


)


func main() {
	fmt.Print("Print Vertex: ")
	fmt.Println(Vertex{1,2})
	
	// initialise vertex
	v := Vertex{1,4}
	v.X = 4
	fmt.Printf("\nInitialised vertex value changed to : %v\n",v.X)
	// Use pointer with vertex 
	p := &v
	p.X = 1e4
	fmt.Printf("\nPointer was used to change the value of struct : %v\n",p.X)

	fmt.Print("\nPrint initialised struct varaiables:")
	fmt.Println(v1,p,v2,v3)

}
