

实现domain的service类。三种service中，唯一可以写业务逻辑的地方。
由于ddd提倡充血模型的缘故，
我们在建模的时候要尽量避免制造domain service。
尽量把业务逻辑放到其他的domain object中（比如entity, value object中）。