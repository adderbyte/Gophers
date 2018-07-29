package main 

import (
	"fmt"
	"os"
	"log"

)



func main() {
    if len(os.Args) != 2 {
         fmt.Printf("usage: %s [filename]\n", os.Args[0])
         os.Exit(1)
    }
    file, err := os.Open(os.Args[1])
    if err != nil {
	fmt.Println("logging error")
        log.Panic(err)
    }
    fmt.Printf("%s", file)
}
