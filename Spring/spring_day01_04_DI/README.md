## spring中的依赖注入 Dependency Injection

[toc]

#### 什么是依赖注入

IOC的作用：
		降低程序间的耦合（依赖关系）。

依赖关系的管理：
		以后都交给spring来维护。

在当前类需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明。

依赖关系的维护：
		 就称之为依赖注入。


#### 依赖注入的数据（三类）

能注入的数据：有三类
* 基本类型和String
* 其他bean类型（在配置文件中或者注解配置过的bean）
* 复杂类型/集合类型


#### 依赖注入的方式（三种）
* 第一种：使用构造函数提供

```apl
构造函数注入：
    使用的标签:constructor-arg
    标签出现的位置：bean标签的内部
    标签中的属性：
        type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
        index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始
        name：用于指定给构造函数中指定名称的参数赋值                                   常用的
        =============以上三个用于指定给构造函数中哪个参数赋值===============================
        value：用于提供基本类型和String类型的数据
        ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象

    优势：
        在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
    弊端：
        改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。
```

* 第二种：使用set方法提供
```apl
set方法注入: 更常用的方式
	涉及的标签：property
	标签出现的位置：bean标签的内部
	标签的属性：
		name：用于指定注入时所调用的set方法名称
		value：用于提供基本类型和String类型的数据
		ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
		
	优势：
		创建对象时没有明确的限制，可以直接使用默认构造函数。
	弊端：
		如果有某个成员必须有值，则获取对象是有可能set方法没有执行。
```

* 第三种：使用注解提供

    见下一节