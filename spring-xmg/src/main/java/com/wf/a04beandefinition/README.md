一、什么是 BeanDefinition
BeanDefinition 是 Spring Framework 中定义 Bean 的配置元信息接口 包括
    • Bean 的类名
    • Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
    • 其他 Bean 引用，又可称作合作者（collaborators）或者依赖（dependencies） 
    • 配置设置，比如 Bean 属性（Properties）
    
二、BeanDefinition的元信息(接口)
    •Class:能被实例化的类的全限定名，不能为抽象类
​    •Name:Bean的名称或者id
    •Scope:bean的作用域
    •Constructor arguments:bean的构造器参数(用于依赖注入)
    •Properties:bean属性设置(用于依赖注入)
    •Autowiring mode:bean的自动注入/自动绑定模式
    •Lazy initialization mode:bean的延迟初始化模式(延迟和非延迟)
    •Initialization method:bean初始化回调方法名称
    •Destruction method:bean销毁回调方法名称

三、BeanDefinition的创建
    通过BeanDefinitionBuilder类进行构建
    通过AbstractBeanDefinition和其子类来进行创建

四、Bean的名称(命名bean)
    每一个bean都会存在一个或者多个名称(标记符)，这些标记符在我们的容器中是唯一的。
    通常情况下，一个bean只有一个标记符，但是我们也可以利用alias别名进行标记，别名更具有场景化的命名方法。
    在基于xml的配置元信息中，我们可以利用id或者name进行标记，如果需要多个名称的话，则可以在name标签中使用逗号或者分号进行连写。
    bean的id或者name并非是必须的，当我们在没有设置的时候，容器会为我们的bean自动生成一个默认的名称。
    
五、bean的名称生成器
    BeanNameGenerator接口生成bean的name(2.0.3引入)
    DefaultBeanGenerator:默认通用的BeanNameGenerator实现
    AnnotationBeanNameGenerator:基于注解的BeanNameGenerator实现(2.5)
    
六、注册beanDefinition到IOC容器(是beandefinition不是bean)
    1、xml方式配置元信息
    2、java注解配置元信息(通过配置信息进行操作)
    3、java api配置元信息(通过容器的相关类进行操作)
    
七、实例化bean 
    1、通过构造器（配置元信息：XML、Java 注解和 Java API ）
    2、通过静态工厂方法（配置元信息：XML 和 Java API ）
    3、通过实例工厂方法（配置元信息：XML和 Java API ）
    4、通过 FactoryBean（配置元信息：XML、Java 注解和 Java API ）
    5、通过 ServiceLoaderFactoryBean（配置元信息：XML、Java 注解和 Java API ）
    6、通过 AutowireCapableBeanFactory#createBean(java.lang.Class, int, boolean)
    7、通过 BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)

八、初始化bean
    1、通过@PostContruct注解初始化bean
    2、实现 InitializingBean 接口的 afterPropertiesSet() 方法
    3、自定义初始化方法
        • XML 配置：<bean init-method=”init” ... />
        • Java 注解：@Bean(initMethod=”init”)
        • Java API：AbstractBeanDefinition#setInitMethodName(String)
        
九、延迟初始化Bean
    延迟初始化bean，会导致bean的初始化后置到按需加载中
    • XML 配置：<bean lazy-init=”true” ... />
    • Java 注解：@Lazy(true)
    
十、
    如何注册一个 Spring Bean(通过 BeanDefinition 和外部单体对象来注册)
    什么是 Spring BeanDefinition
    Spring 容器是怎样管理注册 Bean


    
   


