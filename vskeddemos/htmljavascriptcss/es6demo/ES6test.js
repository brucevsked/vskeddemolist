"use strict"

/*-----import [xxx.js]-----*/
import { myName, myAge, myfn, myClass } from "./common.js";

class Es6Test {
  testMap() {
    var m = new Map([['Michael', 95], ['Bob', 75], ['Tracy', 85]]);
    console.log(m.get('Michael'));
    var m = new Map(); // 空Map
    m.set('Adam', 67); // 添加新的key-value
    m.set('Bob', 59);
    m.has('Adam'); // 是否存在key 'Adam': true
    m.get('Adam'); // 67
    m.delete('Adam'); // 删除key 'Adam'
    m.get('Adam'); // undefined
  }

  testFor() {
    var a = ['A', 'B', 'C'];
    var s = new Set(['A', 'B', 'C']);
    var m = new Map([[1, 'x'], [2, 'y'], [3, 'z']]);
    for (var x of a) { // 遍历Array
      console.log(x);
    }
    for (var x of s) { // 遍历Set
      console.log(x);
    }
    for (var x of m) { // 遍历Map
      console.log(x[0] + '=' + x[1]);
    }
  }

  testImport(){
    console.log(myfn());// My name is Tom! I'm 20 years old.
    console.log(myAge);// 20
    console.log(myName);// Tom
    console.log(myClass.a );// yeah!
  }

}

var test = new Es6Test();
test.testMap();
test.testFor();
test.testImport();