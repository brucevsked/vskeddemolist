与entity对应的一个概念叫value object

它是一个值，是不可变的，immutable。
没有identifier，也不需要被追踪！

比如java中的字符串和value object的感念很相近。
字符串生成之后就是不可变的。而且也没有什么id来识别它。

当entity的逻辑过多，类变得过大时，
我们可以将一部分逻辑分到value object中。
当然我们也可以在建模的时候就先考虑把一些逻辑放进value object中