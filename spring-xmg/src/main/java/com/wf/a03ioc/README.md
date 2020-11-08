一、依赖查找
根据 Bean 名称查找
    • 实时查找
    • 延迟查找
根据 Bean 类型查找
    • 单个 Bean 对象
    • 集合 Bean 对象
根据 Java 注解查找
    • 单个 Bean 对象
    • 集合 Bean 对象

根据名称查找的延迟查找中的ObjectFactory,BeanFactory,FactoryBean 他们之间的区别和联系是啥
根据Bean类型查找 单个Bean对象和集合bean对象的时候，在存在类型的多个实例Bean时会进行报错找到多个，可以使用primary进行区别
根据java注解查找Bean的时候，利用的getBeanWithAnnotation



二、依赖注入
 根据 Bean 名称注入
 根据 Bean 类型注入
    • 单个 Bean 对象
    • 集合 Bean 对象
 注入容器內建 Bean 对象
 注入非 Bean 对象
 注入类型
    • 实时注入
    • 延迟注入
    
任何一个有实际意义的应用,都会由两个或者更多的类组成，这些类相互之间进行协作来完成特定的业务逻辑
于是就有了依赖注入。依赖注入更多的是表达类bean与类bean之间的关系，而依赖查找，则是更多的表示获取类bean

类bean的注入方式有手动注入和自动注入，
自动注入又可以根据bean的no,byName,byType,constructor四种方式注入。
我们还可以将内置的bean给注入到我们的类中。


三、Spring IoC 依赖来源
• 自定义 Bean---
• 容器內建 Bean 对象---spring容器内置的一些bean(Environment)
• 容器內建依赖---内建的一些依赖，但是获取不到的

springIOC 依赖的的来源包括三部分 
1、自定义bean，我们所熟知的我们的业务bean，
2、容器内建的暴露bean，spring容器内部定义的暴露出来的bean，我们可以获取的，但是不需要我们定义的，
3、容器内建的内置bean(非bean)，这些bean也是spring容器的一部分，但是我们无法获取，只能是内部使用。



四、spring配置的元信息有哪些
Bean 定义配置
    • 基于 XML 文件
    • 基于 Properties 文件
    • 基于 Java 注解
    • 基于 Java API
IoC 容器配置
    • 基于 XML 文件
    • 基于 Java 注解
    • 基于 Java API 
 外部化属性配置
    • 基于 Java 注解
    
五、BeanFactory 和 ApplicationContext 谁才是 Spring IoC 容器？

BeanFactory 是spring容器的一个底层实现
ApplicationContext 是spring容器的一个应用级别的实现
https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/spring-framework-reference/core.html#beans-introduction

六、ApplicationContext 的作用
ApplicationContext 除了 IoC 容器角色，还有提供：
• 面向切面（AOP）
• 配置元信息（Configuration Metadata）
• 资源管理（Resources）
• 事件（Events）
• 国际化（i18n）
• 注解（Annotations）
• Environment 抽象（Environment Abstraction）

七、如何选择spring ioc容器  BeanFactory 和ApplicationContext
• BeanFactory 是 Spring 底层 IoC 容器
• ApplicationContext 是具备应用特性的 BeanFactory 超集

八、
1、什么是ioc容器
2、beanFactory和factoryBean有什么区别
3、spring的启动有哪些过程



    