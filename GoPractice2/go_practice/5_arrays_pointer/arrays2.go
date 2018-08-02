package main 

import "fmt"




func main(){

 // array of struct 


 s := []struct{
	i int 
	b bool
	}{
	{2,true},
	{3,false},
	{5,true},


	}

	fmt.Println(s)

}
