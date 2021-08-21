## AOP（面向切面编程）
[toc]

### 概述
AOP简单的说它就是把我们程序重复的代码抽取出来，在需要执行的时候，使用动态代理的技术，
在不修改源码的基础上，对我们的已有方法进行增强。

AOP的实现方式：使用动态代理技术

### AOP相关术语
* Joinpoint(连接点):

所谓连接点是指那些被拦截到的点。在 spring 中,这些点指的是方法,因为 spring 只支持方法类型的连接点。

* Pointcut(切入点):

所谓切入点是指我们要对哪些 Joinpoint 进行拦截的定义。即那些被增强的方法。

* Advice(通知/增强):

所谓通知是指拦截到 Joinpoint 之后所要做的事情就是通知。
通知的类型：前置通知,后置通知,异常通知,最终通知,环绕通知。

* Introduction(引介):

引介是一种特殊的通知在不修改类代码的前提下, Introduction 可以在运行期为类动态地添加一些方
法或 Field。

* Target(目标对象):

代理的目标对象。

* Weaving(织入):

是指把增强应用到目标对象来创建新的代理对象的过程。
spring 采用动态代理织入，而 AspectJ 采用编译期织入和类装载期织入。

* Proxy（代理）:

一个类被 AOP 织入增强后，就产生一个结果代理类。

* Aspect(切面):

是切入点和通知（引介）的结合。
  

### spring中基于XML的AOP
#### 配置步骤
1. 把通知Bean也交给spring来管理
2. 使用aop:config标签表明开始AOP的配置
3. 使用aop:aspect标签表明配置切面
    * id属性：是给切面提供一个唯一标识
    * ref属性：是指定通知类bean的Id。
4. 在aop:aspect标签的内部使用对应标签来配置通知的类型
   * aop:before：表示配置前置通知
        * method属性：用于指定Logger类中哪个方法是前置通知
        * pointcut属性：用于指定切入点表达式，该表达式的含义指的是对业务层中哪些方法增强

#### 切入点表达式的写法：
* 关键字：execution(表达式)
* 表达式：
```$xslt
访问修饰符  返回值  包名.包名.包名...类名.方法名(参数列表)
```
* 标准的表达式写法：
```$xslt
public void com.hollay.service.impl.AccountServiceImpl.saveAccount()
```
* 访问修饰符可以省略
```$xslt
void com.hollay.service.impl.AccountServiceImpl.saveAccount()
```
* 返回值可以使用通配符，表示任意返回值
```$xslt
* com.hollay.service.impl.AccountServiceImpl.saveAccount()
```
* 包名可以使用通配符，表示任意包。但是有几级包，就需要写几个*.
```$xslt
* *.*.*.*.AccountServiceImpl.saveAccount())
```  
* 包名可以使用..表示当前包及其子包
```$xslt
* *..AccountServiceImpl.saveAccount()
``` 
* 类名和方法名都可以使用*来实现通配
```$xslt
 * *..*.*()
```
* 参数列表：
    * 可以直接写数据类型：
        * 基本类型直接写名称 :         int
        * 引用类型写包名.类名的方式 :  java.lang.String
    * 可以使用通配符表示任意类型，但是必须有参数
    * 可以使用..表示有无参数均可，有参数可以是任意类型
    
* 全通配写法：
```$xslt
* *..*.*(..)
```
* 实际开发中切入点表达式的通常写法：
    (切到业务层实现类下的所有方法)
```$xslt
* com.hollay.service.impl.*.*(..)
```
        
