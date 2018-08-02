package main

import (

    "fmt"
    "math/rand"
    "time"


)


func main() {

 
     // int rnd_num = rand.Intn(16);
     fmt.Println("The first random number ius : ", rand.Intn(16))
     fmt.Println("The second random number  :", rand.Intn(16), "was selected at time: ", time.Now())


}
