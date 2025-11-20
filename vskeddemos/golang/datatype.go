package main

import "fmt"

func main() {
	var myBool bool = false 
	fmt.Println("myBool:" + fmt.Sprintf("%t", myBool))

	var myInt int = 10
	fmt.Println("myInt:" + fmt.Sprintf("%d", myInt))

	var myFloat float32 = 10.1234567
	fmt.Println("myFloat:" + fmt.Sprintf("%f", myFloat))

	var myString string = "hello world"
	fmt.Println("myString:" + myString)

	// 0-255
	var myUint8 uint8 = 255 
	fmt.Println("my uint8:" + fmt.Sprintf("%d", myUint8))
	// 0-65535
	var myUint16 uint16 = 65535
	fmt.Println("my uint16:" + fmt.Sprintf("%d", myUint16))
	// 0-4294967295
	var myUint32 uint32 = 4294967295
	fmt.Println("my uint32:" + fmt.Sprintf("%d", myUint32))
	// -128 - 127
	var myInt8 int8 = 127
	fmt.Println("my int8:" + fmt.Sprintf("%d", myInt8))
	// -32768 - 32767
	var myInt16 int16 = 32767
	fmt.Println("my int16:" + fmt.Sprintf("%d", myInt16))
	// -2147483648 - 2147483647
	var myInt32 int32 = 2147483647
	fmt.Println("my int32:" + fmt.Sprintf("%d", myInt32))
	// -9223372036854775808 - 9223372036854775807
	var myInt64 int64 = 9223372036854775807
	fmt.Println("my int64:" + fmt.Sprintf("%d", myInt64))

	// float32
	var myFloat32 float32 = 3.01234567890123456789
	fmt.Println("my float32:" + fmt.Sprintf("%f", myFloat32))
	// float64
	var myFloat64 float64 = 3.01234567890123456789
	fmt.Println("my float64:" + fmt.Sprintf("%f", myFloat64))

	var myByte byte = 255
	fmt.Println("my byte:" + fmt.Sprintf("%d", myByte))


	// 声明并初始化一个包含 3 个字符串的数组
	var fruits [3]string
	fruits[0] = "apple"
	fruits[1] = "banana"
	fruits[2] = "cherry"

	// 或者直接声明并初始化
	vegetables := [3]string{"carrot", "broccoli", "spinach"}

	// 使用 ... 自动推断长度
	colors := [...]string{"red", "green", "blue", "yellow"}

	fmt.Println("Fruits:", fruits)
	fmt.Println("Vegetables:", vegetables)
	fmt.Println("Colors:", colors)

	// 声明并初始化一个包含 5 个整数的数组
	var numbersArray1 [5]int
	numbersArray1[0] = 10
	numbersArray1[1] = 20
	numbersArray1[2] = 30
	numbersArray1[3] = 40
	numbersArray1[4] = 50

	// 或者直接声明并初始化
	scores := [4]int{85, 92, 78, 96}

	// 使用 ... 自动推断长度
	temperatures := [...]int{-5, 0, 15, 25, 30}

	fmt.Println("Numbers Array:", numbersArray1)
	fmt.Println("Scores:", scores)
	fmt.Println("Temperatures:", temperatures)

	// 遍历字符串数组
	names := [...]string{"Alice", "Bob", "Charlie"}
	fmt.Println("Names:")
	for i := 0; i < len(names); i++ {
		fmt.Printf("Index %d: %s\n", i, names[i])
	}

	// 使用 range 遍历数字数组
	numbersArray2 := [...]int{1, 2, 3, 4, 5}
	fmt.Println("\nNumbers Array :")
	for index, value := range numbersArray2 {
		fmt.Printf("Index %d: Value %d\n", index, value)
	}
}