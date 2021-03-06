[toc]

### spring中的新注解(关于配置类)

```
@Configuration
     作用：指定当前类是一个配置类
     细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
     
@ComponentScan
      作用：用于通过注解指定spring在创建容器时要扫描的包
      属性：
         value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
                我们使用此注解就等同于在xml中配置了:
                    <context:component-scan base-package="com.hollay"></context:component-scan>
                    
@Bean
      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
      属性:
          name:用于指定bean的id。当不写时，默认值是当前方法的名称
      细节：
          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
          查找的方式和Autowired注解的作用是一样的
          
@Import
      作用：用于导入其他的配置类
      属性：
          value：用于指定其他配置类的字节码。
                 当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
                  
@PropertySource
     作用：用于指定properties文件的位置
     属性：
          value：指定文件的名称和路径。
                 关键字：classpath，表示类路径下
```


### Spring整合junit

##### 分析：
    1、应用程序的入口
           main方法
    2、junit单元测试中，没有main方法也能执行
           junit集成了一个main方法
           该方法就会判断当前测试类中哪些方法有 @Test注解
           junit就让有Test注解的方法执行
    3、junit不会管我们是否采用spring框架
           在执行测试方法时，junit根本不知道我们是不是使用了spring框架
           所以也就不会为我们读取配置文件/配置类创建spring核心容器
    4、由以上三点可知
           当测试方法执行时，没有Ioc容器，就算写了Autowired注解，也无法实现注入

##### 解决方法：Spring整合junit的配置
    1、导入spring整合junit的jar(坐标)
    <dependency>
    	<groupId>org.springframework</groupId>
    	<artifactId>spring-test</artifactId>
    	<version>5.2.12.RELEASE</version>
    </dependency>
            
    2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
            @Runwith
            @RunWith(SpringJUnit4ClassRunner.class)
            
    3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
            @ContextConfiguration
                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
                  classes：指定注解类所在地位置
    
    当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上