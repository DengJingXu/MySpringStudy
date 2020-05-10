import com.config.SpringConfiguration;
import com.dengjingxu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: com.com.dengjingxu
 * @date: 2020/5/1
 * @description: com.com.com.dengjingxu
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class testTx {

    @Autowired
    IAccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("zhangsang","lisi",100.0);
    }
}
