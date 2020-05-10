package com.dengjingxu.service.impl;


import com.dengjingxu.service.SaveAccount;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/24
 * @description: com.com.dengjingxu.service.impl
 * @version: 1.0
 */
/**
 * 曾经的xml配置：
 *  <bean id="saveAccountDao" class="com.dengjingxu.dao.impl.SaveAccountDaoImpl" scope="" init-method="" destroy-method="">
 *         <property name="" value=""| ref=""></property>
 *    </bean>
 *
 *  注解分类：
 *     用于创建对象的：
 *          它们的作用就和在xml配置文件中编写一个<bean>标签的功能是一样的
 *          Component：
 *              作用：用于把当前类对象存入spring容器中
 *              属性： value 用于指定bean的id,当不写时，默认为当前类首字母小写
 *          Controller:   一般用在表现层
 *          Service:   一般用在业务层
 *          Repository:    一般用在持久层
 *          以上三个注解它们的作用与Component是一模一样的，只是spring框架为我们提供明确的三层使用的注解，使三层对象更加清晰
 *     用于注入数据的：
 *          它们的作用就和在xml配置文件中的bean标签内写一个<property>（setter方法注入）标签的作用是一样的
 *          Autowired:
 *                作用：自动安装类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *                      如果ioc容器中没有如何bean的类型和要注入的变量类型匹配，则报错。
 *                      如果ioc容器中有多个类型匹配：
 *                              1.如果这些类型匹配上的bean的id和要注入的变量名相同，就用这个id的bean注入
 *                              2.如果这些类型匹配上的bean的id和要注入的变量名都不相同，则用Qualifier注解
 *                出现位置：可以是变量上，也可以是方法上
 *                细节：在使用注解注入时，set方法就不是必要的了，因为spring中@autowired标记过的属性的【访问控制检查】
 *                      利用反射机制给关闭了，即对每个属性进行了【setAccessible（true）】的设置
 *          Qualifier:
 *                作用： 在安照类中注入的基础上再按名称注入。它在给类成员注入时不能单独使用，但是在个方法参数注入时可以单独使用
 *                属性：value：用于指定注入bean的id
 *          Resource：
 *                作用： 直接按照bean的id注入，它可以单独使用
 *                属性： name：用于指定bean的id
 *          以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *          另外集合类型的注入只能通过xml配置注入实现
 *
 *          Value：
 *                作用：用于注入基本类型和String类型的数据
 *                属性：value：用于指定数据的值。它可以使用spring中的SqEl（也就是spring中的el表达式）
 *                            SqEl的写法${表达式}
 *     用于改变作用范围的：
 *          它们的作用就和在xml配置文件中bean标签的属性scope一样
 *          Scope:
 *               作用： 用于指定bean的作用范围
 *               位置： 类上
 *               属性： value：指定范围的取值，常用singleton，prototype
 *     和生命周期有关（了解）
 *          它们的作用就和在bean标签中使用init-method和destory-method的作用是一样的
 *          PostConstructor:
 *              作用：指定初始化方法
 *              位置：指定要成为初始化方法的方法上
 *          PreDestroy:
 *              作用：指定销毁方法
 *              位置：指定要成为销毁方法的方法上
 */
@Service("saveAccount")
public class SaveAccountImpl implements SaveAccount {

    //经常变化的数据不适合用注入方式

    private String name;
    private int age;
    private Date date;
    private List list;
    private String []array;
    private Map<String,String > map;

    public void setList(List list) {
        this.list = list;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   /* public SaveAccountImpl(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }*/

    @Override
    public void saveAccount(String account) {
        System.out.println("saveAccount"+":"+name+":"+age+":"+date);
    }


}
