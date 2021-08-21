
#### 配置切入点表达式
```xml
<!--配置切入点表达式 : id属性用于指定表达式的唯一标识。expression属性用于指定表达式内容。
                此标签写在aop:aspect标签内部只能当前切面使用。
                它还可以写在aop:aspect标签外面，此时就变成了所有切面可用。
-->
<aop:pointcut id="pt1" expression="execution(* com.hollay.service.impl.*.*(..))"/>
```

#### 通知类型
前置通知、后置通知、异常通知、最终通知 ----- 见bean.xml

环绕通知： ---- 见Logger.java

