interface SampleInterface
{void method1(); void method2(int i); String method3(int i, int j);} 
x = [method1: {println 'method 1'},
    method2: {i -> println 'method 2 with ' + i},
    method3: {i, j -> println "method 3 with $i and $j";
             return "returned from method 3"}
    ] as SampleInterface

x.method1()
x.method2(1)
assert x.method3(1,2) == 'returned from method 3'
