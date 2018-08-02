package main 

import "fmt"




type Vertex struct {

	lat, long float64

}


//var m map[string]Vertex


func main() {

   m := make(map[string]Vertex)

   m ["Babs Lab" ]  = Vertex {40.6,34.5}
   m ["Google"] =  Vertex {34,76}
   fmt.Println(m)
	

   var k = map[string]Vertex{
	"Bell Labs": Vertex{
		40.68433, -74.39967,
	},
	"Google": Vertex{
		37.42202, -122.08408,
	},
}

	fmt.Println(k)



	var c = map[string]Vertex{
	"Bell Labs": {40.68433, -74.39967},
	"Google":    {37.42202, -122.08408},
}


	fmt.Println(c)
	

	dict := make(map[string]int)
	dict["score"] = 34
	dict["score2"] = 65

	fmt.Print("doctionary: ")
	fmt.Println(dict["score"])
	
	delete(dict, "score")
	fmt.Println("score key has been deleted")
	fmt.Println(dict)
	v, ok := dict["score"]
	// check if a key is present 
	fmt.Println("The score key value is:",v,". Is 'score' key Present in dictionary?", ok)

}
