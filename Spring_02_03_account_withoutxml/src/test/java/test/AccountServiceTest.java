package test;

import com.config.JdbcConfig;
import com.config.SpringConfiguration;
import com.dengjingxu.domint.Account;
import com.dengjingxu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/25
 * @description: com.com.dengjingxu.test
 * @version: 1.0
 */

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合junit的配置：
 *          1.导入spring整合junit的坐标（jar）spring-test
 *          2.使用Junit提供的一个注解把原有的main方法替换掉了，替换成spring提供的@Runwith
 *          3.告知spring的运行器，spring和ioc创建是基于xml还是注解配置类的，并说明位置
 *               @ContextConfiguration:
 *                          localtions: 指定xml文件所在位置，加上classpath关键字，表示在类路径下
 *                          classes： 指定注解类所在位置
 *    当我们使用spring 5.x版本的时候，要求junit的版本为4.12及以上
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService iAccountService;
    @Test
    public void testGetAllAccount(){
       /* ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");*/
       /* ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class*//*, JdbcConfig.class*//*);*/
        List<Account> allAccount = iAccountService.getAllAccount();
        allAccount.stream().forEach(account->{
            System.out.println(account);
        });

    }
    @Test
    public void testGetAccountById(){
        Account accountById = iAccountService.getAccountById(3);
        System.out.println(accountById);
    }
    @Test
    public void testSaveAccount(){
        Account account=new Account();
        account.setAccount_name("xiaohuan");
        account.setAccount_money(4444.1);
        iAccountService.saveAccount(account);
    }
    @Test
    public void testUpdateAccount(){
        iAccountService.updateAccount("xiaohuan222",3333.3,5);
    }
    @Test
    public void testDeleteAccount(){
        iAccountService.deleteAccount(5);
    }

}
